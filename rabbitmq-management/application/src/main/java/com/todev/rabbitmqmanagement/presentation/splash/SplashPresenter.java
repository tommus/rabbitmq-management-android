package com.todev.rabbitmqmanagement.presentation.splash;

import androidx.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivityPresenter;
import co.windly.rabbitmqmanagement.utility.log.WiLogger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

class SplashPresenter extends LimboActivityPresenter<SplashView> {

  //region Automatic Continue

  private static final Long AUTO_CONTINUE_DELAY = 2_000L;

  void observeAutomaticContinue() {
    disposables.add(
      Observable.timer(AUTO_CONTINUE_DELAY, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::handleObserveAutomaticContinueSuccess,
          this::handleObserveAutomaticContinueError));
  }

  private void handleObserveAutomaticContinueSuccess(@NonNull Long delay) {

    // Log the fact.
    WiLogger.v("Automatic continue time passed: %d", delay);
    WiLogger.v("Navigating to home.");

    // Navigate to home.
    ifViewAttached(SplashView::navigateToConfigureView);
  }

  private void handleObserveAutomaticContinueError(@NonNull Throwable throwable) {

    // Log an error.
    WiLogger.e("An error occurred while counting automatic continue.");

    // Navigate anyway.
    ifViewAttached(SplashView::navigateToConfigureView);
  }

  //endregion
}
