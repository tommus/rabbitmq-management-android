package co.windly.rabbitmqmanagement.presentation.configure;

import android.os.Bundle;
import androidx.annotation.NonNull;
import co.windly.limbo.activity.fragment.LimboFragmentActivity;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.rabbitmqmanagement.R;
import co.windly.rabbitmqmanagement.presentation.configure.login.LoginFragment;
import co.windly.rabbitmqmanagement.presentation.configure.service.AddServiceFragment;

public class ConfigureActivity extends LimboFragmentActivity<ConfigureView, ConfigurePresenter> {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_fragment;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public ConfigurePresenter createPresenter() {
    return new ConfigurePresenter();
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Load fragment.
    loadConfigureFragment();
  }

  //endregion

  //region Fragment

  private void loadConfigureFragment() {

    // Check whether fragment is already added.
    final LimboFragment fragment = findFragment(AddServiceFragment.class);

    // In case if not added - load.
    if (fragment == null) {
      loadRootFragment(R.id.fragmentContainer, LoginFragment.createInstance());
    }
  }

  //endregion
}
