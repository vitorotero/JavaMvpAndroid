package br.com.tecapp.mvparchitecture.shared.base;

import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;

public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

    ExceptionUtils getExceptionUtils();

    void simpleError(Throwable throwable);

}
