package br.com.tecapp.mvparchitecture.ui.login;

import br.com.tecapp.mvparchitecture.shared.base.BasePresenter;
import br.com.tecapp.mvparchitecture.shared.base.BaseView;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface LoginContract {

    interface View extends BaseView {
        void openHome();
    }

    interface Presenter extends BasePresenter {

        void doSignIn(String mail, String password);

    }

}
