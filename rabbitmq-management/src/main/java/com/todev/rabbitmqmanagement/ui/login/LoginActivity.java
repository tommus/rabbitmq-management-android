package com.todev.rabbitmqmanagement.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.user.User;
import com.todev.rabbitmqmanagement.ui.overview.OverviewActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
  public static final String TAG_ADD_SERVICE = "Add Service Fragment";

  @BindView(R.id.login_edit_text_layout) TextInputLayout loginEditTextLayout;
  @BindView(R.id.login_edit_text) AppCompatEditText loginEditText;
  @BindView(R.id.password_edit_text_layout) TextInputLayout passwordEditTextLayout;
  @BindView(R.id.password_edit_text) AppCompatEditText passwordEditText;
  @BindView(R.id.services_relative_layout) RelativeLayout servicesRelativeLayout;
  @BindView(R.id.select_service_spinner) AppCompatSpinner serviceSpinner;
  @BindView(R.id.remember_configuration_check_box) AppCompatCheckBox rememberConfigurationCheckBox;
  @BindView(R.id.delete_service_button) ImageButton deleteServiceButton;

  private Animation horizontalShakeAnimation;
  private SharedPreferences sharedPreferences;
  private LastUsedData lastUsedData = new LastUsedData();

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ButterKnife.bind(this);

    horizontalShakeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.horizontal_shake);

    sharedPreferences =
      getApplicationContext().getSharedPreferences(getString(R.string.shared_preferences_key), Context.MODE_PRIVATE);
  }

  @Override
  protected void onStart() {
    super.onStart();

    int services = loadSpinnerItems(lastUsedData.getService());
    invalidateDeleteServiceButton(services);
    loadSharedPreferences();
    initializeFields();
  }

  @OnClick(R.id.login_button)
  protected void onLoginButtonClicked(View view) {
    Service service = (Service) serviceSpinner.getSelectedItem();
    String login = loginEditText.getText().toString();
    String password = passwordEditText.getText().toString();

    if (!validateLogin(login)) {
      loginEditTextLayout.startAnimation(horizontalShakeAnimation);
      loginEditText.setError(getString(R.string.activity_login_login_missing));
      return;
    }

    if (!validatePassword(password)) {
      passwordEditTextLayout.startAnimation(horizontalShakeAnimation);
      passwordEditText.setError(getString(R.string.activity_login_password_missing));
      return;
    }

    if (!validateService(serviceSpinner.getSelectedItem())) {
      servicesRelativeLayout.startAnimation(horizontalShakeAnimation);
    }

    RabbitMqService rabbitMqService =
      RabbitMqService.Json.createService(service.getAddress(), service.getPort(), login, password);

    rabbitMqService.whoAmI().enqueue(new LoginResponseCallback());
  }

  @OnClick(R.id.add_service_button)
  protected void onAddServiceButtonClicked(View view) {
    AddServiceFragment fragment = new AddServiceFragment();
    fragment.addOnSuccessListener(new OnDialogSuccessListener());
    fragment.show(getSupportFragmentManager(), TAG_ADD_SERVICE);
  }

  @OnClick(R.id.delete_service_button)
  protected void onDeleteServiceButtonClicked(View view) {
    Service service = (Service) serviceSpinner.getSelectedItem();
    service.delete();

    int services = loadSpinnerItems(lastUsedData.getService());
    invalidateDeleteServiceButton(services);
  }

  private void cleanupSharedPreferences() {
    SharedPreferences.Editor editor = sharedPreferences.edit();

    int[] preferences = new int[] {
      R.string.shared_preferences_last_used_login, R.string.shared_preferences_last_used_password,
      R.string.shared_preferences_last_used_service, R.string.shared_preferences_last_used_service_port,
      R.string.shared_preferences_last_used_service_url, R.string.shared_preferences_remember_credentials
    };

    for (int preference : preferences) {
      editor.remove(getString(preference));
    }

    editor.apply();
  }

  private void loadSharedPreferences() {
    String login = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_login), "");
    String password = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_password), "");
    long service = sharedPreferences.getLong(getString(R.string.shared_preferences_last_used_service), -1);
    boolean rememberCredentials =
      sharedPreferences.getBoolean(getString(R.string.shared_preferences_remember_credentials), false);

    lastUsedData.initialize(login, password, service, rememberCredentials);
  }

  private void saveSharedPreferences() {
    Service service = (Service) serviceSpinner.getSelectedItem();

    SharedPreferences.Editor editor = sharedPreferences.edit();

    editor.putString(getString(R.string.shared_preferences_last_used_login), loginEditText.getText().toString());
    editor.putString(getString(R.string.shared_preferences_last_used_password), passwordEditText.getText().toString());
    editor.putLong(getString(R.string.shared_preferences_last_used_service), service.getId());
    editor.putString(getString(R.string.shared_preferences_last_used_service_url), service.getAddress());
    editor.putInt(getString(R.string.shared_preferences_last_used_service_port), service.getPort());
    editor.putBoolean(getString(R.string.shared_preferences_remember_credentials),
      rememberConfigurationCheckBox.isChecked());

    editor.apply();
  }

  private void initializeFields() {
    int position = getServicePosition(serviceSpinner.getAdapter(), lastUsedData.getService());
    if (position != -1) {
      serviceSpinner.setSelection(position);
      loginEditText.setText(lastUsedData.getUsername());
      passwordEditText.setText(lastUsedData.getPassword());
      rememberConfigurationCheckBox.setChecked(lastUsedData.isRemember());
    }
  }

  private boolean validateLogin(String login) {
    return login.length() > 0;
  }

  private boolean validatePassword(String password) {
    return password.length() > 0;
  }

  private boolean validateService(Object item) {
    return item != null;
  }

  private int loadSpinnerItems(long id) {
    ServicesAdapter adapter = new ServicesAdapter(getApplicationContext());
    serviceSpinner.setAdapter(adapter);

    int position = getServicePosition(adapter, id);
    if (position != -1) {
      serviceSpinner.setSelection(position);
    }

    return serviceSpinner.getCount();
  }

  private int getServicePosition(SpinnerAdapter adapter, long serviceId) {
    ServicesAdapter servicesAdapter = (ServicesAdapter) adapter;
    return servicesAdapter.getItemPosition(serviceId);
  }

  private void invalidateDeleteServiceButton(int services) {
    if (services <= 0) {
      deleteServiceButton.setClickable(false);
      deleteServiceButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
    } else {
      deleteServiceButton.setClickable(true);
      deleteServiceButton.getBackground().setColorFilter(null);
    }
  }

  private void showError(int errorResourceId) {
    View view = findViewById(R.id.login_activity_root);
    CharSequence text = getString(errorResourceId);
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
  }

  private class LastUsedData {
    private String username = "";
    private String password = "";
    private long service = -1;
    private boolean remember = false;

    public void initialize(String username, String password, long service, boolean remember) {
      this.username = remember ? username : "";
      this.password = remember ? password : "";
      this.service = remember ? service : -1;
      this.remember = remember;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }

    public long getService() {
      return service;
    }

    public boolean isRemember() {
      return remember;
    }
  }

  private class OnDialogSuccessListener implements AddServiceFragment.OnSuccessListener {

    @Override
    public void onSuccess(long id) {
      int services = loadSpinnerItems(id);
      invalidateDeleteServiceButton(services);
      cleanupSharedPreferences();
      loadSharedPreferences();
    }
  }

  private class LoginResponseCallback implements Callback<User> {

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
      if (!response.isSuccessful()) {
        showError(R.string.activity_login_credentials_invalid);
        return;
      }

      saveSharedPreferences();

      Intent intent = new Intent(LoginActivity.this, OverviewActivity.class);
      startActivity(intent);
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
      showError(R.string.service_unreachable);
    }
  }
}
