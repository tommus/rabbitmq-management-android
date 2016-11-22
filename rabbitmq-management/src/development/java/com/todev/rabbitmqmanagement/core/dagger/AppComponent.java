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
package com.todev.rabbitmqmanagement.core.dagger;

import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.core.dagger.module.ApplicationModule;
import com.todev.rabbitmqmanagement.core.dagger.module.NetworkModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { ApplicationModule.class, NetworkModule.class })
public interface AppComponent extends DevelopmentAppGraph {

  final class Initializer {

    private Initializer() {
      throw new UnsupportedOperationException();
    }

    public static AppComponent init(RabbitMqManagementApplication application) {
      return DaggerAppComponent.builder().applicationModule(new ApplicationModule(application)).build();
    }
  }
}
