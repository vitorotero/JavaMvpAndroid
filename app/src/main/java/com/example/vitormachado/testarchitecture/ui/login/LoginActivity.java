package com.example.vitormachado.testarchitecture.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;

import com.example.vitormachado.testarchitecture.R;
import com.example.vitormachado.testarchitecture.shared.base.BaseActivity;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.login_et_mail) TextInputEditText etEmail;
    @BindView(R.id.login_et_password) TextInputEditText etPassword;
    @BindView(R.id.login_btn_sign_in) AppCompatButton btnSignIn;

    @Inject LoginContract.Presenter presenter;

    public static Intent getIntent(Context from) {
        Intent intent = new Intent(from, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return intent;
    }

    @Override
    protected int contentLayout() {
        return R.layout.login;
    }

    @Override
    protected void create() {
        initEvents();
    }

    @Override
    protected void destroy() {
        presenter.detachView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initEvents() {
        getDisposable().add(RxView.clicks(btnSignIn)
                .debounce(100, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> presenter.doSignIn(etEmail.getText().toString(),
                        etPassword.getText().toString())
                )
        );
    }
}
