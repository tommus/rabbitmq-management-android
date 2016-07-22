package com.todev.rabbitmqmanagement.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.todev.rabbitmqmanagement.widgets.R;
import java.util.concurrent.TimeUnit;

public class QueuedMessagesIndicator extends FrameLayout {

  protected String title;

  protected int defaultColor;

  protected int readyLineColor;

  protected int readyButtonColor;

  protected int unackedLineColor;

  protected int unackedButtonColor;

  protected int totalLineColor;

  protected int totalButtonColor;

  protected boolean valuesVisible;

  protected String idleText;

  protected VisibleRange visibleRange;

  protected TextView titleTextView;

  protected LineChart messagesChart;

  protected Button readyButton;

  protected Button unackedButton;

  protected Button totalButton;

  public QueuedMessagesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);

    inflate(context, R.layout.view_queued_messages_indicator, this);
    initializeAttributes(context, attrs);
    initializeWidgets();
    initializeChart();
    initializeCallbacks();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
    invalidate();
    requestLayout();
  }

  public int getReadyLineColor() {
    return readyLineColor;
  }

  public void setReadyLineColor(int readyLineColor) {
    this.readyLineColor = readyLineColor;
    invalidate();
    requestLayout();
  }

  public int getReadyButtonColor() {
    return readyButtonColor;
  }

  public void setReadyButtonColor(int readyButtonColor) {
    this.readyButtonColor = readyButtonColor;
  }

  public int getUnackedLineColor() {
    return unackedLineColor;
  }

  public void setUnackedLineColor(int unackedLineColor) {
    this.unackedLineColor = unackedLineColor;
    invalidate();
    requestLayout();
  }

  public int getUnackedButtonColor() {
    return unackedButtonColor;
  }

  public void setUnackedButtonColor(int unackedButtonColor) {
    this.unackedButtonColor = unackedButtonColor;
    invalidate();
    requestLayout();
  }

  public int getTotalLineColor() {
    return totalLineColor;
  }

  public void setTotalLineColor(int totalLineColor) {
    this.totalLineColor = totalLineColor;
    invalidate();
    requestLayout();
  }

  public int getTotalButtonColor() {
    return totalButtonColor;
  }

  public void setTotalButtonColor(int totalButtonColor) {
    this.totalButtonColor = totalButtonColor;
    invalidate();
    requestLayout();
  }

  public boolean isValuesVisible() {
    return valuesVisible;
  }

  public void setValuesVisible(boolean valuesVisible) {
    this.valuesVisible = valuesVisible;
    invalidate();
    requestLayout();
  }

  public String getIdleText() {
    return idleText;
  }

  public void setIdleText(String idleText) {
    this.idleText = idleText;
    invalidate();
    requestLayout();
  }

  public VisibleRange getVisibleRange() {
    return visibleRange;
  }

  public void setVisibleRange(VisibleRange visibleRange) {
    this.visibleRange = visibleRange;
    invalidate();
    requestLayout();
  }

  public void updateChart(int value, SetIndex index) {
    LineData data = messagesChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index.getIndex());

    if (set == null) {
      set = createSet(getLineColor(index));
      data.addDataSet(set);
    }

    data.addEntry(new Entry(set.getEntryCount(), value), index.getIndex());
    data.notifyDataChanged();

    messagesChart.notifyDataSetChanged();
    messagesChart.setVisibleXRangeMaximum(getVisibleRange().getRange());
    messagesChart.moveViewToX(data.getEntryCount());
  }

  public void updateReadyButton(String text) {
    readyButton.setText(text);
  }

  public void updateUnackedButton(String text) {
    unackedButton.setText(text);
  }

  public void updateTotalButton(String text) {
    totalButton.setText(text);
  }

  protected void initializeAttributes(Context context, AttributeSet attrs) {
    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.QueuedMessagesIndicator, 0, 0);

    try {
      title = array.getString(R.styleable.QueuedMessagesIndicator_title);

      defaultColor = ContextCompat.getColor(context, android.R.color.black);

      readyLineColor = array.getColor(R.styleable.QueuedMessagesIndicator_ready_line_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_ready_color));

      readyButtonColor = array.getColor(R.styleable.QueuedMessagesIndicator_ready_button_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_ready_color));

      unackedLineColor = array.getColor(R.styleable.QueuedMessagesIndicator_unacked_line_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_unacked_color));

      unackedButtonColor = array.getColor(R.styleable.QueuedMessagesIndicator_unacked_button_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_unacked_color));

      totalLineColor = array.getColor(R.styleable.QueuedMessagesIndicator_total_line_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_total_color));

      totalButtonColor = array.getColor(R.styleable.QueuedMessagesIndicator_total_button_color,
          ContextCompat.getColor(context, R.color.queued_messages_indicator_default_total_color));

      valuesVisible = array.getBoolean(R.styleable.QueuedMessagesIndicator_values_visible,
          getResources().getBoolean(R.bool.queued_messages_indicator_default_values_visible));

      idleText = array.getString(R.styleable.QueuedMessagesIndicator_idle_text);

      int range = array.getInteger(R.styleable.QueuedMessagesIndicator_visible_range, 0);

      visibleRange = VisibleRange.fromRange(range);
    } finally {
      array.recycle();
    }
  }

  protected void initializeWidgets() {
    titleTextView = (TextView) findViewById(R.id.title);
    messagesChart = (LineChart) findViewById(R.id.messages_chart);
    readyButton = (Button) findViewById(R.id.ready_button);
    unackedButton = (Button) findViewById(R.id.unacked_button);
    totalButton = (Button) findViewById(R.id.total_button);

    titleTextView.setText(title);
    readyButton.setTextColor(getReadyButtonColor());
    unackedButton.setTextColor(getUnackedButtonColor());
    totalButton.setTextColor(getTotalButtonColor());
  }

  protected void initializeCallbacks() {
    readyButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.READY);
      }
    });

    unackedButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.UNACKED);
      }
    });

    totalButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.TOTAL);
      }
    });
  }

  protected void initializeChart() {
    messagesChart.getLegend().setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
    messagesChart.setDescription("");
    messagesChart.setNoDataTextDescription(getIdleText());
    messagesChart.setTouchEnabled(false);
    messagesChart.setDragEnabled(false);
    messagesChart.setPinchZoom(false);
    messagesChart.getLegend().setEnabled(false);
    messagesChart.getAxisLeft().setAxisMinValue(0);
    messagesChart.getAxisLeft().setGranularity(1f);
    messagesChart.getAxisRight().setEnabled(false);
    messagesChart.getXAxis().setAxisMinValue(0);
    messagesChart.getXAxis().setGranularity(1f);
    messagesChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    messagesChart.getXAxis().setValueFormatter(new DefaultAxisValueFormatter(0));

    LineData data = new LineData();
    data.setValueTextColor(Color.WHITE);
    messagesChart.setData(data);
  }

  private LineDataSet createSet(int color) {
    LineDataSet set = new LineDataSet(null, "");
    set.setColor(color);
    set.setCircleColor(color);
    set.setCircleRadius(1f);
    set.setFillColor(color);
    set.setDrawValues(isValuesVisible());
    return set;
  }

  private int getLineColor(SetIndex index) {
    switch (index) {
      case READY:
        return getReadyLineColor();

      case UNACKED:
        return getUnackedLineColor();

      case TOTAL:
        return getTotalLineColor();

      default:
        return defaultColor;
    }
  }

  private void toggleSetVisibility(SetIndex index) {
    LineData data = messagesChart.getData();
    ILineDataSet set = data.getDataSetByIndex(index.getIndex());

    if (set == null) {
      return;
    }

    set.setVisible(!set.isVisible());
  }

  public enum SetIndex {

    READY(0), UNACKED(1), TOTAL(2);

    private int index;

    SetIndex(int index) {
      this.index = index;
    }

    public int getIndex() {
      return index;
    }
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
