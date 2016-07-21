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
package com.todev.rabbitmqmanagement.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.models.overview.Overview;
import com.todev.rabbitmqmanagement.service.RabbitMqService;
import com.todev.rabbitmqmanagement.widget.QueuedMessagesIndicator;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewActivity extends AppCompatActivity {

  @BindView(R.id.activity_overview)
  View rootView;

  @BindView(R.id.queued_messages_indicator)
  QueuedMessagesIndicator queuedMessagesIndicator;

  private ScheduledExecutorService executorService;

  private RabbitMqService rabbitMqService;

  private TimerTask updateTimerTask = new TimerTask() {
    @Override
    public void run() {
      rabbitMqService.getOverview().enqueue(new OverviewResponseCallback());
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);

    ButterKnife.bind(this);

    initializeRabbitMqService();
  }

  @Override
  protected void onResume() {
    super.onResume();

    animate(queuedMessagesIndicator, rootView);
    initializeScheduler();
    startScheduler();
  }

  @Override
  protected void onPause() {
    super.onPause();

    stopScheduler();
  }

  private void initializeRabbitMqService() {
    SharedPreferences sharedPreferences =
        getApplicationContext().getSharedPreferences(getString(R.string.shared_preferences_key), Context.MODE_PRIVATE);

    String url = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_service_url), "");
    int port = sharedPreferences.getInt(getString(R.string.shared_preferences_last_used_service_port), 15672);
    String login = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_login), "");
    String password = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_password), "");

    rabbitMqService = RabbitMqService.Json.createService(url, port, login, password);
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

  private void animate(@NonNull View view, @NonNull View parent) {
    view.animate().cancel();
    view.setAlpha(0);
    view.setTranslationY(parent.getHeight());
    view.animate().alpha(1f).translationY(0).setDuration(600).setStartDelay(400);
  }

  private void updateQueuedMessagesIndicator(Response<Overview> response) {
    Overview overview = response.body();

    int ready = overview.getQueueTotals().getMessagesReady();
    int unacked = overview.getQueueTotals().getMessagesUnacknowledged();
    int total = overview.getQueueTotals().getMessages();

    queuedMessagesIndicator.updateChart(ready, QueuedMessagesIndicator.SetIndex.READY);
    queuedMessagesIndicator.updateChart(unacked, QueuedMessagesIndicator.SetIndex.UNACKED);
    queuedMessagesIndicator.updateChart(total, QueuedMessagesIndicator.SetIndex.TOTAL);

    queuedMessagesIndicator.updateReadyButton(getString(R.string.activity_overview_button_ready, ready));
    queuedMessagesIndicator.updateUnackedButton(getString(R.string.activity_overview_button_unacked, unacked));
    queuedMessagesIndicator.updateTotalButton(getString(R.string.activity_overview_button_total, total));
  }

  private class OverviewResponseCallback implements Callback<Overview> {

    @Override
    public void onResponse(Call<Overview> call, Response<Overview> response) {
      if (!response.isSuccessful()) {
        return;
      }

      updateQueuedMessagesIndicator(response);
    }

    @Override
    public void onFailure(Call<Overview> call, Throwable t) {
      // Do nothing on error. Just do not update the chart.
    }
  }
}
