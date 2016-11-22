package com.todev.rabbitmqmanagement.core.dagger;

import com.todev.rabbitmqmanagement.ui.login.LoginActivity;

public interface AppGraph {
  void inject(LoginActivity activity);
}
