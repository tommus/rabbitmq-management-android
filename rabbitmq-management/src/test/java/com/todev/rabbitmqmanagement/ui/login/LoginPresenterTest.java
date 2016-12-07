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

import android.content.SharedPreferences;
import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.app.DataProvider;
import com.todev.rabbitmqmanagement.data.app.model.Credentials;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.interceptor.AddressInterceptor;
import com.todev.rabbitmqmanagement.data.network.interceptor.AuthorizationInterceptor;
import com.todev.rabbitmqmanagement.data.network.model.user.User;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import retrofit2.Response;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest extends BaseTest {
  @Mock LoginContract.View view;
  @Mock SharedPreferences sharedPreferences;
  @Mock DataProvider dataProvider;
  @Mock AddressInterceptor addressInterceptor;
  @Mock AuthorizationInterceptor authorizationInterceptor;
  @Mock RabbitMqService rabbitMqService;
  @Mock Service service;
  @Mock User user;
  @Mock ResponseBody errorResponseBody;

  private LoginPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = spy(new LoginPresenter());
    presenter.setView(view);
    presenter.setDataProvider(dataProvider);
    presenter.setAddressInterceptor(addressInterceptor);
    presenter.setAuthorizationInterceptor(authorizationInterceptor);
    presenter.setRabbitMqService(rabbitMqService);
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
    // Given
    doNothing().when(presenter).deleteService(any());

    // When
    presenter.onDeleteServiceButtonClicked();

    // Then
    verify(presenter).deleteService(any());
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
  public void should_load_services_on_add_service_dialog_success() {
    // Given
    doNothing().when(presenter).loadServices();

    // When
    presenter.onAddServiceDialogSuccess(0);

    // Then
    verify(presenter).loadServices();
  }

  @Test
  public void should_show_credentials_on_successful_credentials_load() {
    // Given
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(new Credentials(sharedPreferences))).when(dataProvider).getCredentials();

    // When
    presenter.loadCredentials();

    // Then
    verify(view).showCredentials(any(Credentials.class));
  }

  @Test
  public void should_not_show_credentials_on_unsuccessful_credentials_load() {
    // Given
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.error(new RuntimeException())).when(dataProvider).getCredentials();

    // When
    presenter.loadCredentials();

    // Then
    verify(view, times(0)).showCredentials(any(Credentials.class));
  }

  @Test
  public void should_update_services_and_invalidate_delete_button_on_successful_services_load() {
    // Given
    List<Service> list = Collections.singletonList(new Service());
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(list)).when(dataProvider).getServices();

    // When
    presenter.loadServices();

    // Then
    ArgumentCaptor<List<Service>> argument = ArgumentCaptor.forClass(List.class);
    verify(view).updateServices(argument.capture());
    assertThat(argument.getValue().size()).isEqualTo(list.size());
    verify(view).invalidateDeleteServiceButton();
  }

  @Test
  public void should_not_update_services_and_not_invalidate_delete_button_on_unsuccessful_serviecs_load() {
    // Given
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.error(new RuntimeException())).when(dataProvider).getServices();

    // When
    presenter.loadServices();

    // Then
    verify(view, times(0)).updateServices(any());
    verify(view, times(0)).invalidateDeleteServiceButton();
  }

  @Test
  public void should_reload_services_on_service_delete() {
    // Given
    doNothing().when(service).delete();
    doNothing().when(presenter).loadServices();

    // When
    presenter.deleteService(service);

    // Then
    verify(service).delete();
    verify(presenter).loadServices();
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
    doNothing().when(presenter).interceptRequest(anyString(), anyString(), any());
    doNothing().when(presenter).processLogin();
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

  @Test
  public void should_intercept_request() {
    // Given
    doReturn("http://localhost").when(service).getAddress();
    doReturn(15672).when(service).getPort();
    doNothing().when(addressInterceptor).setAddress(anyString());
    doNothing().when(authorizationInterceptor).setCredentials(anyString(), anyString());

    // When
    presenter.interceptRequest("Username", "Password", service);

    // Then
    verify(addressInterceptor).setAddress("http://localhost");
    verify(authorizationInterceptor).setCredentials("Username", "Password");
  }

  @Test
  public void should_show_service_unreachable_error_on_unsuccessful_login_attempt() {
    // Given
    doReturn(Observable.error(new RuntimeException())).when(rabbitMqService).whoAmI();
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();

    // When
    presenter.processLogin();

    // Then
    verify(view).showServiceUnreachableError();
  }

  @Test
  public void should_show_overview_after_successful_login() {
    // Given
    Response<User> response = Response.success(user);
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(response)).when(rabbitMqService).whoAmI();
    doReturn(true).when(presenter).isSuccessfulLogin(any());

    // When
    presenter.processLogin();

    // Then
    verify(view).showOverview();
  }

  @Test
  public void should_show_invalid_credentials_on_unsuccessful_login() {
    // Given
    Response<User> response = Response.error(503, errorResponseBody);
    doReturn(Schedulers.trampoline()).when(presenter).getIoScheduler();
    doReturn(Schedulers.trampoline()).when(presenter).getObserveScheduler();
    doReturn(Observable.just(response)).when(rabbitMqService).whoAmI();
    doReturn(false).when(presenter).isSuccessfulLogin(any());

    // When
    presenter.processLogin();

    // Then
    verify(view).showInvalidCredentialsError();
  }
}
