package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenterImp<V extends BaseView> implements BasePresenter {

    private V view;
    private CompositeDisposable disposable;

    public BasePresenterImp(V view) {
        this.view = view;

        if (disposable == null || disposable.isDisposed()) {
            disposable = new CompositeDisposable();
        }
    }

    public V getView() {
        return view;
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }

    @Override
    public String getStringByResId(int id) {
        if (view == null) {
            throw new NullPointerException("BasePresenverImp: View not attached");
        }

        return ((Context) view).getString(id);
    }

    @Override
    public String getStringByResId(int id, Object... args) {
        if (view == null) {
            throw new NullPointerException("BasePresenverImp: View not attached");
        }

        return ((Context) view).getString(id, args);
    }

    @Override
    public void detachView() {
        disposable.dispose();
        view = null;
    }
}
