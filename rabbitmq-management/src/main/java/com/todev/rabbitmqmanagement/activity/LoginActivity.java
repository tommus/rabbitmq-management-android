package com.todev.rabbitmqmanagement.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.adapter.ServicesAdapter;
import com.todev.rabbitmqmanagement.database.Service;
import com.todev.rabbitmqmanagement.fragment.dialog.AddServiceFragment;
import com.todev.rabbitmqmanagement.model.user.User;
import com.todev.rabbitmqmanagement.service.RabbitMqService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

  public static final String TAG = LoginActivity.class.getSimpleName();

  public static final String TAG_ADD_SERVICE = "Add Service Fragment";

  @BindView(R.id.login_edit_text_layout)
  TextInputLayout loginEditTextLayout;

  @BindView(R.id.login_edit_text)
  AppCompatEditText loginEditText;

  @BindView(R.id.password_edit_text_layout)
  TextInputLayout passwordEditTextLayout;

  @BindView(R.id.password_edit_text)
  AppCompatEditText passwordEditText;

  @BindView(R.id.select_service_spinner)
  AppCompatSpinner serviceSpinner;

  @BindView(R.id.remember_configuration_check_box)
  AppCompatCheckBox rememberConfigurationCheckBox;

  private Animation horizontalShakeAnimation;

  private SharedPreferences sharedPreferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ButterKnife.bind(this);

    horizontalShakeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.horizontal_shake);

    sharedPreferences =
        getApplicationContext().getSharedPreferences(getString(R.string.shared_preferences_key), Context.MODE_PRIVATE);

    initializeSpinner(-1);
  }

  @Override
  protected void onStart() {
    super.onStart();

    loadSharedPreferences();
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

  private void loadSharedPreferences() {
    boolean rememberCredentials =
        sharedPreferences.getBoolean(getString(R.string.shared_preferences_remember_credentials), false);

    if (rememberCredentials) {
      String login = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_login), "");

      String password = sharedPreferences.getString(getString(R.string.shared_preferences_last_used_password), "");

      int lastUsedService = sharedPreferences.getInt(getString(R.string.shared_preferences_last_used_service), -1);

      loginEditText.setText(login);
      passwordEditText.setText(password);
      serviceSpinner.setSelection(lastUsedService);
      rememberConfigurationCheckBox.setChecked(true);
    }
  }

  private void saveSharedPreferences() {
    Service service = (Service) serviceSpinner.getSelectedItem();

    SharedPreferences.Editor editor = sharedPreferences.edit();

    editor.putString(getString(R.string.shared_preferences_last_used_login), loginEditText.getText().toString());

    editor.putString(getString(R.string.shared_preferences_last_used_password), passwordEditText.getText().toString());

    editor.putInt(getString(R.string.shared_preferences_last_used_service), serviceSpinner.getSelectedItemPosition());

    editor.putString(getString(R.string.shared_preferences_last_used_service_url), service.getAddress());

    editor.putInt(getString(R.string.shared_preferences_last_used_service_port), service.getPort());

    editor.putBoolean(getString(R.string.shared_preferences_remember_credentials),
        rememberConfigurationCheckBox.isChecked());

    editor.apply();
  }

  private boolean validateLogin(String login) {
    return login.length() > 0;
  }

  private boolean validatePassword(String password) {
    return password.length() > 0;
  }

  private void initializeSpinner(long id) {
    ServicesAdapter adapter = new ServicesAdapter(getApplicationContext());
    serviceSpinner.setAdapter(adapter);
    int position = adapter.getItemPosition(id);
    if (position != -1) {
      serviceSpinner.setSelection(position);
    }
  }

  private void showError(int errorResourceId) {
    View view = findViewById(R.id.login_activity_root);
    CharSequence text = getString(errorResourceId);
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
  }

  private class OnDialogSuccessListener implements AddServiceFragment.OnSuccessListener {

    @Override
    public void onSuccess(long id) {
      initializeSpinner(id);
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
