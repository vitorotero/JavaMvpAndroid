package com.example.vitormachado.testarchitecture.ui.login;

import android.content.Context;
import android.content.Intent;

import com.example.vitormachado.testarchitecture.R;
import com.example.vitormachado.testarchitecture.shared.base.BaseActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
     LoginContract.Presenter presenter;

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
        presenter.teste();

    }

    @Override
    protected void destroy() {
        presenter.detachView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
