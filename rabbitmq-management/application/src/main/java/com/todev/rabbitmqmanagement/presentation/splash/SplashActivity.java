package com.todev.rabbitmqmanagement.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivity;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.presentation.configure.ConfigureActivity;

public class SplashActivity extends LimboActivity<SplashView, SplashPresenter> implements SplashView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public SplashPresenter createPresenter() {
    return new SplashPresenter();
  }

  //endregion

  //region Navigation

  @Override
  public void navigateToConfigureView() {

    // Prepare intent that starts new activity.
    final Intent intent = new Intent(this, ConfigureActivity.class);

    // Start configure activity.
    startActivity(intent);
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    // Start counting automatic continue.
    getPresenter().observeAutomaticContinue();
  }

  //endregion
}
