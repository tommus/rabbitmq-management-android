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

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java8.util.function.Predicate;
import org.junit.Test;
import org.mockito.Mock;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OverviewPresenterTest extends BaseTest {
  @Mock OverviewContract.View view;
  @Mock RabbitMqService rabbitMqService;

  private OverviewPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = spy(new OverviewPresenter(rabbitMqService));
    presenter.setView(view);
  }

  @Test
  public void should_get_overview_after_starting_to_update() {
    // Given
    Response<Overview> response = Response.success(new Overview());
    doReturn(Observable.just(1L)).when(presenter).getIntervalObservable();
    doReturn(Schedulers.trampoline()).when(presenter).getComputationScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(response)).when(rabbitMqService).getOverview();
    doReturn(false).when(presenter).isResponseSuccessful(response);

    // When
    presenter.startUpdatingOverview();

    // Then
    verify(rabbitMqService).getOverview();
  }

  @Test
  public void should_update_indicators_on_sucessful_call() {
    // Given
    Response<Overview> response = Response.success(new Overview());
    doReturn(Observable.just(1L)).when(presenter).getIntervalObservable();
    doReturn(Schedulers.trampoline()).when(presenter).getComputationScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(response)).when(rabbitMqService).getOverview();
    doReturn(true).when(presenter).isResponseSuccessful(response);

    // When
    presenter.startUpdatingOverview();

    // Then
    verify(view).updateQueuedMessages(eq(response.body()), any(Predicate.class));
    verify(view).updateMessageRates(eq(response.body()), any(Predicate.class));
    verify(view).updateGlobalCounts(eq(response.body()), any(Predicate.class));
  }

  @Test
  public void should_not_update_indicators_on_unsucessful_call() {
    // Given
    Response<Overview> response = Response.success(new Overview());
    doReturn(Observable.just(1L)).when(presenter).getIntervalObservable();
    doReturn(Schedulers.trampoline()).when(presenter).getComputationScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(response)).when(rabbitMqService).getOverview();
    doReturn(false).when(presenter).isResponseSuccessful(response);

    // When
    presenter.startUpdatingOverview();

    // Then
    verify(view, times(0)).updateQueuedMessages(eq(response.body()), any(Predicate.class));
    verify(view, times(0)).updateMessageRates(eq(response.body()), any(Predicate.class));
    verify(view, times(0)).updateGlobalCounts(eq(response.body()), any(Predicate.class));
  }

  @Test
  public void should_show_queued_messages_range_dialog_fragment_on_dedicated_button_click() {
    // When
    presenter.onQueuedMessagesRangeButtonClicked();

    // Then
    verify(view).showQueuedMessagesRangeDialogFragment();
  }

  @Test
  public void should_show_message_rates_range_dialog_fragment_on_dedicated_button_click() {
    // When
    presenter.onMessageRatesRangeButtonClicked();

    // Then
    verify(view).showMessageRatesRangeDialogFragment();
  }
}
