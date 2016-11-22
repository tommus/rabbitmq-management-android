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
package com.todev.rabbitmqmanagement;

import android.app.Application;
import android.content.Context;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.todev.rabbitmqmanagement.core.dagger.AppComponent;
import lombok.Getter;

public class RabbitMqManagementApplication extends Application {

  @Getter private AppComponent component;

  public static RabbitMqManagementApplication get(Context context) {
    return (RabbitMqManagementApplication) context.getApplicationContext();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    initDagger();
    initDatabase();
  }

  @Override
  public void onTerminate() {
    super.onTerminate();
    freeDatabase();
  }

  private void initDagger() {
    component = AppComponent.Initializer.init(this);
  }

  private void initDatabase() {
    FlowManager.init(new FlowConfig.Builder(this).build());
  }

  private void freeDatabase() {
    FlowManager.destroy();
  }
}
