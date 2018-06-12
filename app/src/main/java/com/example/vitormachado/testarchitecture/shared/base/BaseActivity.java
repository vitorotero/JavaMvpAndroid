package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.vitormachado.testarchitecture.shared.basemvp.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected abstract int contentLayout();

    protected abstract void create();

    protected abstract void destroy();

    public static Intent getIntent(Context from) {
        throw new IllegalArgumentException("Please override this method");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentLayout());

        create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }

}
