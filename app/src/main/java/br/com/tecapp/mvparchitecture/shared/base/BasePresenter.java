package com.example.vitormachado.mvparchitecture.shared.base;

import com.example.vitormachado.mvparchitecture.shared.exception.ExceptionUtils;

public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

    ExceptionUtils getExceptionUtils();

    void simpleError(Throwable throwable);

}
