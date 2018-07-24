package br.com.tecapp.mvparchitecture.shared.base;

import android.content.Context;

import br.com.tecapp.mvparchitecture.shared.exception.AppException;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
import br.com.tecapp.mvparchitecture.shared.schedulers.SchedulerProvider;
import br.com.tecapp.mvparchitecture.shared.schedulers.SchedulerProviderImp;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BasePresenterImp<V extends BaseView> implements BasePresenter {

    protected SchedulerProvider scheduler;
    private CompositeDisposable disposables;
    private ExceptionUtils exceptionUtils;
    private V view;

    public BasePresenterImp(V view, ExceptionUtils exceptionUtils) {
        this.view = view;
        this.exceptionUtils = exceptionUtils;
        scheduler = new SchedulerProviderImp();

        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
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
        if (disposables != null) {
            disposables.clear();
            disposables.dispose();
        }
    }

    @Override
    public ExceptionUtils getExceptionUtils() {
        return exceptionUtils;
    }

    @Override
    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void simpleError(Throwable throwable) {
        AppException appException = exceptionUtils.getMessageFromThrowable(throwable);
        getView().showGenericOneButton(new GenericButtonModal(android.R.drawable.ic_dialog_alert,
                appException.getMessage())
        );
    }
}
