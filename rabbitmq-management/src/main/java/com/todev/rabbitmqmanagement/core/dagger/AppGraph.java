package com.todev.rabbitmqmanagement.core.dagger;

import com.todev.rabbitmqmanagement.ui.login.LoginActivity;
import com.todev.rabbitmqmanagement.ui.overview.OverviewActivity;

public interface AppGraph {
  void inject(LoginActivity activity);

  void inject(OverviewActivity activity);
}
