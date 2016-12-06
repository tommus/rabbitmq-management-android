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
package com.todev.rabbitmqmanagement.ui.login.addservice;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.ui.BaseDialogFragment;
import com.todev.rabbitmqmanagement.ui.login.PortNumberPicker;
import java8.util.function.Consumer;

public class AddServiceDialogFragment extends BaseDialogFragment implements AddServiceContract.View {
  @BindView(R.id.label_edit_text_layout) TextInputLayout labelTextInputLayout;
  @BindView(R.id.label_edit_text) AppCompatEditText labelEditText;
  @BindView(R.id.address_edit_text_layout) TextInputLayout addressTextInputLayout;
  @BindView(R.id.address_edit_text) AppCompatEditText addressEditText;
  @BindView(R.id.port_number_picker) PortNumberPicker portNumberPicker;
  private Animation horizontalShakeAnimation;

  private AddServicePresenter presenter;

  public AddServiceDialogFragment() {
    super();

    presenter = new AddServicePresenter();
    presenter.setView(this);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    horizontalShakeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.horizontal_shake);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.dialog_add_service, null);
    unbinder = ButterKnife.bind(this, view);
    builder.setView(view).setPositiveButton(android.R.string.ok, null).setNegativeButton(android.R.string.cancel, null);
    return builder.create();
  }

  @Override
  public void onStart() {
    super.onStart();

    Button positiveButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE);
    positiveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    positiveButton.setOnClickListener(v -> presenter.onOkButtonClicked());

    Button negativeButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE);
    negativeButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    negativeButton.setOnClickListener(v -> presenter.onCancelButtonClicked());
  }

  public void setOnSuccess(Consumer<Integer> onSuccess) {
    presenter.setOnSuccess(onSuccess);
  }

  @Override
  public String getLabel() {
    return labelEditText.getText().toString();
  }

  @Override
  public void showInvalidLabelError() {
    labelTextInputLayout.startAnimation(horizontalShakeAnimation);
    labelEditText.setError(getString(R.string.dialog_add_service_label_incorrect));
  }

  @Override
  public String getAddress() {
    return addressEditText.getText().toString();
  }

  @Override
  public void showInvalidAddressError() {
    addressTextInputLayout.startAnimation(horizontalShakeAnimation);
    addressEditText.setError(getString(R.string.dialog_add_service_address_incorrect));
  }

  @Override
  public int getPortNumber() {
    return portNumberPicker.getPortNumber();
  }

  @Override
  public void showInvalidPortNumberError() {
    portNumberPicker.startAnimation(horizontalShakeAnimation);
  }

  @Override
  public void close() {
    dismiss();
  }
}
