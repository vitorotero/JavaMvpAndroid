package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;

import com.example.vitormachado.testarchitecture.shared.exception.AppException;
import com.example.vitormachado.testarchitecture.shared.exception.ExceptionUtils;
import com.example.vitormachado.testarchitecture.shared.exception.ExceptionUtilsImp;

import javax.inject.Inject;

public abstract class BasePresenterImp<V extends BaseView> implements BasePresenter {

    private ExceptionUtils exceptionUtils;
    private V view;

    public BasePresenterImp(V view, ExceptionUtils exceptionUtils) {
        this.view = view;
        this.exceptionUtils = exceptionUtils;
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

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public ExceptionUtils getExceptionUtils() {
        return exceptionUtils;
    }

    @Override
    public void simpleError(Throwable throwable) {
        //TODO: continuar a implementação quando criar os alertas genericos
        AppException appException = exceptionUtils.getMessageFromThrowable(throwable);
    }
}
