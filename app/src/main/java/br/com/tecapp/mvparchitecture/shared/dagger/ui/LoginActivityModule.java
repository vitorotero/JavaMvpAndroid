package br.com.tecapp.mvparchitecture.shared.dagger.ui;

import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import br.com.tecapp.mvparchitecture.shared.manager.UserManager;
import br.com.tecapp.mvparchitecture.ui.login.LoginActivity;
import br.com.tecapp.mvparchitecture.ui.login.LoginContract;
import br.com.tecapp.mvparchitecture.ui.login.LoginPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Vitor Otero on 12/06/18.
 */
@Module
public class LoginActivityModule {

    @Provides
    LoginContract.Presenter providePresenter(LoginActivity view, ExceptionUtils exceptionUtils, UserManager userManager) {
        return new LoginPresenter(view, exceptionUtils, userManager);
    }

}
