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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.overview.ObjectTotals;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import com.todev.rabbitmqmanagement.data.network.model.overview.QueueTotals;
import com.todev.rabbitmqmanagement.ui.BaseActivity;
import com.todev.rabbitmqmanagement.ui.overview.range.SelectRangeDialogFragment;
import com.todev.rabbitmqmanagement.ui.overview.widget.GlobalCountsIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessageRatesIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.QueuedMessagesIndicator;
import java8.util.function.Predicate;
import javax.inject.Inject;

public class OverviewActivity extends BaseActivity implements OverviewContract.View {
  public static final String TAG_SELECT_RANGE = "Select Range Fragment";

  @Inject RabbitMqService rabbitMqService;

  @BindView(R.id.queued_messages_indicator) QueuedMessagesIndicator queuedMessagesIndicator;
  @BindView(R.id.message_rates_indicator) MessageRatesIndicator messageRatesIndicator;
  @BindView(R.id.global_counts_indicator) GlobalCountsIndicator globalCountsIndicator;

  private OverviewPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(this).getComponent().inject(this);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);

    presenter = new OverviewPresenter(rabbitMqService);
    presenter.setView(this);

    queuedMessagesIndicator.setRangeButtonOnClickListener(v -> presenter.onQueuedMessagesRangeButtonClicked());
    messageRatesIndicator.setRangeButtonOnClickListener(v -> presenter.onMessageRatesRangeButtonClicked());
  }

  @Override
  protected void onResume() {
    super.onResume();

    animate(queuedMessagesIndicator, 0);
    animate(messageRatesIndicator, 1);
    animate(globalCountsIndicator, 2);

    presenter.startUpdatingOverview();
  }

  @Override
  protected void onPause() {
    super.onPause();
    presenter.unsubscribe();
  }

  @Override
  public void showQueuedMessagesRangeDialogFragment() {
    SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
    fragment.setMessagesIndicator(queuedMessagesIndicator);
    fragment.show(getSupportFragmentManager(), TAG_SELECT_RANGE);
  }

  @Override
  public void showMessageRatesRangeDialogFragment() {
    SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
    fragment.setMessagesIndicator(messageRatesIndicator);
    fragment.show(getSupportFragmentManager(), TAG_SELECT_RANGE);
  }

  @Override
  public void updateQueuedMessages(Overview overview, Predicate<QueueTotals> predicate) {
    QueueTotals totals = overview.getQueueTotals();

    if (!predicate.test(totals)) {
      return;
    }

    int ready = totals.getMessagesReady();
    int unacked = totals.getMessagesUnacknowledged();
    int total = totals.getMessages();

    queuedMessagesIndicator.updateChart(ready, QueuedMessagesIndicator.SetIndex.READY.getIndex());
    queuedMessagesIndicator.updateChart(unacked, QueuedMessagesIndicator.SetIndex.UNACKED.getIndex());
    queuedMessagesIndicator.updateChart(total, QueuedMessagesIndicator.SetIndex.TOTAL.getIndex());

    queuedMessagesIndicator.updateReadyButton(getString(R.string.activity_overview_button_ready, ready));
    queuedMessagesIndicator.updateUnackedButton(getString(R.string.activity_overview_button_unacked, unacked));
    queuedMessagesIndicator.updateTotalButton(getString(R.string.activity_overview_button_total, total));
  }

  @Override
  public void updateMessageRates(Overview overview, Predicate<MessageStats> predicate) {
    MessageStats stats = overview.getMessageStats();

    if (!predicate.test(stats)) {
      return;
    }

    float publish = stats.getPublishDetails().getRate();
    float confirm = stats.getConfirmDetails().getRate();
    float publishIn = stats.getPublishInDetails().getRate();
    float publishOut = stats.getPublishOutDetails().getRate();
    float deliver = stats.getDeliverGetDetails().getRate();
    float redeliver = stats.getRedeliverDetails().getRate();

    messageRatesIndicator.updateChart(publish, MessageRatesIndicator.SetIndex.PUBLISH.getIndex());
    messageRatesIndicator.updateChart(confirm, MessageRatesIndicator.SetIndex.CONFIRM.getIndex());
    messageRatesIndicator.updateChart(publishIn, MessageRatesIndicator.SetIndex.PUBLISH_IN.getIndex());
    messageRatesIndicator.updateChart(publishOut, MessageRatesIndicator.SetIndex.PUBLISH_OUT.getIndex());
    messageRatesIndicator.updateChart(deliver, MessageRatesIndicator.SetIndex.DELIVER.getIndex());
    messageRatesIndicator.updateChart(redeliver, MessageRatesIndicator.SetIndex.REDELIVERED.getIndex());

    messageRatesIndicator.updatePublishButton(getString(R.string.activity_overview_button_publish, publish));
    messageRatesIndicator.updateConfirmButton(getString(R.string.activity_overview_button_confirm, confirm));
    messageRatesIndicator.updatePublishInButton(getString(R.string.activity_overview_button_publish_in, publishIn));
    messageRatesIndicator.updatePublishOutButton(getString(R.string.activity_overview_button_publish_out, publishOut));
    messageRatesIndicator.updateDeliverButton(getString(R.string.activity_overview_button_deliver, deliver));
    messageRatesIndicator.updateRedeliveredButton(getString(R.string.activity_overview_button_redelivered, redeliver));
  }

  @Override
  public void updateGlobalCounts(Overview overview, Predicate<ObjectTotals> predicate) {
    ObjectTotals totals = overview.getObjectTotals();

    if (!predicate.test(totals)) {
      return;
    }

    globalCountsIndicator.setExchanges(totals.getExchanges());
    globalCountsIndicator.setQueues(totals.getQueues());
    globalCountsIndicator.setConnections(totals.getConnections());
    globalCountsIndicator.setConsumers(totals.getConsumers());
    globalCountsIndicator.setChannels(totals.getChannels());
  }

  private void animate(@NonNull View view, int order) {
    view.animate().cancel();
    view.setAlpha(0);
    view.animate().alpha(1f).setDuration(600).setStartDelay(400 + order * 300);
  }
}
