package co.windly.rabbitmqmanagement.application;

import android.app.Application;
import co.windly.rabbitmqmanagement.domain.DomainComponent;
import co.windly.rabbitmqmanagement.utility.BuildConfig;
import co.windly.rabbitmqmanagement.utility.debug.DebugBridge;
import co.windly.rabbitmqmanagement.utility.log.WiLogger;

public class RabbitMqManagement extends Application {

  //region Lifecycle

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize dependency graph.
    initializeDependencyInjection();

    // Initialize tools.
    initializeDebugBridge();
    initializeLeakCanary();
    initializeLogger();
  }

  //endregion

  //region Debug Bridge

  private void initializeDebugBridge() {
    DebugBridge
      .init(BuildConfig.ENABLE_DEBUG_BRIDGE, this);
  }

  //endregion

  //region Dependency Injection

  private DomainComponent component;

  private void initializeDependencyInjection() {

    // Initialize domain component.
    component =
      DomainComponent.Initializer.initialize(this);
  }

  public DomainComponent getDomainInjector() {
    return component;
  }

  //endregion

  //region Leak Canary

  private void initializeLeakCanary() {
    // TODO:
  }

  //endregion

  //region Logger

  private void initializeLogger() {
    WiLogger
      .init(BuildConfig.ENABLE_LOGGER);
  }

  //endregion
}
