package com.todev.rabbitmqmanagement.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.todev.rabbitmqmanagement.R;

public class LoginActivity extends AppCompatActivity {

  @BindView(R.id.select_service_spinner)
  AppCompatSpinner serviceSpinner;

  @BindView(R.id.remember_configuration_check_box)
  AppCompatCheckBox rememberConfigurationCheckBox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    loadSamples();
  }

  @OnClick(R.id.login_button)
  protected void onLoginButtonClicked(View view) {
    // TODO: Implement logic.
  }

  @OnClick(R.id.add_service_button)
  protected void onAddServiceButtonClicked(View view) {
    // TODO: Implement logic.
  }

  private void loadSamples() {
    ArrayAdapter<CharSequence> adapter =
        ArrayAdapter.createFromResource(this, R.array.services, R.layout.spinner_item);
    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
    serviceSpinner.setAdapter(adapter);
  }
}
