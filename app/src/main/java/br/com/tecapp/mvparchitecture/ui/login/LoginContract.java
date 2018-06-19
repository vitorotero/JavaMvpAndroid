package br.com.tecapp.mvparchitecture.ui.login;

import br.com.tecapp.mvparchitecture.shared.base.BasePresenter;
import br.com.tecapp.mvparchitecture.shared.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {
        void openHome();
    }

    interface Presenter extends BasePresenter {

        void doSignIn(String mail, String password);

    }

}
