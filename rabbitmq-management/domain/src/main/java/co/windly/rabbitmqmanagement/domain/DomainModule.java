package co.windly.rabbitmqmanagement.domain;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;
import javax.inject.Singleton;
import org.modelmapper.ModelMapper;

@Module
public class DomainModule {

  //region Model Mapper

  @NonNull
  @Provides
  @Singleton
  ModelMapper provideModelMapper() {
    final ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setAmbiguityIgnored(true);
    mapper.getConfiguration().setSkipNullEnabled(true);
    return mapper;
  }

  //endregion
}
