package co.windly.rabbitmqmanagement.domain.manager;

import co.windly.rabbitmqmanagement.domain.mapper.UserModelMapper;
import co.windly.rabbitmqmanagement.domain.model.user.User;
import co.windly.rabbitmqmanagement.network.manager.UserNetworkManager;
import io.reactivex.Single;
import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class UserDomainManager {

  //region Fields

  @Inject
  UserNetworkManager network;

  //@Inject
  //UserPersistenceManager persistence;

  @Inject
  UserModelMapper mapper;

  //endregion

  //region Constructor

  @Inject
  public UserDomainManager() {
    // No-op.
  }

  //endregion

  //region Who Am I

  public Single<User> whoAmI() {
    return
      network
        .whoAmI()
        .map(mapper::mapUserDtoToModel);
  }

  //endregion
}
