package co.windly.rabbitmqmanagement.network.manager;

import co.windly.rabbitmqmanagement.network.model.user.UserDto;
import co.windly.rabbitmqmanagement.network.service.UserApi;
import io.reactivex.Single;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

import static io.reactivex.annotations.SchedulerSupport.IO;

@SchedulerSupport(value = IO)
@SuppressWarnings("WeakerAccess")
public class UserNetworkManager {

  //region Service

  @Inject
  UserApi api;

  //endregion

  //region Constructor

  @Inject
  UserNetworkManager() {
    // No-op.
  }

  //endregion

  //region Who Am I

  public Single<UserDto> whoAmI() {
    return api
      .whoAmI()
      .subscribeOn(Schedulers.io());
  }

  //endregion
}
