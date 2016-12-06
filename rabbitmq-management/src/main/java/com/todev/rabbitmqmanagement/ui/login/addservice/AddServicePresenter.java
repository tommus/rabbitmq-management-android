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

import android.util.Patterns;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import java8.util.Optional;
import java8.util.function.Consumer;
import lombok.Setter;

public class AddServicePresenter implements AddServiceContract.Presenter {
  private static final Consumer<Integer> NOP_SUCCESS_CONSUMER = id -> {
    // Null Object Pattern.
  };

  @Setter AddServiceContract.View view;

  private Consumer<Integer> onSuccess = NOP_SUCCESS_CONSUMER;

  @Override
  public void onCancelButtonClicked() {
    view.close();
  }

  @Override
  public void onOkButtonClicked() {
    Service service = prepareService(view.getLabel(), view.getAddress(), view.getPortNumber());

    if (!validateLabel(service.getLabel())) {
      view.showInvalidLabelError();
      return;
    }

    if (!validateAddress(service.getAddress())) {
      view.showInvalidAddressError();
      return;
    }

    if (!validatePort(service.getPort())) {
      view.showInvalidPortNumberError();
      return;
    }

    service.save();

    onSuccess.accept(service.getId());

    view.close();
  }

  @Override
  public boolean validateLabel(String label) {
    return !label.isEmpty();
  }

  @Override
  public boolean validateAddress(String address) {
    return Patterns.IP_ADDRESS.matcher(address).matches() || Patterns.WEB_URL.matcher(address).matches();
  }

  @Override
  public boolean validatePort(int port) {
    return port > 1024 && port <= 65535;
  }

  @Override
  public void setOnSuccess(Consumer<Integer> onSuccess) {
    this.onSuccess = Optional.ofNullable(onSuccess).orElse(NOP_SUCCESS_CONSUMER);
  }

  protected Service prepareService(String label, String address, int port) {
    Service service = new Service();
    service.setLabel(label);
    service.setAddress(address);
    service.setPort(port);
    return service;
  }
}
