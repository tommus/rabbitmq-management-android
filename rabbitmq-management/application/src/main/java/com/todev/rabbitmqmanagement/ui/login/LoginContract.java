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

import com.todev.rabbitmqmanagement.data.app.model.Credentials;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import java.util.List;

interface LoginContract {
  interface View {
    void showMissingUsernameError();

    void showMissingPasswordError();

    void showServiceNotSelectedError();

    void showInvalidCredentialsError();

    void showServiceUnreachableError();

    void showAddServiceDialog();

    void invalidateDeleteServiceButton();

    void setDeleteServiceButtonEnabled(boolean enabled);

    void invalidateLoginButton();

    void setLoginButtonEnabled(boolean enabled);

    void updateServices(List<Service> services);

    void showCredentials(Credentials credentials);

    void showOverview();

    String getUsername();

    String getPassword();

    Service getService();
  }

  interface Presenter {
    void onAddServiceButtonClicked();

    void onDeleteServiceButtonClicked();

    void onLoginButtonClicked();

    void onAddServiceDialogSuccess(int id);

    void loadCredentials();

    void loadServices();

    void deleteService(Service service);

    boolean validateLogin(String login);

    boolean validatePassword(String password);

    boolean validateService(Service service);

    void performLogin(String login, String password, Service service);
  }
}
