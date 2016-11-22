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

public interface LoginContract {
  interface View {
    void showMissingUsernameError();

    void showMissingPasswordError();

    void showServiceNotSelectedError();

    void showAddServiceDialog();

    void setDeleteServiceButtonEnabled(boolean enabled);

    void setLoginButtonEnabled(boolean enabled);

    void showCredentials(String username, String password, int service, boolean remember);

    void showOverview();

    String getUsername();

    String getPassword();

    Service getService();
  }

  interface Presenter {
    void onAddServiceButtonClicked();

    void onDeleteServiceButtonClicked();

    void onLoginButtonClicked();

    void shouldLoadCredentials();

    void loadCredentials();

    void loadServices();

    void deleteService();

    boolean validateLogin(String login);

    boolean validatePassword(String password);

    boolean validateService(Service service);

    void performLogin(String login, String password, Service service);
  }
}
