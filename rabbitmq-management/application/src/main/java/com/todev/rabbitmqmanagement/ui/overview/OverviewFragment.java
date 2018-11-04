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
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.application.RabbitMqManagement;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import co.windly.rabbitmqmanagement.network.model.MessageStats;
import co.windly.rabbitmqmanagement.network.model.overview.ObjectTotals;
import co.windly.rabbitmqmanagement.network.model.overview.Overview;
import co.windly.rabbitmqmanagement.network.model.overview.QueueTotals;
import com.todev.rabbitmqmanagement.ui.BaseFragment;
import com.todev.rabbitmqmanagement.ui.overview.range.SelectRangeDialogFragment;
import com.todev.rabbitmqmanagement.ui.overview.widget.GlobalCountsIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessageRatesIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.QueuedMessagesIndicator;
import java8.util.Optional;
import java8.util.function.Predicate;
import javax.inject.Inject;

public class OverviewFragment extends BaseFragment implements OverviewContract.View {
  public static final String TAG_SELECT_RANGE = "Select Range Fragment";

  private static final Runnable NOP_RUNNABLE = () -> {
    // Null Object Pattern.
  };

  @Inject RabbitMqService rabbitMqService;

  @BindView(R.id.queued_messages_indicator) QueuedMessagesIndicator queuedMessagesIndicator;
  @BindView(R.id.message_rates_indicator) MessageRatesIndicator messageRatesIndicator;
  @BindView(R.id.global_counts_indicator) GlobalCountsIndicator globalCountsIndicator;

  private Runnable onConnectionsRunnable = NOP_RUNNABLE;
  private Runnable onChannelsRunnable = NOP_RUNNABLE;
  private Runnable onExchangesRunnable = NOP_RUNNABLE;
  private Runnable onQueuesRunnable = NOP_RUNNABLE;
  private Runnable onConsumersRunnable = NOP_RUNNABLE;

  private OverviewPresenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    RabbitMqManagement.get(getContext()).getComponent().inject(this);
    super.onCreate(savedInstanceState);
    presenter = new OverviewPresenter(rabbitMqService);
    presenter.setView(this);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_overview, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    queuedMessagesIndicator.setRangeButtonOnClickListener(v -> presenter.onQueuedMessagesRangeButtonClicked());
    messageRatesIndicator.setRangeButtonOnClickListener(v -> presenter.onMessageRatesRangeButtonClicked());
    globalCountsIndicator.getChannelsCardView().setOnClickListener(v -> onChannelsRunnable.run());
    globalCountsIndicator.getConnectionsCardView().setOnClickListener(v -> onConnectionsRunnable.run());
    globalCountsIndicator.getConsumersCardView().setOnClickListener(v -> onConsumersRunnable.run());
    globalCountsIndicator.getExchangesCardView().setOnClickListener(v -> onExchangesRunnable.run());
    globalCountsIndicator.getQueuesCardView().setOnClickListener(v -> onQueuesRunnable.run());
  }

  @Override
  public void onStart() {
    super.onStart();

    animate(queuedMessagesIndicator, 0);
    animate(messageRatesIndicator, 1);
    animate(globalCountsIndicator, 2);

    presenter.startUpdatingOverview();
  }

  @Override
  public void onStop() {
    super.onStop();
    presenter.unsubscribe();
  }

  @Override
  public void showQueuedMessagesRangeDialogFragment() {
    SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
    fragment.setMessagesIndicator(queuedMessagesIndicator);
    fragment.show(getFragmentManager(), TAG_SELECT_RANGE);
  }

  @Override
  public void showMessageRatesRangeDialogFragment() {
    SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
    fragment.setMessagesIndicator(messageRatesIndicator);
    fragment.show(getFragmentManager(), TAG_SELECT_RANGE);
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

    queuedMessagesIndicator.getReadyButton().setText(getString(R.string.activity_overview_button_ready, ready));
    queuedMessagesIndicator.getUnackedButton().setText(getString(R.string.activity_overview_button_unacked, unacked));
    queuedMessagesIndicator.getTotalButton().setText(getString(R.string.activity_overview_button_total, total));
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

    messageRatesIndicator.getPublishButton().setText(getString(R.string.activity_overview_button_publish, publish));
    messageRatesIndicator.getConfirmButton().setText(getString(R.string.activity_overview_button_confirm, confirm));
    messageRatesIndicator.getPublishInButton().setText(getString(R.string.activity_overview_button_publish_in, publishIn));
    messageRatesIndicator.getPublishOutButton().setText(getString(R.string.activity_overview_button_publish_out, publishOut));
    messageRatesIndicator.getDeliverButton().setText(getString(R.string.activity_overview_button_deliver, deliver));
    messageRatesIndicator.getRedeliveredButton().setText(getString(R.string.activity_overview_button_redelivered, redeliver));
  }

  @Override
  public void updateGlobalCounts(Overview overview, Predicate<ObjectTotals> predicate) {
    ObjectTotals totals = overview.getObjectTotals();

    if (!predicate.test(totals)) {
      return;
    }

    globalCountsIndicator.getExchangesTextView().setText(String.valueOf(totals.getExchanges()));
    globalCountsIndicator.getQueuesTextView().setText(String.valueOf(totals.getQueues()));
    globalCountsIndicator.getConnectionsTextView().setText(String.valueOf(totals.getConnections()));
    globalCountsIndicator.getConsumersTextView().setText(String.valueOf(totals.getConsumers()));
    globalCountsIndicator.getChannelsTextView().setText(String.valueOf(totals.getChannels()));
  }

  @Override
  public void setOnConnectionsRunnable(Runnable runnable) {
    this.onConnectionsRunnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
  }

  @Override
  public void setOnChannelsRunnable(Runnable runnable) {
    this.onChannelsRunnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
  }

  @Override
  public void setOnExchangesRunnable(Runnable runnable) {
    this.onExchangesRunnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
  }

  @Override
  public void setOnQueuesRunnable(Runnable runnable) {
    this.onQueuesRunnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
  }

  @Override
  public void setOnConsumersRunnable(Runnable runnable) {
    this.onConsumersRunnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
  }

  private void animate(@NonNull View view, int order) {
    view.animate().cancel();
    view.setAlpha(0);
    view.animate().alpha(1f).setDuration(600).setStartDelay(400 + order * 300);
  }
}
