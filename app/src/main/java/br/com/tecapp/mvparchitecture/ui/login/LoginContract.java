package com.example.vitormachado.mvparchitecture.ui.login;

import com.example.vitormachado.mvparchitecture.shared.base.BasePresenter;
import com.example.vitormachado.mvparchitecture.shared.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {}

    interface Presenter extends BasePresenter {

        void doSignIn(String mail, String password);

    }

}
