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
