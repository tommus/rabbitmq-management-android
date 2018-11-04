package co.windly.rabbitmqmanagement.persistence;

import android.content.Context;
import dagger.Module;

@Module
public class PersistenceModule {

  //region Context

  private Context context;

  //endregion

  //region Constructor

  public PersistenceModule(Context context) {
    this.context = context;
  }

  //endregion

  //region Database

  // TODO:

  //endregion

  //region Shared Preference

  // TODO:

  //endregion
}
