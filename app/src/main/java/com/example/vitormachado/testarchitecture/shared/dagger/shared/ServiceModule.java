package com.example.vitormachado.testarchitecture.shared.dagger.shared;

import com.example.vitormachado.testarchitecture.shared.Service.UserService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class ServiceModule {

    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

}
