package com.example.vitormachado.testarchitecture.shared.base;

import android.content.Context;

import com.example.vitormachado.testarchitecture.shared.exception.AppException;
import com.example.vitormachado.testarchitecture.shared.exception.ExceptionUtils;
import com.example.vitormachado.testarchitecture.shared.schedulers.BaseSchedulerProvider;
import com.example.vitormachado.testarchitecture.shared.schedulers.SchedulerProvider;

public abstract class BasePresenterImp<V extends BaseView> implements BasePresenter {

    protected BaseSchedulerProvider scheduler;
    private ExceptionUtils exceptionUtils;
    private V view;

    public BasePresenterImp(V view, ExceptionUtils exceptionUtils) {
        this.view = view;
        this.exceptionUtils = exceptionUtils;
        scheduler = SchedulerProvider.getInstance();
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
