package com.example.vitormachado.testarchitecture.ui.login;

import android.util.Log;

import com.example.vitormachado.testarchitecture.shared.basemvp.BasePresenterImp;

public class LoginPresenter extends BasePresenterImp<LoginContract.View> implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void detachView() {
    }

    @Override
    public void teste() {
        Log.d(TAG, "teste: teste");
    }
}
