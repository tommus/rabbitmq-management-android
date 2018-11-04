package co.windly.rabbitmqmanagement.network.service;

import co.windly.rabbitmqmanagement.network.model.user.UserDto;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserApi {

  @GET("api/whoami")
  Single<UserDto> whoAmI();
}
