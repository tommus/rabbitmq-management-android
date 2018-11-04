package co.windly.rabbitmqmanagement.presentation.configure.login;

import co.windly.limbo.fragment.base.LimboFragmentPresenter;

class LoginPresenter extends LimboFragmentPresenter<LoginView> {

  //region Add Service

  void onServiceAddButtonClicked() {
    ifViewAttached(LoginView::navigateToAddServiceView);
  }

  //endregion

  //region Sign In

  void onLoginButtonClicked() {
    // TODO:
  }

  //endregion
}
