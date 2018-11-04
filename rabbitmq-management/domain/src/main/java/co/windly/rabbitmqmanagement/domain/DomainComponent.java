package co.windly.rabbitmqmanagement.domain;

import android.content.Context;
import co.windly.rabbitmqmanagement.domain.manager.UserDomainManager;
import co.windly.rabbitmqmanagement.network.NetworkModule;
import co.windly.rabbitmqmanagement.persistence.PersistenceModule;
import dagger.Component;
import io.reactivex.annotations.NonNull;
import javax.inject.Singleton;

@Singleton
@Component(modules = { DomainModule.class, NetworkModule.class, PersistenceModule.class })
public interface DomainComponent {

  //region Initializer

  class Initializer {

    private static DomainComponent instance;

    public static DomainComponent initialize(@NonNull Context context) {

      if (instance == null) {

        // Initialize network module.
        final NetworkModule networkModule = new NetworkModule();

        // Initialize persistence module.
        final PersistenceModule persistenceModule = new PersistenceModule(context);

        // Initialize domain module.
        final DomainModule domainModule = new DomainModule();

        // Initialize domain component.
        instance
          = DaggerDomainComponent
          .builder()
          .persistenceModule(persistenceModule)
          .networkModule(networkModule)
          .domainModule(domainModule)
          .build();
      }

      return instance;
    }
  }

  //endregion

  //region Injections

  UserDomainManager provideUserDomainManager();

  //endregion
}
