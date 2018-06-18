package com.example.vitormachado.mvparchitecture.shared.dagger.shared;

import com.example.vitormachado.mvparchitecture.shared.manager.UserManager;
import com.example.vitormachado.mvparchitecture.shared.manager.UserManagerImp;
import com.example.vitormachado.mvparchitecture.shared.repository.UserRepository;
import com.example.vitormachado.mvparchitecture.shared.service.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class ManagerModule {

    @Provides
    UserManager provideUserManager(UserService userService, UserRepository userRepository) {
        return new UserManagerImp(userService, userRepository);
    }

}
