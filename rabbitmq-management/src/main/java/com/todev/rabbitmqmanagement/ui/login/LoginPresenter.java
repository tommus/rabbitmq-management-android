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

import com.todev.rabbitmqmanagement.data.app.DataProvider;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.interceptor.AddressInterceptor;
import com.todev.rabbitmqmanagement.data.network.interceptor.AuthorizationInterceptor;
import com.todev.rabbitmqmanagement.data.network.model.user.User;
import com.todev.rabbitmqmanagement.ui.BaseRxPresenter;
import lombok.Setter;
import retrofit2.Response;
import timber.log.Timber;

public class LoginPresenter extends BaseRxPresenter implements LoginContract.Presenter {
  @Setter LoginContract.View view;
  @Setter DataProvider dataProvider;
  @Setter AddressInterceptor addressInterceptor;
  @Setter AuthorizationInterceptor authorizationInterceptor;
  @Setter RabbitMqService rabbitMqService;

  @Override
  public void onAddServiceButtonClicked() {
    view.showAddServiceDialog();
  }

  @Override
  public void onDeleteServiceButtonClicked() {
    deleteService(view.getService());
  }

  @Override
  public void onLoginButtonClicked() {
    String username = view.getUsername();
    String password = view.getPassword();
    Service service = view.getService();
    performLogin(username, password, service);
  }

  @Override
  public void onAddServiceDialogSuccess(int id) {
    loadServices();
  }

  @Override
  public void loadCredentials() {
    disposable.add(dataProvider.getCredentials()
        .subscribeOn(getIoScheduler())
        .observeOn(getObserveScheduler())
        .subscribe(credentials -> view.showCredentials(credentials),
            throwable -> Timber.e("An error occurred while fetching credentials data.")));
  }

  @Override
  public void loadServices() {
    disposable.add(dataProvider.getServices()
        .subscribeOn(getIoScheduler())
        .observeOn(getObserveScheduler())
        .subscribe(services -> {
          view.updateServices(services);
          view.invalidateDeleteServiceButton();
        }, throwable -> Timber.d("An error occurred while fetching services data.")));
  }

  @Override
  public void deleteService(Service service) {
    service.delete();
    loadServices();
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
      interceptRequest(login, password, service);
      processLogin();
    }
  }

  protected void interceptRequest(String login, String password, Service service) {
    addressInterceptor.setAddress(service.getAddress());
    authorizationInterceptor.setCredentials(login, password);
  }

  protected void processLogin() {
    disposable.add(rabbitMqService.whoAmI()
        .subscribeOn(getIoScheduler())
        .observeOn(getObserveScheduler())
        .subscribe(response -> {
          if (isSuccessfulLogin(response)) {
            Timber.d(response.body().toString());
            // TODO: 22.11.2016 Save credentials if user has marked 'remember'.
            view.showOverview();
          } else {
            view.showInvalidCredentialsError();
          }
        }, throwable -> {
          Timber.e("An error occurred while logging in.");
          view.showServiceUnreachableError();
        }));
  }

  protected boolean isSuccessfulLogin(Response<User> response) {
    return response.isSuccessful();
  }
}
