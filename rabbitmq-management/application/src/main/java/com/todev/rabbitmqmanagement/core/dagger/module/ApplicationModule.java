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
package com.todev.rabbitmqmanagement.core.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.todev.rabbitmqmanagement.application.RabbitMqManagement;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {
  private static final String PREFS_NAME = "com.todev.rabbitmqmanagement";

  private final RabbitMqManagement application;

  public ApplicationModule(RabbitMqManagement application) {
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
