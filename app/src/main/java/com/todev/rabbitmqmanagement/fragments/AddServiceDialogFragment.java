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
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
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

  @BindView(R.id.label_edit_text_layout)
  TextInputLayout labelTextInputLayout;

  @BindView(R.id.label_edit_text)
  AppCompatEditText labelEditText;

  @BindView(R.id.address_edit_text_layout)
  TextInputLayout addressTextInputLayout;

  @BindView(R.id.address_edit_text)
  AppCompatEditText addressEditText;

  @BindView(R.id.port_number_picker_layout)
  LinearLayout portNumberPickerLayout;

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

  private Animation horizontalShakeAnimation;

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.fragment_add_service_dialog, null);

    ButterKnife.bind(this, view);

    builder.setView(view)
        .setPositiveButton(android.R.string.ok, null)
        .setNegativeButton(android.R.string.cancel, null);

    return builder.create();
  }

  @Override
  public void onStart() {
    super.onStart();

    Button positiveButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE);
    positiveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    positiveButton.setOnClickListener(new OnPositiveButtonClickedListener());

    Button negativeButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE);
    negativeButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    negativeButton.setOnClickListener(new OnPositiveButtonClickedListener());
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    horizontalShakeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.horizontal_shake);

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
    int port = 0;
    port += portNumberPicker10000.getValue() * 10000;
    port += portNumberPicker1000.getValue() * 1000;
    port += portNumberPicker100.getValue() * 100;
    port += portNumberPicker10.getValue() * 10;
    port += portNumberPicker1.getValue();
    return port;
  }

  private boolean validateLabel(String label) {
    // TODO: Check whether label is not already used.
    return !label.isEmpty();
  }

  private boolean validateAddress(String address) {
    return Patterns.IP_ADDRESS.matcher(address).matches() || Patterns.WEB_URL.matcher(address)
        .matches();
  }

  private boolean validatePort(int port) {
    return port > 1024 && port <= 65535;
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

  private class OnPositiveButtonClickedListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
      String label = labelEditText.getText().toString();
      String address = addressEditText.getText().toString();
      int port = combinePort();

      if (!validateLabel(label)) {
        labelTextInputLayout.startAnimation(horizontalShakeAnimation);
        labelEditText.setError(getString(R.string.fragment_add_service_dialog_label_incorrect));
        return;
      }

      if (!validateAddress(address)) {
        addressTextInputLayout.startAnimation(horizontalShakeAnimation);
        addressEditText.setError(getString(R.string.fragment_add_service_dialog_address_incorrect));
        return;
      }

      if (!validatePort(port)) {
        portNumberPickerLayout.startAnimation(horizontalShakeAnimation);
        return;
      }

      // TODO: Add persistence.

      dismiss();
    }
  }

  private class OnNegativeButtonClickedListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
      dismiss();
    }
  }
}
