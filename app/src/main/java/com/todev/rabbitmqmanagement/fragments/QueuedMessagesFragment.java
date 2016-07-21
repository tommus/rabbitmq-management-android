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
package com.todev.rabbitmqmanagement.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.models.overview.Overview;
import com.todev.rabbitmqmanagement.models.overview.QueueTotals;
import com.todev.rabbitmqmanagement.service.RabbitMqService;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueuedMessagesFragment extends Fragment {

  private static final int DATA_READY_INDEX = 0;

  private static final int DATA_UNACKED_INDEX = 1;

  private static final int DATA_TOTAL_INDEX = 2;

  @BindView(R.id.queued_messages_line_chart)
  LineChart queuedMessagesLineChart;

  @BindView(R.id.messages_ready_button)
  Button messagesReadyButton;

  @BindView(R.id.messages_unacked_button)
  Button messagesUnackedButton;

  @BindView(R.id.messages_total_button)
  Button messagesTotalButton;

  private RabbitMqService rabbitMqService;

  private ScheduledExecutorService executorService;

  private TimerTask updateTimerTask = new TimerTask() {
    @Override
    public void run() {
      rabbitMqService.getOverview().enqueue(new OverviewResponseCallback());
    }
  };

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_queued_messages, container, false);

    ButterKnife.bind(this, view);

    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initializeRabbitMqService();
    initializeQueuedMessagesChart();
  }

  @Override
  public void onResume() {
    super.onResume();

    initializeScheduler();
    startScheduler();
  }

  @Override
  public void onPause() {
    super.onPause();

    stopScheduler();
  }

  @OnClick(R.id.messages_ready_button)
  protected void onReadyMessagesButtonClicked(View view) {
    toggleSetVisibility(DATA_READY_INDEX);
  }

  @OnClick(R.id.messages_unacked_button)
  protected void onUnackedMessagesButtonClicked(View view) {
    toggleSetVisibility(DATA_UNACKED_INDEX);
  }

  @OnClick(R.id.messages_total_button)
  protected void onTotalMessagesButtonClicked(View view) {
    toggleSetVisibility(DATA_TOTAL_INDEX);
  }

  private void initializeRabbitMqService() {
    SharedPreferences sharedPreferences =
        getContext().getSharedPreferences(getString(R.string.shared_preferences_key), Context.MODE_PRIVATE);

    String url = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_service_url), "");
    int port = sharedPreferences.getInt(getString(R.string.shared_preferences_last_used_service_port), 15672);
    String login = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_login), "");
    String password = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_password), "");

    rabbitMqService = RabbitMqService.Json.createService(url, port, login, password);
  }

  private void initializeQueuedMessagesChart() {
    queuedMessagesLineChart.getLegend().setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
    queuedMessagesLineChart.setDescription("");
    queuedMessagesLineChart.setNoDataTextDescription(getString(R.string.activity_overview_no_data));
    queuedMessagesLineChart.setTouchEnabled(false);
    queuedMessagesLineChart.setDragEnabled(false);
    queuedMessagesLineChart.setPinchZoom(false);
    queuedMessagesLineChart.getLegend().setEnabled(false);
    queuedMessagesLineChart.getAxisLeft().setAxisMinValue(0);
    queuedMessagesLineChart.getAxisLeft().setGranularity(1f);
    queuedMessagesLineChart.getAxisRight().setEnabled(false);
    queuedMessagesLineChart.getXAxis().setAxisMinValue(0);
    queuedMessagesLineChart.getXAxis().setGranularity(1f);
    queuedMessagesLineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    queuedMessagesLineChart.getXAxis().setValueFormatter(new DefaultAxisValueFormatter(0));

    LineData data = new LineData();
    data.setValueTextColor(Color.WHITE);
    queuedMessagesLineChart.setData(data);
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

  private void updateQueuedMessagesChart(int value, int index, int color) {
    LineData data = queuedMessagesLineChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index);

    if (set == null) {
      set = createSet(color);
      data.addDataSet(set);
    }

    data.addEntry(new Entry(set.getEntryCount(), value), index);
    data.notifyDataChanged();

    queuedMessagesLineChart.notifyDataSetChanged();
    queuedMessagesLineChart.setVisibleXRangeMaximum(6);
    queuedMessagesLineChart.moveViewToX(data.getEntryCount());
  }

  private void updateQueuedMessagesButtons(@NonNull final QueueTotals totals) {
    messagesReadyButton.setText(getString(R.string.activity_overview_button_ready, totals.getMessagesReady()));
    messagesUnackedButton.setText(
        getString(R.string.activity_overview_button_unacked, totals.getMessagesUnacknowledged()));
    messagesTotalButton.setText(getString(R.string.activity_overview_button_total, totals.getMessages()));
  }

  private LineDataSet createSet(int color) {
    LineDataSet set = new LineDataSet(null, "");
    set.setColor(color);
    set.setCircleColor(color);
    set.setCircleRadius(4f);
    set.setFillColor(color);
    set.setValueTextColor(color);
    set.setValueFormatter(new DefaultValueFormatter(0));
    set.setValueTextSize(12f);
    set.setDrawValues(true);
    return set;
  }

  private void toggleSetVisibility(int index) {
    LineData data = queuedMessagesLineChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index);

    if (set == null) {
      return;
    }

    set.setVisible(!set.isVisible());
    set.setDrawValues(!set.isDrawValuesEnabled());
  }

  private class OverviewResponseCallback implements Callback<Overview> {

    @Override
    public void onResponse(Call<Overview> call, Response<Overview> response) {
      if (!response.isSuccessful()) {
        return;
      }

      Overview overview = response.body();

      updateQueuedMessagesChart(overview.getQueueTotals().getMessagesReady(), DATA_READY_INDEX,
          ContextCompat.getColor(getContext(), R.color.indicator_messages_ready));

      updateQueuedMessagesChart(overview.getQueueTotals().getMessagesUnacknowledged(), DATA_UNACKED_INDEX,
          ContextCompat.getColor(getContext(), R.color.indicator_messages_unacked));

      updateQueuedMessagesChart(overview.getQueueTotals().getMessages(), DATA_TOTAL_INDEX,
          ContextCompat.getColor(getContext(), R.color.indicator_messages_total));

      updateQueuedMessagesButtons(overview.getQueueTotals());
    }

    @Override
    public void onFailure(Call<Overview> call, Throwable t) {
      // Do nothing on error. Just do not update the chart.
    }
  }
}
