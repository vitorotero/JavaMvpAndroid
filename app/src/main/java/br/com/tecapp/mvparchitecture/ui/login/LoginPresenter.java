package br.com.tecapp.mvparchitecture.ui.login;

import android.util.Log;

import br.com.tecapp.mvparchitecture.shared.base.BasePresenterImp;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import br.com.tecapp.mvparchitecture.shared.manager.UserManager;
import br.com.tecapp.mvparchitecture.shared.model.User;
import br.com.tecapp.mvparchitecture.util.StringUtil;

public class LoginPresenter extends BasePresenterImp<LoginContract.View>
        implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private UserManager userManager;

    public LoginPresenter(LoginContract.View view,
                          ExceptionUtils exceptionUtils,
                          UserManager userManager) {
        super(view, exceptionUtils);
        this.userManager = userManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        userManager.detach();
    }

    @Override
    public void doSignIn(String mail, String password) {
        if (StringUtil.isMailNotValid(mail)) {
            //TODO: Implementation generic modal native and show here
            return;
        }

        if (StringUtil.isEmpty(password) && password.length() < 4) {
            //TODO: Implementation generic modal native and show here
            return;
        }

        getView().addDisposable(userManager.doSignIn(mail, password)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(this::doSignInSuccess, this::simpleError)
        );
    }

    private void doSignInSuccess(User user) {
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
    }
}
