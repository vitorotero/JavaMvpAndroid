package br.com.tecapp.mvparchitecture.shared.base;

import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import io.reactivex.disposables.Disposable;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

    ExceptionUtils getExceptionUtils();

    void addDisposable(Disposable disposable);

    void simpleError(Throwable throwable);

}
