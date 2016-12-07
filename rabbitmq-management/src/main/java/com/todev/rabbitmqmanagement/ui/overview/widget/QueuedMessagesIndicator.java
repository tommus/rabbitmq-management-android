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
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessagesIndicator;

public class QueuedMessagesIndicator extends MessagesIndicator {
  protected int readyLineColor;
  protected int readyButtonColor;
  protected int unackedLineColor;
  protected int unackedButtonColor;
  protected int totalLineColor;
  protected int totalButtonColor;
  protected Button readyButton;
  protected Button unackedButton;
  protected Button totalButton;

  public QueuedMessagesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected int getLayout() {
    return R.layout.view_queued_messages_indicator;
  }

  @Override
  protected void initializeAttributes(Context context, AttributeSet attrs) {
    super.initializeAttributes(context, attrs);

    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.QueuedMessagesIndicator, 0, 0);

    try {
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
    } finally {
      array.recycle();
    }
  }

  @Override
  protected void initializeWidgets() {
    super.initializeWidgets();

    readyButton = (Button) findViewById(R.id.ready_button);
    unackedButton = (Button) findViewById(R.id.unacked_button);
    totalButton = (Button) findViewById(R.id.total_button);

    readyButton.setTextColor(getReadyButtonColor());
    unackedButton.setTextColor(getUnackedButtonColor());
    totalButton.setTextColor(getTotalButtonColor());
  }

  @Override
  protected void initializeCallbacks() {
    readyButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.READY.getIndex());
      }
    });

    unackedButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.UNACKED.getIndex());
      }
    });

    totalButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleSetVisibility(SetIndex.TOTAL.getIndex());
      }
    });
  }

  @Override
  protected int getLineColor(int index) {
    switch (index) {
      case 0:
        return getReadyLineColor();

      case 1:
        return getUnackedLineColor();

      case 2:
        return getTotalLineColor();

      default:
        return defaultColor;
    }
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

  public void updateReadyButton(String text) {
    readyButton.setText(text);
  }

  public void updateUnackedButton(String text) {
    unackedButton.setText(text);
  }

  public void updateTotalButton(String text) {
    totalButton.setText(text);
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
}
