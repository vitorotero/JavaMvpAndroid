package com.example.vitormachado.testarchitecture.shared.dagger.shared;

import com.example.vitormachado.testarchitecture.shared.dagger.ui.LoginActivityModule;
import com.example.vitormachado.testarchitecture.shared.dagger.ui.SplashActivityModule;
import com.example.vitormachado.testarchitecture.ui.login.LoginActivity;
import com.example.vitormachado.testarchitecture.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public abstract class UiModule {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity SplashActivityModule();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityModule();

}
