package com.todev.rabbitmqmanagement.core.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {
  private static final String PREFS_NAME = "com.todev.rabbitmqmanagement";

  private final RabbitMqManagementApplication application;

  public ApplicationModule(RabbitMqManagementApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return application;
  }

  @Provides
  @Singleton
  Context provideContext() {
    return application;
  }

  @Provides
  @Singleton
  SharedPreferences provideSharedPreferences(Context context) {
    return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
  }
}
