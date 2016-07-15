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

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AddServiceDialogFragment extends DialogFragment {

  public static final String PICKER_DEFAULT = "15672";

  public static final String[] PICKER_VALUES = "123456789".split("");

  public static final int PICKER_MIN_VALUE = 0;

  @BindView(R.id.label_edit_text)
  AppCompatEditText labelEditText;

  @BindView(R.id.address_edit_text)
  AppCompatEditText addressEditText;

  @BindView(R.id.port_number_picker_10000)
  NumberPicker portNumberPicker10000;

  @BindView(R.id.port_number_picker_1000)
  NumberPicker portNumberPicker1000;

  @BindView(R.id.port_number_picker_100)
  NumberPicker portNumberPicker100;

  @BindView(R.id.port_number_picker_10)
  NumberPicker portNumberPicker10;

  @BindView(R.id.port_number_picker_1)
  NumberPicker portNumberPicker1;

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.fragment_add_service_dialog, null);

    ButterKnife.bind(this, view);

    builder.setView(view)
        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            String label = labelEditText.getText().toString();
            String address = addressEditText.getText().toString();
            int port = combinePort();
            // TODO: Add persistence and validation.
          }
        })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            // Do nothing on cancel.
          }
        });

    return builder.create();
  }

  @Override
  public void onStart() {
    super.onStart();

    ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE)
        .setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));

    ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE)
        .setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initializeNumberPickers();
  }

  private void initializeNumberPickers() {
    NumberPicker[] pickers = new NumberPicker[] {
        portNumberPicker10000, portNumberPicker1000, portNumberPicker100, portNumberPicker10,
        portNumberPicker1
    };

    for (int i = 0; i < pickers.length; ++i) {
      pickers[i].setWrapSelectorWheel(false);
      pickers[i].setDisplayedValues(PICKER_VALUES);
      pickers[i].setMinValue(PICKER_MIN_VALUE);
      pickers[i].setMaxValue(PICKER_VALUES.length - 1);

      int value = Integer.parseInt(PICKER_DEFAULT.substring(i, i + 1));
      pickers[i].setValue(value);

      NumberPicker[] older = Arrays.copyOfRange(pickers, 0, i);
      pickers[i].setOnValueChangedListener(new OnValueChangeListener(older));
    }
  }

  private int combinePort() {
    NumberPicker[] pickers = new NumberPicker[] {
        portNumberPicker10000, portNumberPicker1000, portNumberPicker100, portNumberPicker10,
        portNumberPicker1
    };

    int port = 0;

    for (int i = 0; i < pickers.length; ++i) {
      int value = pickers[i].getValue() * 10000 / (int) Math.pow(10, i);
      port += value;
    }

    return port;
  }

  private class OnValueChangeListener implements NumberPicker.OnValueChangeListener {

    private NumberPicker[] pickers;

    OnValueChangeListener(NumberPicker... pickers) {
      this.pickers = pickers;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
      if (pickers != null && newVal == PICKER_MIN_VALUE) {
        for (NumberPicker picker : pickers) {
          if (picker.getValue() != PICKER_MIN_VALUE) {
            picker.setValue(PICKER_MIN_VALUE);
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
