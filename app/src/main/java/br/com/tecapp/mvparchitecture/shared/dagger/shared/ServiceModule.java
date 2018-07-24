package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import br.com.tecapp.mvparchitecture.shared.service.UserService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Vitor Otero on 12/06/18.
 */
@Module
public class ServiceModule {

    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

}
