package com.todev.rabbitmqmanagement.presentation.configure.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import co.windly.limbo.fragment.base.LimboFragment;
import com.todev.rabbitmqmanagement.R;

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
}
