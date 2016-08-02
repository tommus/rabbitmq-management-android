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
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.todev.rabbitmqmanagement.widgets.R;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PortPicker extends LinearLayout {

  public static final int MAX_PORT = 65535;
  public static final int PART_MIN_VALUE = 0;
  public static final String[] PART_VALUES = "0123456789".split("");

  protected int initialPortNumber;

  protected NumberPicker part10000;
  protected NumberPicker part1000;
  protected NumberPicker part100;
  protected NumberPicker part10;
  protected NumberPicker part1;

  public PortPicker(Context context, AttributeSet attrs) {
    super(context, attrs);

    inflate(context, R.layout.view_port_picker, this);
    initializeAttributes(context, attrs);
    initializeWidgets();
    setPortNumber(getInitialPortNumber());
  }

  public int getInitialPortNumber() {
    return initialPortNumber;
  }

  public void setInitialPortNumber(int initialPortNumber) {
    this.initialPortNumber = initialPortNumber;
  }

  public int getPortNumber() {
    int port = 0;
    port += part10000.getValue() * 10000;
    port += part1000.getValue() * 1000;
    port += part100.getValue() * 100;
    port += part10.getValue() * 10;
    port += part1.getValue();
    return port;
  }

  public void setPortNumber(int port) {
    String word = String.valueOf(port);
    String leading = ("00000" + word).substring(word.length());

    NumberPicker[] pickers = new NumberPicker[] { part10000, part1000, part100, part10, part1 };

    for (int i = 0; i < pickers.length; ++i) {
      int value = Integer.parseInt(leading.substring(i, i + 1));
      pickers[i].setValue(value);
    }
  }

  protected void initializeAttributes(Context context, AttributeSet attrs) {
    TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PortPicker, 0, 0);

    try {
      initialPortNumber = array.getInt(R.styleable.PortPicker_initial_port_number, MAX_PORT);
    } finally {
      array.recycle();
    }
  }

  protected void initializeWidgets() {
    part10000 = (NumberPicker) findViewById(R.id.port_picker_part_10000);
    part1000 = (NumberPicker) findViewById(R.id.port_picker_part_1000);
    part100 = (NumberPicker) findViewById(R.id.port_picker_part_100);
    part10 = (NumberPicker) findViewById(R.id.port_picker_part_10);
    part1 = (NumberPicker) findViewById(R.id.port_picker_part_1);

    NumberPicker[] pickers = new NumberPicker[] { part10000, part1000, part100, part10, part1 };

    for (int i = 0; i < pickers.length; ++i) {
      pickers[i].setWrapSelectorWheel(false);

      pickers[i].setDisplayedValues(PART_VALUES);
      pickers[i].setMinValue(PART_MIN_VALUE);
      pickers[i].setMaxValue(PART_VALUES.length - 1);

      NumberPicker[] older = Arrays.copyOfRange(pickers, 0, i);
      pickers[i].setOnValueChangedListener(new OnValueChangeListener(older));
    }
  }

  protected class OnValueChangeListener implements NumberPicker.OnValueChangeListener {

    private NumberPicker[] pickers;

    OnValueChangeListener(NumberPicker... pickers) {
      this.pickers = pickers;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
      if (pickers != null && newVal == PART_MIN_VALUE) {
        for (NumberPicker picker : pickers) {
          if (picker.getValue() != PART_MIN_VALUE) {
            picker.setValue(PART_MIN_VALUE);
            invalidate(picker);
          }
        }
      }
    }

    private void invalidate(NumberPicker picker) {
      try {
        Method method = picker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
        method.setAccessible(true);
        method.invoke(picker, false);
      } catch (Exception e) {
        // Do nothing. This is just a visible bug handler.
      }
    }
  }
}
