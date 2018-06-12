package com.example.vitormachado.testarchitecture.shared.dagger.shared;

import com.example.vitormachado.testarchitecture.shared.Service.UserService;
import com.example.vitormachado.testarchitecture.shared.manager.UserManager;
import com.example.vitormachado.testarchitecture.shared.manager.UserManagerImp;

import dagger.Module;
import dagger.Provides;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class ManagerModule {

    @Provides
    UserManager provideUserManager(UserService userService) {
        return new UserManagerImp(userService);
    }

}
