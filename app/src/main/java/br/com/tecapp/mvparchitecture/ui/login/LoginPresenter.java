package br.com.tecapp.mvparchitecture.ui.login;

import android.util.Log;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.base.BasePresenterImp;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import br.com.tecapp.mvparchitecture.shared.manager.UserManager;
import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
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
            getView().showGenericOneButton(new GenericButtonModal(android.R.drawable.ic_dialog_alert,
                    R.string.login_mail_invalid)
            );
            return;
        }

        if (StringUtil.isEmpty(password)) {
            getView().showGenericOneButton(new GenericButtonModal(android.R.drawable.ic_dialog_alert,
                    R.string.login_password_invalid)
            );
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
