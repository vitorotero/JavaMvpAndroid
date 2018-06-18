package com.example.vitormachado.mvparchitecture.ui.splash;

import android.os.CountDownTimer;

import com.example.vitormachado.mvparchitecture.R;
import com.example.vitormachado.mvparchitecture.shared.base.BaseActivity;
import com.example.vitormachado.mvparchitecture.ui.login.LoginActivity;
import com.example.vitormachado.mvparchitecture.util.NavigationUtils;

/**
 * @author vitor.machado on 08/06/18.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int contentLayout() {
        return R.layout.splash;
    }

    @Override
    protected void create() {
        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                NavigationUtils.openActivity(SplashActivity.this,
                        LoginActivity.getIntent(SplashActivity.this)
                );
            }
        }.start();
    }

    @Override
    protected void destroy() {

    }
}
