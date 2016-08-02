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
package com.todev.rabbitmqmanagement.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.todev.rabbitmqmanagement.widgets.R;

public class MessageRatesIndicator extends MessagesIndicator {

  protected int publishLineColor;

  protected int publishButtonColor;

  protected int confirmLineColor;

  protected int confirmButtonColor;

  protected int publishInLineColor;

  protected int publishInButtonColor;

  protected int publishOutLineColor;

  protected int publishOutButtonColor;

  protected int deliverLineColor;

  protected int deliverButtonColor;

  protected int redeliveredLineColor;

  protected int redeliveredButtonColor;

  protected Button publishButton;

  protected Button confirmButton;

  protected Button publishInButton;

  protected Button publishOutButton;

  protected Button deliverButton;

  protected Button redeliveredButton;

  public MessageRatesIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected int getLayout() {
    return R.layout.view_message_rates_indicator;
  }

  @Override
  protected void initializeAttributes(Context context, AttributeSet attrs) {
    super.initializeAttributes(context, attrs);

    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MessageRatesIndicator, 0, 0);

    try {
      publishLineColor = array.getColor(R.styleable.MessageRatesIndicator_publish_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_color));

      publishButtonColor = array.getColor(R.styleable.MessageRatesIndicator_publish_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_color));

      confirmLineColor = array.getColor(R.styleable.MessageRatesIndicator_confirm_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_confirm_color));

      confirmButtonColor = array.getColor(R.styleable.MessageRatesIndicator_confirm_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_confirm_color));

      publishInLineColor = array.getColor(R.styleable.MessageRatesIndicator_publish_in_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_in_color));

      publishInButtonColor = array.getColor(R.styleable.MessageRatesIndicator_publish_in_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_in_color));

      publishOutLineColor = array.getColor(R.styleable.MessageRatesIndicator_publish_out_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_out_color));

      publishOutButtonColor = array.getColor(R.styleable.MessageRatesIndicator_publish_out_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_publish_out_color));

      deliverLineColor = array.getColor(R.styleable.MessageRatesIndicator_deliver_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_deliver_color));

      deliverButtonColor = array.getColor(R.styleable.MessageRatesIndicator_deliver_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_deliver_color));

      redeliveredLineColor = array.getColor(R.styleable.MessageRatesIndicator_redelivered_line_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_redelivered_color));

      redeliveredButtonColor = array.getColor(R.styleable.MessageRatesIndicator_redelivered_button_color,
          ContextCompat.getColor(context, R.color.message_rates_indicator_default_redelivered_color));
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

    publishButton.setTextColor(getPublishButtonColor());
    confirmButton.setTextColor(getConfirmButtonColor());
    publishInButton.setTextColor(getPublishInButtonColor());
    publishOutButton.setTextColor(getPublishOutButtonColor());
    deliverButton.setTextColor(getDeliverButtonColor());
    redeliveredButton.setTextColor(getRedeliveredButtonColor());
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

      buttons[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          toggleSetVisibility(indices[index].getIndex());
        }
      });
    }
  }

  @Override
  protected int getLineColor(int index) {
    int[] colors = new int[] {
        getPublishLineColor(), getConfirmLineColor(), getPublishInLineColor(), getPublishOutLineColor(),
        getDeliverLineColor(), getRedeliveredLineColor()
    };

    if (index < colors.length) {
      return colors[index];
    }

    return getDefaultColor();
  }

  public int getPublishLineColor() {
    return publishLineColor;
  }

  public void setPublishLineColor(int publishLineColor) {
    this.publishLineColor = publishLineColor;
    invalidate();
    requestLayout();
  }

  public int getPublishButtonColor() {
    return publishButtonColor;
  }

  public void setPublishButtonColor(int publishButtonColor) {
    this.publishButtonColor = publishButtonColor;
    invalidate();
    requestLayout();
  }

  public int getConfirmLineColor() {
    return confirmLineColor;
  }

  public void setConfirmLineColor(int confirmLineColor) {
    this.confirmLineColor = confirmLineColor;
    invalidate();
    requestLayout();
  }

  public int getConfirmButtonColor() {
    return confirmButtonColor;
  }

  public void setConfirmButtonColor(int confirmButtonColor) {
    this.confirmButtonColor = confirmButtonColor;
    invalidate();
    requestLayout();
  }

  public int getPublishInLineColor() {
    return publishInLineColor;
  }

  public void setPublishInLineColor(int publishInLineColor) {
    this.publishInLineColor = publishInLineColor;
    invalidate();
    requestLayout();
  }

  public int getPublishInButtonColor() {
    return publishInButtonColor;
  }

  public void setPublishInButtonColor(int publishInButtonColor) {
    this.publishInButtonColor = publishInButtonColor;
    invalidate();
    requestLayout();
  }

  public int getPublishOutLineColor() {
    return publishOutLineColor;
  }

  public void setPublishOutLineColor(int publishOutLineColor) {
    this.publishOutLineColor = publishOutLineColor;
    invalidate();
    requestLayout();
  }

  public int getPublishOutButtonColor() {
    return publishOutButtonColor;
  }

  public void setPublishOutButtonColor(int publishOutButtonColor) {
    this.publishOutButtonColor = publishOutButtonColor;
    invalidate();
    requestLayout();
  }

  public int getDeliverLineColor() {
    return deliverLineColor;
  }

  public void setDeliverLineColor(int deliverLineColor) {
    this.deliverLineColor = deliverLineColor;
    invalidate();
    requestLayout();
  }

  public int getDeliverButtonColor() {
    return deliverButtonColor;
  }

  public void setDeliverButtonColor(int deliverButtonColor) {
    this.deliverButtonColor = deliverButtonColor;
    invalidate();
    requestLayout();
  }

  public int getRedeliveredLineColor() {
    return redeliveredLineColor;
  }

  public void setRedeliveredLineColor(int redeliveredLineColor) {
    this.redeliveredLineColor = redeliveredLineColor;
    invalidate();
    requestLayout();
  }

  public int getRedeliveredButtonColor() {
    return redeliveredButtonColor;
  }

  public void setRedeliveredButtonColor(int redeliveredButtonColor) {
    this.redeliveredButtonColor = redeliveredButtonColor;
    invalidate();
    requestLayout();
  }

  public void updatePublishButton(String text) {
    publishButton.setText(text);
  }

  public void updateConfirmButton(String text) {
    confirmButton.setText(text);
  }

  public void updatePublishInButton(String text) {
    publishInButton.setText(text);
  }

  public void updatePublishOutButton(String text) {
    publishOutButton.setText(text);
  }

  public void updateDeliverButton(String text) {
    deliverButton.setText(text);
  }

  public void updateRedeliveredButton(String text) {
    redeliveredButton.setText(text);
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
