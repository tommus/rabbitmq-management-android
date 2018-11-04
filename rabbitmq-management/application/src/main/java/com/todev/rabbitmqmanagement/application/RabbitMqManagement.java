/*
 * Copyright (c) 2016 to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.application;

import android.app.Application;
import co.windly.rabbitmqmanagement.domain.DomainComponent;
import co.windly.rabbitmqmanagement.domain.DomainModule;
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

    // Initialize network module.
    final DomainModule domainModule = new DomainModule();

    // Initialize domain component.
    component =
      DaggerDomainComponent
        .builder()
        .domainModule(domainModule)
        .build();
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
