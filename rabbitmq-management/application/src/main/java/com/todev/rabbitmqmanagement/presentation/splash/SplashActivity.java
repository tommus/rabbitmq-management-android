package com.todev.rabbitmqmanagement.presentation.splash;

import androidx.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivity;
import com.todev.rabbitmqmanagement.R;

public class SplashActivity extends LimboActivity<SplashView, SplashPresenter> {

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
}
