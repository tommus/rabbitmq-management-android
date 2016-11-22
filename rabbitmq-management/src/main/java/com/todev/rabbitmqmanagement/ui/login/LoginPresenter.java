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

import com.todev.rabbitmqmanagement.data.database.model.Service;
import lombok.Setter;

public class LoginPresenter implements LoginContract.Presenter {

  @Setter LoginContract.View view;

  @Override
  public void onAddServiceButtonClicked() {
    view.showAddServiceDialog();
  }

  @Override
  public void onDeleteServiceButtonClicked() {
    deleteService();
  }

  @Override
  public void onLoginButtonClicked() {
    String username = view.getUsername();
    String password = view.getPassword();
    Service service = view.getService();
    performLogin(username, password, service);
  }

  @Override
  public void shouldLoadCredentials() {

  }

  @Override
  public void loadCredentials() {

  }

  @Override
  public void loadServices() {

  }

  @Override
  public void deleteService() {

  }

  @Override
  public boolean validateLogin(String login) {
    return login.length() > 0;
  }

  @Override
  public boolean validatePassword(String password) {
    return password.length() > 0;
  }

  @Override
  public boolean validateService(Service service) {
    return service != null;
  }

  @Override
  public void performLogin(String login, String password, Service service) {
    // Validate login.
    if (!validateLogin(login)) {
      view.showMissingUsernameError();
    }

    // Validate password.
    else if (!validatePassword(password)) {
      view.showMissingPasswordError();
    }

    // Validate service.
    else if (!validateService(service)) {
      view.showServiceNotSelectedError();
    }

    // Perform login.
    else {
      // TODO: 22.11.16 Try to log in.
      //RabbitMqService rabbitMqService =
      //  RabbitMqService.Json.createService(service.getAddress(), service.getPort(), login, password);
      //
      //rabbitMqService.whoAmI().enqueue(new LoginResponseCallback());
    }
  }
}
