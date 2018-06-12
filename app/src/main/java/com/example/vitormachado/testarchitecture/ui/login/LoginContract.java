package com.example.vitormachado.testarchitecture.ui.login;

import com.example.vitormachado.testarchitecture.shared.base.BasePresenter;
import com.example.vitormachado.testarchitecture.shared.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {}

    interface Presenter extends BasePresenter {

        void doSignIn(String mail, String password);
    }

}
