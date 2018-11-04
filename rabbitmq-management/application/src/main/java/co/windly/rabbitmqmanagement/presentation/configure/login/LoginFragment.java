package co.windly.rabbitmqmanagement.presentation.configure.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import butterknife.OnClick;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.rabbitmqmanagement.R;
import co.windly.rabbitmqmanagement.presentation.configure.service.AddServiceFragment;

public class LoginFragment extends LimboFragment<LoginView, LoginPresenter> implements LoginView {

  //region Fragment

  public static LoginFragment createInstance() {

    // Prepare bundle.
    final Bundle bundle = new Bundle();

    // Instantiate fragment and return.
    final LoginFragment fragment = new LoginFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

  //endregion

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.fragment_login;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public LoginPresenter createPresenter() {
    return new LoginPresenter();
  }

  //endregion

  //region Navigation

  @Override
  public void navigateToAddServiceView() {

    // Prepare target fragment.
    final AddServiceFragment fragment = AddServiceFragment.createInstance();

    // Navigate to target fragment.
    start(fragment);
  }

  //endregion

  //region Add Service

  @OnClick(R.id.serviceAddButton)
  void onServiceAddButtonClicked() {
    getPresenter().onServiceAddButtonClicked();
  }

  //endregion

  //region Sign In

  @OnClick(R.id.loginButton)
  void onLoginButtonClicked() {
    getPresenter().onLoginButtonClicked();
  }

  //endregion
}
