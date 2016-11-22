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

import android.os.Build;
import com.todev.rabbitmqmanagement.BuildConfig;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class LoginPresenterTest {
  @Mock LoginContract.View view;

  private LoginPresenter presenter;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    presenter = spy(new LoginPresenter());
    presenter.setView(view);
  }

  @Test
  public void should_show_add_service_dialog_on_add_service_button_clicked() {
    // When
    presenter.onAddServiceButtonClicked();

    // Then
    verify(view).showAddServiceDialog();
  }

  @Test
  public void should_perform_delete_service_on_delete_service_button_clicked() {
    // When
    presenter.onDeleteServiceButtonClicked();

    // Then
    verify(presenter).deleteService();
  }

  @Test
  public void should_retrieve_credentials_and_perform_login_on_login_button_clicked() {
    // Given
    doReturn("Username").when(view).getUsername();
    doReturn("Password").when(view).getPassword();
    doReturn(new Service()).when(view).getService();
    doNothing().when(presenter).performLogin(anyString(), anyString(), any());

    // When
    presenter.onLoginButtonClicked();

    // Then
    verify(view).getUsername();
    verify(view).getPassword();
    verify(view).getService();
    verify(presenter).performLogin(anyString(), anyString(), any());
  }

  @Test
  public void should_show_missing_username_error_on_unsuccessful_username_validation() {
    // Given
    doReturn(false).when(presenter).validateLogin(anyString());

    // When
    presenter.performLogin("Username", "Password", new Service());

    // Then
    verify(view).showMissingUsernameError();
  }

  @Test
  public void should_show_missing_password_error_on_unsuccessful_password_validation() {
    // Given
    doReturn(true).when(presenter).validateLogin(anyString());
    doReturn(false).when(presenter).validatePassword(anyString());

    // When
    presenter.performLogin("Username", "Password", new Service());

    // Then
    verify(view).showMissingPasswordError();
  }

  @Test
  public void should_show_missing_service_error_on_unsuccessful_service_validation() {
    // Given
    doReturn(true).when(presenter).validateLogin(anyString());
    doReturn(true).when(presenter).validatePassword(anyString());
    doReturn(false).when(presenter).validateService(any());

    // When
    presenter.performLogin("Username", "Password", new Service());

    // Then
    verify(view).showServiceNotSelectedError();
  }

  @Test
  public void should_not_show_any_input_errors_on_valid_credentials() {
    // Given
    doReturn(true).when(presenter).validateLogin(anyString());
    doReturn(true).when(presenter).validatePassword(anyString());
    doReturn(true).when(presenter).validateService(any());

    // When
    presenter.performLogin("Username", "Password", new Service());

    // Then
    verify(view, times(0)).showMissingUsernameError();
    verify(view, times(0)).showMissingPasswordError();
    verify(view, times(0)).showServiceNotSelectedError();
  }
}
