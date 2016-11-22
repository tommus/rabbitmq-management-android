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
package com.todev.rabbitmqmanagement.ui.login;

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
import butterknife.BindView;
import butterknife.ButterKnife;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.data.database.model.Service_Table;
import java8.util.Optional;
import java8.util.function.Consumer;

public class AddServiceFragment extends DialogFragment {
  private static final Consumer<Integer> NOP_SUCCESS_CONSUMER = id -> {
    // Null Object Pattern.
  };

  @BindView(R.id.label_edit_text_layout) TextInputLayout labelTextInputLayout;
  @BindView(R.id.label_edit_text) AppCompatEditText labelEditText;
  @BindView(R.id.address_edit_text_layout) TextInputLayout addressTextInputLayout;
  @BindView(R.id.address_edit_text) AppCompatEditText addressEditText;
  @BindView(R.id.port_number_picker) PortNumberPicker portNumberPicker;
  private Animation horizontalShakeAnimation;

  private Consumer<Integer> onSuccess = NOP_SUCCESS_CONSUMER;

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.dialog_add_service, null);
    ButterKnife.bind(this, view);
    builder.setView(view)
        .setPositiveButton(android.R.string.ok, null)
        .setNegativeButton(android.R.string.cancel, null);
    return builder.create();
  }

  @Override
  public void onStart() {
    super.onStart();

    Button positiveButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE);
    positiveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    positiveButton.setOnClickListener(new OnPositiveButtonClickedListener());

    Button negativeButton = ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE);
    negativeButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    negativeButton.setOnClickListener(view -> dismiss());
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    horizontalShakeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.horizontal_shake);
  }

  public void setOnSuccess(Consumer<Integer> onSuccess) {
    this.onSuccess = Optional.ofNullable(onSuccess).orElse(NOP_SUCCESS_CONSUMER);
  }

  private boolean validateLabel(String label) {
    Service service =
        new Select().from(Service.class).where(Service_Table.label.is(label)).querySingle();
    return !label.isEmpty() && service == null;
  }

  private boolean validateAddress(String address) {
    return Patterns.IP_ADDRESS.matcher(address).matches() || Patterns.WEB_URL.matcher(address)
        .matches();
  }

  private boolean validatePort(int port) {
    return port > 1024 && port <= 65535;
  }

  private class OnPositiveButtonClickedListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
      Service service = new Service();
      service.setLabel(labelEditText.getText().toString());
      service.setAddress(addressEditText.getText().toString());
      service.setPort(portNumberPicker.getPortNumber());

      if (!validateLabel(service.getLabel())) {
        labelTextInputLayout.startAnimation(horizontalShakeAnimation);
        labelEditText.setError(getString(R.string.dialog_add_service_label_incorrect));
        return;
      }

      if (!validateAddress(service.getAddress())) {
        addressTextInputLayout.startAnimation(horizontalShakeAnimation);
        addressEditText.setError(getString(R.string.dialog_add_service_address_incorrect));
        return;
      }

      if (!validatePort(service.getPort())) {
        portNumberPicker.startAnimation(horizontalShakeAnimation);
        return;
      }

      service.save();

      onSuccess.accept(service.getId());

      dismiss();
    }
  }
}
