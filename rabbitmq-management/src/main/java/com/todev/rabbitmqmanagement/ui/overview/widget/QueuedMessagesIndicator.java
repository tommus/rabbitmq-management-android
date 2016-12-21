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
import android.widget.Button;
import com.todev.rabbitmqmanagement.R;
import lombok.Getter;

public class QueuedMessagesIndicator extends MessagesIndicator {
  protected int readyColor;
  protected int unackedColor;
  protected int totalColor;

  @Getter Button readyButton;
  @Getter Button unackedButton;
  @Getter Button totalButton;

  public QueuedMessagesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected int getLayout() {
    return R.layout.view_queued_messages;
  }

  @Override
  protected void initializeAttributes(Context context, AttributeSet attrs) {
    super.initializeAttributes(context, attrs);

    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.QueuedMessagesIndicator, 0, 0);

    try {
      readyColor = array.getColor(R.styleable.QueuedMessagesIndicator_ready_color,
          ContextCompat.getColor(context, R.color.queuedMessagesReady));

      unackedColor = array.getColor(R.styleable.QueuedMessagesIndicator_unacked_color,
          ContextCompat.getColor(context, R.color.queuedMessagesUnacked));

      totalColor = array.getColor(R.styleable.QueuedMessagesIndicator_total_color,
          ContextCompat.getColor(context, R.color.queuedMessagesTotal));
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

    readyButton.setTextColor(readyColor);
    unackedButton.setTextColor(unackedColor);
    totalButton.setTextColor(totalColor);
  }

  @Override
  protected void initializeCallbacks() {
    readyButton.setOnClickListener(view -> toggleSetVisibility(SetIndex.READY.getIndex()));
    unackedButton.setOnClickListener(view -> toggleSetVisibility(SetIndex.UNACKED.getIndex()));
    totalButton.setOnClickListener(view -> toggleSetVisibility(SetIndex.TOTAL.getIndex()));
  }

  @Override
  protected int getLineColor(int index) {
    int[] colors = new int[] {
        readyColor, unackedColor, totalColor
    };

    if (index < colors.length) {
      return colors[index];
    }

    return defaultColor;
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
