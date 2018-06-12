package com.example.vitormachado.testarchitecture.shared.basemvp;

import android.content.Context;

public abstract class BasePresenterImp<V extends BaseView> implements BasePresenter {

    private V view;

    public BasePresenterImp(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
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
}
