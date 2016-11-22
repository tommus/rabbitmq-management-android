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

import android.os.Build;
import com.facebook.stetho.Stetho;
import com.frogermcs.androiddevmetrics.AndroidDevMetrics;
import com.squareup.leakcanary.LeakCanary;
import com.todev.rabbitmqmanagement.core.dagger.AppComponent;
import jp.wasabeef.takt.Takt;

public class DevelopmentRabbitMqManagementApplication extends RabbitMqManagementApplication {

  private static final boolean DISPLAY_FPS = false;

  private static final boolean ENABLE_ANDROID_DEV_METRICS = false;

  @Override
  public void onCreate() {
    super.onCreate();
    AppComponent.Initializer.init(this).inject(this);
    displayFps(true);
    initAndroidDevMetrics();
    initStetho();
    initLeakCanary();
  }

  @Override
  public void onTerminate() {
    displayFps(false);
    super.onTerminate();
  }

  private void displayFps(boolean display) {
    if (DISPLAY_FPS && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      if (display) {
        Takt.stock(this).play();
      } else {
        Takt.finish();
      }
    }
  }

  private void initAndroidDevMetrics() {
    if (ENABLE_ANDROID_DEV_METRICS) {
      AndroidDevMetrics.initWith(this);
    }
  }

  private void initStetho() {
    Stetho.initializeWithDefaults(this);
  }

  private void initLeakCanary() {
    if (!BuildConfig.IS_DEVELOPMENT) {
      return;
    }
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);
  }
}
