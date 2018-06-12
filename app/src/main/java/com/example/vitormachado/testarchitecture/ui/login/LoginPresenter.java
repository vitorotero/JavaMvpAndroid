package com.example.vitormachado.testarchitecture.ui.login;

import android.util.Log;

import com.example.vitormachado.testarchitecture.shared.base.BasePresenterImp;
import com.example.vitormachado.testarchitecture.shared.manager.UserManager;
import com.example.vitormachado.testarchitecture.shared.model.User;
import com.example.vitormachado.testarchitecture.util.StringUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenterImp<LoginContract.View> implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private UserManager userManager;

    public LoginPresenter(LoginContract.View view, UserManager userManager) {
        super(view);
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::doSignInSuccess, this::doSignInError)
        );
    }

    private void doSignInError(Throwable throwable) {
        Log.d(TAG, "doSignInError: ", throwable);
        Log.d(TAG, "doSignInError: ", throwable);
        Log.d(TAG, "doSignInError: ", throwable);
        Log.d(TAG, "doSignInError: ", throwable);
        Log.d(TAG, "doSignInError: ", throwable);
        Log.d(TAG, "doSignInError: ", throwable);
    }

    private void doSignInSuccess(User user) {
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
        Log.d(TAG, "doSignInSuccess: " + user.getMail());
    }
}
