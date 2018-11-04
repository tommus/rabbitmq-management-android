package co.windly.rabbitmqmanagement.persistence.manager;

import io.reactivex.annotations.SchedulerSupport;
import javax.inject.Inject;

import static io.reactivex.annotations.SchedulerSupport.IO;

@SchedulerSupport(value = IO)
public class UserPersistenceManager {

  //region Fields

  // TODO:

  //endregion

  //region Constructor

  @Inject
  UserPersistenceManager() {
    // No-op.
  }

  //endregion
}
