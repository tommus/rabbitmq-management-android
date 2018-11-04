package co.windly.rabbitmqmanagement.domain.mapper;

import co.windly.rabbitmqmanagement.domain.model.user.User;
import co.windly.rabbitmqmanagement.network.model.user.UserDto;
import io.reactivex.annotations.NonNull;
import java.util.List;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;

import static io.reactivex.Observable.fromIterable;
import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class UserModelMapper {

  //region Model Mapper

  private ModelMapper mapper;

  //endregion

  //region Constructor

  @Inject
  UserModelMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  //endregion

  //region UserDto -> User

  public User mapUserDtoToModel(@NonNull UserDto dto) {
    return mapper.map(dto, User.class);
  }

  public List<User> mapUserDtoListToModelList(@NonNull List<UserDto> dtoList) {
    return fromIterable(defaultIfNull(dtoList, emptyList()))
      .map(this::mapUserDtoToModel)
      .toList()
      .blockingGet();
  }

  //endregion
}
