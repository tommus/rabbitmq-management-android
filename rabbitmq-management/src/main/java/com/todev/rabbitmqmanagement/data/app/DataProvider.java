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
package com.todev.rabbitmqmanagement.data.app;

import android.content.SharedPreferences;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.todev.rabbitmqmanagement.data.app.model.Credentials;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataProvider {
  protected SharedPreferences sharedPreferences;

  @Inject
  public DataProvider(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  public Observable<List<Service>> getServices() {
    return Observable.defer(() -> Observable.just(new Select().from(Service.class).queryList()));
  }

  public Observable<Credentials> getCredentials() {
    return Observable.defer(() -> Observable.just(new Credentials(sharedPreferences)));
  }
}
