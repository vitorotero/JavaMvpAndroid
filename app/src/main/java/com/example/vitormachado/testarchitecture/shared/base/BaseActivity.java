package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends DaggerActivity implements BaseView {

    private CompositeDisposable disposable;

    protected abstract int contentLayout();

    protected abstract void create();

    protected abstract void destroy();

    public static Intent getIntent(Context from) {
        throw new IllegalArgumentException("Please override this method");
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentLayout());
        ButterKnife.bind(this);

        if (disposable == null || disposable.isDisposed()) {
            disposable = new CompositeDisposable();
        }

        create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        destroy();
    }

}
