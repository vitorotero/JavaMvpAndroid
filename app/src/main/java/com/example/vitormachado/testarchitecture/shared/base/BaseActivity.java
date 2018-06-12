package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends DaggerActivity implements BaseView {

    private CompositeDisposable disposables;

    protected abstract int contentLayout();

    protected abstract void create();

    protected abstract void destroy();

    public static Intent getIntent(Context from) {
        throw new IllegalArgumentException("Please override this method");
    }

    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentLayout());
        ButterKnife.bind(this);

        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }

        create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposables != null) {
            disposables.clear();
            disposables.dispose();
        }

        destroy();
    }

}
