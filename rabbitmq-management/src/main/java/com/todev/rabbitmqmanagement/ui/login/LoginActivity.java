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

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.BuildConfig;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.data.app.DataProvider;
import com.todev.rabbitmqmanagement.data.app.model.Credentials;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.interceptor.AddressInterceptor;
import com.todev.rabbitmqmanagement.data.network.interceptor.AuthorizationInterceptor;
import com.todev.rabbitmqmanagement.ui.BaseActivity;
import com.todev.rabbitmqmanagement.ui.drawer.DrawerActivity;
import com.todev.rabbitmqmanagement.ui.login.addservice.AddServiceDialogFragment;
import java.util.List;
import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View {
  @Inject DataProvider dataProvider;
  @Inject AddressInterceptor addressInterceptor;
  @Inject AuthorizationInterceptor authorizationInterceptor;
  @Inject RabbitMqService rabbitMqService;

  @BindView(R.id.login_edit_text_layout) TextInputLayout loginLayout;
  @BindView(R.id.login_edit_text) AppCompatEditText login;
  @BindView(R.id.password_edit_text_layout) TextInputLayout passwordLayout;
  @BindView(R.id.password_edit_text) AppCompatEditText password;
  @BindView(R.id.services_relative_layout) RelativeLayout servicesLayout;
  @BindView(R.id.select_service_spinner) AppCompatSpinner services;
  @BindView(R.id.remember_configuration_check_box) AppCompatCheckBox remember;
  @BindView(R.id.add_service_button) ImageButton addServiceButton;
  @BindView(R.id.delete_service_button) ImageButton deleteServiceButton;
  @BindView(R.id.login_button) Button loginButton;

  private Animation horizontalShakeAnimation;

  private LoginPresenter presenter;
  private ServicesAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(this).getComponent().inject(this);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    presenter = new LoginPresenter();
    presenter.setView(this);
    presenter.setDataProvider(dataProvider);
    presenter.setAddressInterceptor(addressInterceptor);
    presenter.setAuthorizationInterceptor(authorizationInterceptor);
    presenter.setRabbitMqService(rabbitMqService);

    adapter = new ServicesAdapter(this);
    services.setAdapter(adapter);

    addServiceButton.setOnClickListener(view -> presenter.onAddServiceButtonClicked());
    deleteServiceButton.setOnClickListener(view -> presenter.onDeleteServiceButtonClicked());
    loginButton.setOnClickListener(view -> presenter.onLoginButtonClicked());

    horizontalShakeAnimation = AnimationUtils.loadAnimation(this, R.anim.horizontal_shake);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    if (BuildConfig.DEBUG) {
      login.setText("test");
      password.setText("test");
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.loadServices();
    presenter.loadCredentials();
  }

  @Override
  protected void onPause() {
    super.onPause();
    presenter.unsubscribe();
  }

  @Override
  public void showMissingUsernameError() {
    loginLayout.startAnimation(horizontalShakeAnimation);
    login.setError(getString(R.string.activity_login_login_missing));
  }

  @Override
  public void showMissingPasswordError() {
    passwordLayout.startAnimation(horizontalShakeAnimation);
    password.setError(getString(R.string.activity_login_password_missing));
  }

  @Override
  public void showServiceNotSelectedError() {
    servicesLayout.startAnimation(horizontalShakeAnimation);
  }

  @Override
  public void showInvalidCredentialsError() {
    showError(R.string.activity_login_credentials_invalid);
  }

  @Override
  public void showServiceUnreachableError() {
    showError(R.string.service_unreachable);
  }

  @Override
  public void showAddServiceDialog() {
    AddServiceDialogFragment fragment = new AddServiceDialogFragment();
    fragment.setOnSuccess(presenter::onAddServiceDialogSuccess);
    fragment.show(getSupportFragmentManager(), "add_service_fragment");
  }

  @Override
  public void invalidateDeleteServiceButton() {
    int count = adapter.getCount();
    setDeleteServiceButtonEnabled(count > 0);
  }

  @Override
  public void setDeleteServiceButtonEnabled(boolean enabled) {
    if (enabled) {
      deleteServiceButton.setClickable(true);
      deleteServiceButton.getBackground().setColorFilter(null);
    } else {
      deleteServiceButton.setClickable(false);
      deleteServiceButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
    }
  }

  @Override
  public void invalidateLoginButton() {

  }

  @Override
  public void setLoginButtonEnabled(boolean enabled) {
    if (enabled) {
      loginButton.setClickable(true);
      loginButton.getBackground().setColorFilter(null);
    } else {
      loginButton.setClickable(false);
      loginButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
    }
  }

  @Override
  public void updateServices(List<Service> services) {
    adapter.clear();
    adapter.addAll(services);
  }

  @Override
  public void showCredentials(Credentials credentials) {
    if (credentials.isRemember()) {
      this.login.setText(credentials.getUsername());
      this.password.setText(credentials.getPassword());
      this.services.setSelection(credentials.getService());
      this.remember.setChecked(credentials.isRemember());
    }
  }

  @Override
  public void showOverview() {
    Intent intent = new Intent(this, DrawerActivity.class);
    startActivity(intent);
  }

  @Override
  public String getUsername() {
    return login.getText().toString();
  }

  @Override
  public String getPassword() {
    return password.getText().toString();
  }

  @Override
  public Service getService() {
    return (Service) services.getSelectedItem();
  }

  protected void showError(@StringRes int errorId) {
    View view = findViewById(R.id.login_activity_root);
    CharSequence text = getString(errorId);
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
  }
}
