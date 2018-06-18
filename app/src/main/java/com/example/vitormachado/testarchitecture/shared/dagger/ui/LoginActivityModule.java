package com.example.vitormachado.testarchitecture.shared.dagger.ui;

import com.example.vitormachado.testarchitecture.shared.exception.ExceptionUtils;
import com.example.vitormachado.testarchitecture.shared.manager.UserManager;
import com.example.vitormachado.testarchitecture.ui.login.LoginActivity;
import com.example.vitormachado.testarchitecture.ui.login.LoginContract;
import com.example.vitormachado.testarchitecture.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public class LoginActivityModule {

    @Provides
    LoginContract.Presenter providePresenter(LoginActivity view, ExceptionUtils exceptionUtils, UserManager userManager) {
        return new LoginPresenter(view, exceptionUtils, userManager);
    }

}
