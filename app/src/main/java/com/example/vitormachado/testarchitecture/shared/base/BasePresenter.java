package com.example.vitormachado.testarchitecture.shared.base;

import com.example.vitormachado.testarchitecture.shared.exception.ExceptionUtils;

public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

    ExceptionUtils getExceptionUtils();

    void simpleError(Throwable throwable);

}
