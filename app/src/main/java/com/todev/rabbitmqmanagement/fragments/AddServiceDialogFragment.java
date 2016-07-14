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

public class AddServiceDialogFragment extends DialogFragment {

  public static final String PICKER_DEFAULT = "15672";
  public static final String[] PICKER_VALUES = "123456789".split("");

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
            // TODO: Implement confirm logic.
          }
        })
        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            // TODO: Implement cancel logic.
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
    loadDefaultPortNumber();
  }

  private void loadDefaultPortNumber() {
    NumberPicker[] pickers = new NumberPicker[] {
        portNumberPicker10000, portNumberPicker1000, portNumberPicker100, portNumberPicker10,
        portNumberPicker1
    };

    for (int i = 0; i < pickers.length; ++i) {
      int value = Integer.parseInt(PICKER_DEFAULT.substring(i, i + 1));
      pickers[i].setMinValue(0);
      pickers[i].setMaxValue(PICKER_VALUES.length - 1);
      pickers[i].setDisplayedValues(PICKER_VALUES);
      pickers[i].setValue(value);
      pickers[i].setWrapSelectorWheel(false);
    }
  }
}
