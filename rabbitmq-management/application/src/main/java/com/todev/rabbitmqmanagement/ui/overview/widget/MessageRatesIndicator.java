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

public class MessageRatesIndicator extends MessagesIndicator {
  protected int publishColor;
  protected int confirmColor;
  protected int publishInColor;
  protected int publishOutColor;
  protected int deliverColor;
  protected int redeliveredColor;

  @Getter Button publishButton;
  @Getter Button confirmButton;
  @Getter Button publishInButton;
  @Getter Button publishOutButton;
  @Getter Button deliverButton;
  @Getter Button redeliveredButton;

  public MessageRatesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected int getLayout() {
    return R.layout.view_message_rates;
  }

  @Override
  protected void initializeAttributes(Context context, AttributeSet attrs) {
    super.initializeAttributes(context, attrs);

    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MessageRatesIndicator, 0, 0);

    try {
      publishColor = array.getColor(R.styleable.MessageRatesIndicator_publish_color,
          ContextCompat.getColor(context, R.color.messageRatesPublished));

      confirmColor = array.getColor(R.styleable.MessageRatesIndicator_confirm_color,
          ContextCompat.getColor(context, R.color.messagesRatesConfirmed));

      publishInColor = array.getColor(R.styleable.MessageRatesIndicator_publish_in_color,
          ContextCompat.getColor(context, R.color.messagesRatesPublishedIn));

      publishOutColor = array.getColor(R.styleable.MessageRatesIndicator_publish_out_color,
          ContextCompat.getColor(context, R.color.messagesRatesPublishedOut));

      deliverColor = array.getColor(R.styleable.MessageRatesIndicator_deliver_color,
          ContextCompat.getColor(context, R.color.messagesRatesDelivered));

      redeliveredColor = array.getColor(R.styleable.MessageRatesIndicator_redelivered_color,
          ContextCompat.getColor(context, R.color.messagesRatesRedelivered));
    } finally {
      array.recycle();
    }
  }

  @Override
  protected void initializeWidgets() {
    super.initializeWidgets();

    publishButton = (Button) findViewById(R.id.publish_button);
    confirmButton = (Button) findViewById(R.id.confirm_button);
    publishInButton = (Button) findViewById(R.id.publish_in_button);
    publishOutButton = (Button) findViewById(R.id.publish_out_button);
    deliverButton = (Button) findViewById(R.id.deliver_button);
    redeliveredButton = (Button) findViewById(R.id.redelivered_button);

    publishButton.setTextColor(publishColor);
    confirmButton.setTextColor(confirmColor);
    publishInButton.setTextColor(publishInColor);
    publishOutButton.setTextColor(publishOutColor);
    deliverButton.setTextColor(deliverColor);
    redeliveredButton.setTextColor(redeliveredColor);
  }

  @Override
  protected void initializeCallbacks() {
    Button[] buttons = new Button[] {
        publishButton, confirmButton, publishInButton, publishOutButton, deliverButton, redeliveredButton
    };

    final SetIndex[] indices = new SetIndex[] {
        SetIndex.PUBLISH, SetIndex.CONFIRM, SetIndex.PUBLISH_IN, SetIndex.PUBLISH_OUT, SetIndex.DELIVER,
        SetIndex.REDELIVERED
    };

    for (int i = 0; i < buttons.length; ++i) {
      final int index = i;
      buttons[i].setOnClickListener(view -> toggleSetVisibility(indices[index].getIndex()));
    }
  }

  @Override
  protected int getLineColor(int index) {
    int[] colors = new int[] {
        publishColor, confirmColor, publishInColor, publishOutColor, deliverColor, redeliveredColor
    };

    if (index < colors.length) {
      return colors[index];
    }

    return getDefaultColor();
  }

  public enum SetIndex {

    PUBLISH(0), CONFIRM(1), PUBLISH_IN(2), PUBLISH_OUT(3), DELIVER(4), REDELIVERED(5);

    private int index;

    SetIndex(int index) {
      this.index = index;
    }

    public int getIndex() {
      return index;
    }
  }
}
