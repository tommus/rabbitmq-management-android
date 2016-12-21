/*
 * Copyright (c) 2016 to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.ui.overview;

import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.overview.ObjectTotals;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import com.todev.rabbitmqmanagement.data.network.model.overview.QueueTotals;
import com.todev.rabbitmqmanagement.ui.BaseRxPresenter;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import java8.util.function.Predicate;
import lombok.Setter;
import retrofit2.Response;
import timber.log.Timber;

class OverviewPresenter extends BaseRxPresenter implements OverviewContract.Presenter {
  @Setter OverviewContract.View view;

  private RabbitMqService rabbitMqService;

  private Predicate<QueueTotals> queueTotalsPredicate = queueTotals -> queueTotals != null;

  private Predicate<MessageStats> messageRatesPredicate = messageStats -> messageStats.getPublishDetails() != null &&
      messageStats.getConfirmDetails() != null &&
      messageStats.getPublishInDetails() != null &&
      messageStats.getPublishOutDetails() != null &&
      messageStats.getDeliverGetDetails() != null &&
      messageStats.getRedeliverDetails() != null;

  private Predicate<ObjectTotals> globalCountsPredicate = objectTotals -> objectTotals != null;

  OverviewPresenter(RabbitMqService rabbitMqService) {
    this.rabbitMqService = rabbitMqService;
  }

  @Override
  public void startUpdatingOverview() {
    disposable.add(getIntervalObservable().subscribeOn(getComputationScheduler())
        .observeOn(getObserveScheduler())
        .subscribe(delay -> {
          rabbitMqService.getOverview()
              .subscribeOn(getIoScheduler())
              .observeOn(getObserveScheduler())
              .subscribe(response -> {
                if (isResponseSuccessful(response)) {
                  view.updateQueuedMessages(response.body(), queueTotalsPredicate);
                  view.updateMessageRates(response.body(), messageRatesPredicate);
                  view.updateGlobalCounts(response.body(), globalCountsPredicate);
                }
              }, throwable -> Timber.d("An error occurred while loading fragment_overview details."));
        }));
  }

  @Override
  public void onQueuedMessagesRangeButtonClicked() {
    view.showQueuedMessagesRangeDialogFragment();
  }

  @Override
  public void onMessageRatesRangeButtonClicked() {
    view.showMessageRatesRangeDialogFragment();
  }

  protected Observable<Long> getIntervalObservable() {
    return Observable.interval(0, 1, TimeUnit.SECONDS);
  }

  protected boolean isResponseSuccessful(Response<Overview> response) {
    return response.isSuccessful();
  }
}
