package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import br.com.tecapp.mvparchitecture.shared.manager.UserManager;
import br.com.tecapp.mvparchitecture.shared.manager.UserManagerImp;
import br.com.tecapp.mvparchitecture.shared.repository.UserRepository;
import br.com.tecapp.mvparchitecture.shared.service.UserService;
import dagger.Module;
import dagger.Provides;

/**
 * @author Vitor Otero on 12/06/18.
 */
@Module
public class ManagerModule {

    @Provides
    UserManager provideUserManager(UserService userService, UserRepository userRepository) {
        return new UserManagerImp(userService, userRepository);
    }

}
