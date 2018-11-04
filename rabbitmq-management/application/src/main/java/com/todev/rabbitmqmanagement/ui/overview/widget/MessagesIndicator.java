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
package com.todev.rabbitmqmanagement.ui.overview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.todev.rabbitmqmanagement.R;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

public abstract class MessagesIndicator extends FrameLayout {
  @Getter String title;
  @Getter int defaultColor;
  @Getter boolean valuesVisible;
  @Getter String idleText;
  @Getter VisibleRange visibleRange;
  protected TextView titleTextView;
  protected ImageButton rangeButton;
  @Getter @Setter LineChart messagesChart;

  public MessagesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);

    inflate(context, getLayout(), this);
    initializeAttributes(context, attrs);
    initializeWidgets();
    initializeChart();
    initializeCallbacks();
  }

  public void setTitle(String title) {
    this.title = title;
    invalidate();
    requestLayout();
  }

  public void setDefaultColor(int defaultColor) {
    this.defaultColor = defaultColor;
    invalidate();
    requestLayout();
  }

  public void setValuesVisible(boolean valuesVisible) {
    this.valuesVisible = valuesVisible;
    invalidate();
    requestLayout();
  }

  public void setIdleText(String idleText) {
    this.idleText = idleText;
    invalidate();
    requestLayout();
  }

  public void setVisibleRange(VisibleRange visibleRange) {
    this.visibleRange = visibleRange;
    invalidate();
    requestLayout();
  }

  public void setRangeButtonOnClickListener(OnClickListener listener) {
    rangeButton.setOnClickListener(listener);
  }

  public void updateChart(float value, int index) {
    LineData data = messagesChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index);

    if (set == null) {
      set = createSet(getLineColor(index));
      data.addDataSet(set);
    }

    data.addEntry(new Entry(set.getEntryCount(), value), index);
    data.notifyDataChanged();

    messagesChart.notifyDataSetChanged();
    messagesChart.setVisibleXRangeMaximum(getVisibleRange().getRange());
    messagesChart.moveViewToX(data.getEntryCount());
  }

  protected abstract int getLayout();

  protected void initializeAttributes(Context context, AttributeSet attrs) {
    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MessagesIndicator, 0, 0);

    try {
      title = array.getString(R.styleable.MessagesIndicator_title);

      defaultColor = ContextCompat.getColor(context, android.R.color.black);

      valuesVisible = array.getBoolean(R.styleable.MessagesIndicator_values_visible,
          getResources().getBoolean(R.bool.queued_messages_indicator_default_values_visible));

      idleText = array.getString(R.styleable.MessagesIndicator_idle_text);

      int range = array.getInteger(R.styleable.MessagesIndicator_visible_range, 0);

      visibleRange = VisibleRange.fromRange(range);
    } finally {
      array.recycle();
    }
  }

  protected void initializeWidgets() {
    titleTextView = (TextView) findViewById(R.id.title);
    rangeButton = (ImageButton) findViewById(R.id.range);
    messagesChart = (LineChart) findViewById(R.id.messages_chart);

    titleTextView.setText(getTitle());
  }

  protected void initializeChart() {
    Description description = new Description();
    description.setText("");
    messagesChart.setDescription(description);
    messagesChart.setNoDataText(getIdleText());
    messagesChart.setTouchEnabled(false);
    messagesChart.setDragEnabled(false);
    messagesChart.setPinchZoom(false);
    messagesChart.getLegend().setEnabled(false);
    messagesChart.getAxisLeft().setAxisMinimum(0);
    messagesChart.getAxisLeft().setGranularity(1f);
    messagesChart.getAxisRight().setEnabled(false);
    messagesChart.getXAxis().setAxisMinimum(0);
    messagesChart.getXAxis().setGranularity(1f);
    messagesChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    messagesChart.getXAxis().setValueFormatter(new DefaultAxisValueFormatter(0));

    LineData data = new LineData();
    data.setValueTextColor(Color.WHITE);
    messagesChart.setData(data);
  }

  protected abstract void initializeCallbacks();

  protected abstract int getLineColor(int index);

  protected LineDataSet createSet(int color) {
    LineDataSet set = new LineDataSet(null, "");
    set.setColor(color);
    set.setCircleColor(color);
    set.setCircleRadius(1f);
    set.setFillColor(color);
    set.setDrawValues(isValuesVisible());
    return set;
  }

  protected void toggleSetVisibility(int index) {
    LineData data = messagesChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index);

    if (set == null) {
      return;
    }

    set.setVisible(!set.isVisible());
  }

  public enum VisibleRange {

    ONE_MINUTE(TimeUnit.MINUTES.toSeconds(1)),

    TEN_MINUTES(TimeUnit.MINUTES.toSeconds(10)),

    ONE_HOUR(TimeUnit.HOURS.toSeconds(1)),

    EIGHT_HOURS(TimeUnit.HOURS.toSeconds(8)),

    ONE_DAY(TimeUnit.DAYS.toSeconds(1));

    private long range;

    VisibleRange(long range) {
      this.range = range;
    }

    public static VisibleRange fromRange(int range) {
      if (range == 0) {
        return VisibleRange.ONE_MINUTE;
      }

      if (range == 1) {
        return VisibleRange.TEN_MINUTES;
      }

      if (range == 2) {
        return VisibleRange.ONE_HOUR;
      }

      if (range == 3) {
        return VisibleRange.EIGHT_HOURS;
      }

      return VisibleRange.ONE_DAY;
    }

    public long getRange() {
      return range;
    }
  }
}
