package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import br.com.tecapp.mvparchitecture.shared.dagger.ui.LoginActivityModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.SplashActivityModule;
import br.com.tecapp.mvparchitecture.ui.login.LoginActivity;
import br.com.tecapp.mvparchitecture.ui.splash.SplashActivity;

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
