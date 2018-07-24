package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import br.com.tecapp.mvparchitecture.shared.dagger.ui.HomeActivityModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.LoginActivityModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.SplashActivityModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.dialogs.GenericModalModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.dialogs.GenericOneButtonModule;
import br.com.tecapp.mvparchitecture.shared.dagger.ui.dialogs.GenericTwoButtonModule;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericModal;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericOneButton;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericTwoButton;
import br.com.tecapp.mvparchitecture.ui.home.HomeActivity;
import br.com.tecapp.mvparchitecture.ui.login.LoginActivity;
import br.com.tecapp.mvparchitecture.ui.splash.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Vitor Otero on 12/06/18.
 */
@Module
public abstract class UiModule {

    @ContributesAndroidInjector(modules = GenericModalModule.class)
    abstract GenericModal GenericModalModule();

    @ContributesAndroidInjector(modules = GenericOneButtonModule.class)
    abstract GenericOneButton genericOneButtonModule();

    @ContributesAndroidInjector(modules = GenericTwoButtonModule.class)
    abstract GenericTwoButton genericTwoButtonModule();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity splashActivityModule();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityModule();

    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivityModule();

}
