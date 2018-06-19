package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import br.com.tecapp.mvparchitecture.shared.repository.UserRepository;
import br.com.tecapp.mvparchitecture.shared.repository.UserRepositoryImp;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class RepositoryModule {

    @Provides
    UserRepository provideUserRepository(Realm realm) {
        return new UserRepositoryImp(realm);
    }

}
