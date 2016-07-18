package com.todev.rabbitmqmanagement.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.adapters.ServicesAdapter;
import com.todev.rabbitmqmanagement.fragments.AddServiceFragment;

public class LoginActivity extends AppCompatActivity {

  public static final String TAG_ADD_SERVICE = "Add Service Fragment";

  @BindView(R.id.select_service_spinner)
  AppCompatSpinner serviceSpinner;

  @BindView(R.id.remember_configuration_check_box)
  AppCompatCheckBox rememberConfigurationCheckBox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    // TODO: Select last used or remembered by user.
    initializeSpinner(-1);
  }

  @OnClick(R.id.login_button)
  protected void onLoginButtonClicked(View view) {
    // TODO: Implement logic.
  }

  @OnClick(R.id.add_service_button)
  protected void onAddServiceButtonClicked(View view) {
    AddServiceFragment fragment = new AddServiceFragment();
    fragment.addOnSuccessListener(new OnDialogSuccessListener());
    fragment.show(getSupportFragmentManager(), TAG_ADD_SERVICE);
  }

  private void initializeSpinner(long id) {
    ServicesAdapter adapter = new ServicesAdapter(getApplicationContext());
    serviceSpinner.setAdapter(adapter);
    int position = adapter.getItemPosition(id);
    if (position != -1) {
      serviceSpinner.setSelection(position);
    }
  }

  private class OnDialogSuccessListener implements AddServiceFragment.OnSuccessListener {

    @Override
    public void onSuccess(long id) {
      initializeSpinner(id);
    }
  }
}
