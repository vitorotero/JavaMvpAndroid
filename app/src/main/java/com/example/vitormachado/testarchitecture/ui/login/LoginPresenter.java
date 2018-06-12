package com.example.vitormachado.testarchitecture.ui.login;

import com.example.vitormachado.testarchitecture.shared.basemvp.BasePresenterImp;

public class LoginPresenter extends BasePresenterImp<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void detachView() {
    }
}
