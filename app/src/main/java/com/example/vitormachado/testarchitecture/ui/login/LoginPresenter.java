package com.example.vitormachado.testarchitecture.ui.login;

import android.util.Log;

import com.example.vitormachado.testarchitecture.shared.base.BasePresenterImp;
import com.example.vitormachado.testarchitecture.shared.manager.UserManager;
import com.example.vitormachado.testarchitecture.shared.manager.UserManagerImp;

public class LoginPresenter extends BasePresenterImp<LoginContract.View> implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private UserManager userManager;

    public LoginPresenter(LoginContract.View view, UserManager userManager) {
        super(view);
        this.userManager = userManager;
    }

    @Override
    public void detachView() {
        userManager.detach();
    }

    @Override
    public void teste() {
        Log.d(TAG, "teste: teste");
    }
}
