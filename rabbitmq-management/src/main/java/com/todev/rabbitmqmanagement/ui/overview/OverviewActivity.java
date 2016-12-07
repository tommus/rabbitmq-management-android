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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.internal.util.Predicate;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.overview.ObjectTotals;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import com.todev.rabbitmqmanagement.data.network.model.overview.QueueTotals;
import com.todev.rabbitmqmanagement.ui.overview.range.SelectRangeDialogFragment;
import com.todev.rabbitmqmanagement.ui.overview.widget.GlobalCountsIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessageRatesIndicator;
import com.todev.rabbitmqmanagement.ui.overview.widget.QueuedMessagesIndicator;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class OverviewActivity extends AppCompatActivity {
  public static final String TAG_SELECT_RANGE = "Select Range Fragment";

  @Inject RabbitMqService rabbitMqService;

  @BindView(R.id.queued_messages_indicator) QueuedMessagesIndicator queuedMessagesIndicator;
  @BindView(R.id.message_rates_indicator) MessageRatesIndicator messageRatesIndicator;
  @BindView(R.id.global_counts_indicator) GlobalCountsIndicator globalCountsIndicator;

  private ScheduledExecutorService executorService;

  private TimerTask updateTimerTask = new TimerTask() {
    @Override
    public void run() {
      Timber.w("Update has been disabled.");
      //rabbitMqService.getOverview().enqueue(new OverviewResponseCallback());
    }
  };

  private Predicate<QueueTotals> queueTotalsPredicate = new Predicate<QueueTotals>() {
    @Override
    public boolean apply(QueueTotals queueTotals) {
      return queueTotals != null;
    }
  };

  private Predicate<MessageStats> ratesPredicate = new Predicate<MessageStats>() {

    @Override
    public boolean apply(MessageStats messageStats) {
      return messageStats.getPublishDetails() != null &&
          messageStats.getConfirmDetails() != null &&
          messageStats.getPublishInDetails() != null &&
          messageStats.getPublishOutDetails() != null &&
          messageStats.getDeliverGetDetails() != null &&
          messageStats.getRedeliverDetails() != null;
    }
  };

  private Predicate<ObjectTotals> objectTotalsPredicate = new Predicate<ObjectTotals>() {
    @Override
    public boolean apply(ObjectTotals objectTotals) {
      return objectTotals != null;
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(this).getComponent().inject(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);

    ButterKnife.bind(this);

    queuedMessagesIndicator.setRangeButtonOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
        fragment.setMessagesIndicator(queuedMessagesIndicator);
        fragment.show(getSupportFragmentManager(), TAG_SELECT_RANGE);
      }
    });

    messageRatesIndicator.setRangeButtonOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SelectRangeDialogFragment fragment = new SelectRangeDialogFragment();
        fragment.setMessagesIndicator(messageRatesIndicator);
        fragment.show(getSupportFragmentManager(), TAG_SELECT_RANGE);
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    animate(queuedMessagesIndicator, 0);
    animate(messageRatesIndicator, 1);
    animate(globalCountsIndicator, 2);

    initializeScheduler();
    startScheduler();
  }

  @Override
  protected void onPause() {
    super.onPause();

    stopScheduler();
  }

  private void initializeScheduler() {
    if (executorService == null || executorService.isShutdown()) {
      executorService = Executors.newSingleThreadScheduledExecutor();
    }
  }

  private void startScheduler() {
    executorService.scheduleAtFixedRate(updateTimerTask, 0, 1, TimeUnit.SECONDS);
  }

  private void stopScheduler() {
    if (!executorService.isShutdown()) {
      executorService.shutdown();
    }
  }

  private void animate(@NonNull View view, int order) {
    view.animate().cancel();
    view.setAlpha(0);
    view.animate().alpha(1f).setDuration(600).setStartDelay(400 + order * 300);
  }

  private void updateQueuedMessagesIndicator(Response<Overview> response) {
    Overview overview = response.body();
    QueueTotals totals = overview.getQueueTotals();

    if (!queueTotalsPredicate.apply(totals)) {
      return;
    }

    int ready = totals.getMessagesReady();
    int unacked = totals.getMessagesUnacknowledged();
    int total = totals.getMessages();

    queuedMessagesIndicator.updateChart(ready, QueuedMessagesIndicator.SetIndex.READY.getIndex());
    queuedMessagesIndicator.updateChart(unacked,
        QueuedMessagesIndicator.SetIndex.UNACKED.getIndex());
    queuedMessagesIndicator.updateChart(total, QueuedMessagesIndicator.SetIndex.TOTAL.getIndex());

    queuedMessagesIndicator.updateReadyButton(
        getString(R.string.activity_overview_button_ready, ready));
    queuedMessagesIndicator.updateUnackedButton(
        getString(R.string.activity_overview_button_unacked, unacked));
    queuedMessagesIndicator.updateTotalButton(
        getString(R.string.activity_overview_button_total, total));
  }

  private void updateMessageRatesIndicator(Response<Overview> response) {
    Overview overview = response.body();
    MessageStats stats = overview.getMessageStats();

    if (!ratesPredicate.apply(stats)) {
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
    messageRatesIndicator.updateChart(publishIn,
        MessageRatesIndicator.SetIndex.PUBLISH_IN.getIndex());
    messageRatesIndicator.updateChart(publishOut,
        MessageRatesIndicator.SetIndex.PUBLISH_OUT.getIndex());
    messageRatesIndicator.updateChart(deliver, MessageRatesIndicator.SetIndex.DELIVER.getIndex());
    messageRatesIndicator.updateChart(redeliver,
        MessageRatesIndicator.SetIndex.REDELIVERED.getIndex());

    messageRatesIndicator.updatePublishButton(
        getString(R.string.activity_overview_button_publish, publish));
    messageRatesIndicator.updateConfirmButton(
        getString(R.string.activity_overview_button_confirm, confirm));
    messageRatesIndicator.updatePublishInButton(
        getString(R.string.activity_overview_button_publish_in, publishIn));
    messageRatesIndicator.updatePublishOutButton(
        getString(R.string.activity_overview_button_publish_out, publishOut));
    messageRatesIndicator.updateDeliverButton(
        getString(R.string.activity_overview_button_deliver, deliver));
    messageRatesIndicator.updateRedeliveredButton(
        getString(R.string.activity_overview_button_redelivered, redeliver));
  }

  private void updateGlobalCountsIndicators(Response<Overview> response) {
    Overview overview = response.body();
    ObjectTotals totals = overview.getObjectTotals();

    if (!objectTotalsPredicate.apply(totals)) {
      return;
    }

    globalCountsIndicator.setExchanges(totals.getExchanges());
    globalCountsIndicator.setQueues(totals.getQueues());
    globalCountsIndicator.setConnections(totals.getConnections());
    globalCountsIndicator.setConsumers(totals.getConsumers());
    globalCountsIndicator.setChannels(totals.getChannels());
  }

  private class OverviewResponseCallback implements Callback<Overview> {

    @Override
    public void onResponse(Call<Overview> call, Response<Overview> response) {
      if (!response.isSuccessful()) {
        return;
      }

      updateQueuedMessagesIndicator(response);
      updateMessageRatesIndicator(response);
      updateGlobalCountsIndicators(response);
    }

    @Override
    public void onFailure(Call<Overview> call, Throwable t) {
      // Do nothing on error. Just do not update the chart.
    }
  }
}
