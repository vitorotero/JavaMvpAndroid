package com.example.vitormachado.mvparchitecture.shared.dagger.shared;

import com.example.vitormachado.mvparchitecture.shared.repository.UserRepository;
import com.example.vitormachado.mvparchitecture.shared.repository.UserRepositoryImp;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class RepositoryModule {

    @Provides
    UserRepository provideUserRepository(BoxStore boxStore) {
        return new UserRepositoryImp(boxStore);
    }

}
