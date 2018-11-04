package co.windly.rabbitmqmanagement.domain;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { DomainModule.class /*, NetworkModule.class, PersistenceModule.class */ })
public interface DomainComponent {

  //region Injections

  // TODO:

  //endregion
}
