package com.todev.rabbitmqmanagement.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.ui.BaseActivity;
import com.todev.rabbitmqmanagement.ui.overview.OverviewActivity;
import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View {
  @Inject SharedPreferences sharedPreferences;

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

  //private LastUsedData lastUsedData = new LastUsedData();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(this).getComponent().inject(this);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    presenter = new LoginPresenter();
    presenter.setView(this);

    addServiceButton.setOnClickListener(view -> presenter.onAddServiceButtonClicked());
    deleteServiceButton.setOnClickListener(view -> presenter.onDeleteServiceButtonClicked());
    loginButton.setOnClickListener(view -> presenter.onLoginButtonClicked());

    horizontalShakeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.horizontal_shake);
  }

  //@Override
  //protected void onStart() {
  //  super.onStart();
  //
  //  int services = loadSpinnerItems(lastUsedData.getService());
  //  invalidateDeleteServiceButton(services);
  //  loadSharedPreferences();
  //  initializeFields();
  //}

  //@OnClick(R.id.delete_service_button)
  //protected void onDeleteServiceButtonClicked(View view) {
  //  Service service = (Service) services.getSelectedItem();
  //  service.delete();
  //
  //  int services = loadSpinnerItems(lastUsedData.getService());
  //  invalidateDeleteServiceButton(services);
  //}

  //private void cleanupSharedPreferences() {
  //  SharedPreferences.Editor editor = sharedPreferences.edit();
  //
  //  int[] preferences = new int[] {
  //    R.string.shared_preferences_last_used_login, R.string.shared_preferences_last_used_password,
  //    R.string.shared_preferences_last_used_service, R.string.shared_preferences_last_used_service_port,
  //    R.string.shared_preferences_last_used_service_url, R.string.shared_preferences_remember_credentials
  //  };
  //
  //  for (int preference : preferences) {
  //    editor.remove(getString(preference));
  //  }
  //
  //  editor.apply();
  //}

  //private void loadSharedPreferences() {
  //  String login = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_login), "");
  //  String password = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_password), "");
  //  long service = sharedPreferences.getLong(getString(R.string.shared_preferences_last_used_service), -1);
  //  boolean rememberCredentials =
  //    sharedPreferences.getBoolean(getString(R.string.shared_preferences_remember_credentials), false);
  //
  //  lastUsedData.initialize(login, password, service, rememberCredentials);
  //}

  //private void saveSharedPreferences() {
  //  Service service = (Service) services.getSelectedItem();
  //
  //  SharedPreferences.Editor editor = sharedPreferences.edit();
  //
  //  editor.putString(getString(R.string.shared_preferences_last_used_login), login.getText().toString());
  //  editor.putString(getString(R.string.shared_preferences_last_used_password), password.getText().toString());
  //  editor.putLong(getString(R.string.shared_preferences_last_used_service), service.getId());
  //  editor.putString(getString(R.string.shared_preferences_last_used_service_url), service.getAddress());
  //  editor.putInt(getString(R.string.shared_preferences_last_used_service_port), service.getPort());
  //  editor.putBoolean(getString(R.string.shared_preferences_remember_credentials), remember.isChecked());
  //
  //  editor.apply();
  //}

  //private void initializeFields() {
  //  int position = getServicePosition(services.getAdapter(), lastUsedData.getService());
  //  if (position != -1) {
  //    services.setSelection(position);
  //    login.setText(lastUsedData.getUsername());
  //    password.setText(lastUsedData.getPassword());
  //    remember.setChecked(lastUsedData.isRemember());
  //  }
  //}

  //private int loadSpinnerItems(long id) {
  //  ServicesAdapter adapter = new ServicesAdapter(getApplicationContext());
  //  services.setAdapter(adapter);
  //
  //  int position = getServicePosition(adapter, id);
  //  if (position != -1) {
  //    services.setSelection(position);
  //  }
  //
  //  return services.getCount();
  //}

  //private int getServicePosition(SpinnerAdapter adapter, long serviceId) {
  //  ServicesAdapter servicesAdapter = (ServicesAdapter) adapter;
  //  return servicesAdapter.getItemPosition(serviceId);
  //}

  //private void showError(int errorResourceId) {
  //  View view = findViewById(R.id.login_activity_root);
  //  CharSequence text = getString(errorResourceId);
  //  Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
  //}

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
  public void showAddServiceDialog() {
    AddServiceFragment fragment = new AddServiceFragment();
    fragment.addOnSuccessListener(new OnDialogSuccessListener());
    fragment.show(getSupportFragmentManager(), "add_service_fragment");
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
  public void showCredentials(String username, String password, int service, boolean remember) {

  }

  @Override
  public void showOverview() {
    Intent intent = new Intent(this, OverviewActivity.class);
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

  //private class LastUsedData {
  //  private String username = "";
  //  private String password = "";
  //  private long service = -1;
  //  private boolean remember = false;
  //
  //  public void initialize(String username, String password, long service, boolean remember) {
  //    this.username = remember ? username : "";
  //    this.password = remember ? password : "";
  //    this.service = remember ? service : -1;
  //    this.remember = remember;
  //  }
  //
  //  public String getUsername() {
  //    return username;
  //  }
  //
  //  public String getPassword() {
  //    return password;
  //  }
  //
  //  public long getService() {
  //    return service;
  //  }
  //
  //  public boolean isRemember() {
  //    return remember;
  //  }
  //}

  private class OnDialogSuccessListener implements AddServiceFragment.OnSuccessListener {

    @Override
    public void onSuccess(long id) {
      //    int services = loadSpinnerItems(id);
      //    invalidateDeleteServiceButton(services);
      //    cleanupSharedPreferences();
      //    loadSharedPreferences();
    }
  }

  //private class LoginResponseCallback implements Callback<User> {
  //
  //  @Override
  //  public void onResponse(Call<User> call, Response<User> response) {
  //    if (!response.isSuccessful()) {
  //      showError(R.string.activity_login_credentials_invalid);
  //      return;
  //    }
  //
  //    saveSharedPreferences();
  //
  //    Intent intent = new Intent(LoginActivity.this, OverviewActivity.class);
  //    startActivity(intent);
  //  }
  //
  //  @Override
  //  public void onFailure(Call<User> call, Throwable t) {
  //    showError(R.string.service_unreachable);
  //  }
  //}
}
