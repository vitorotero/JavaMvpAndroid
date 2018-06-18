package br.com.tecapp.mvparchitecture.shared.base;

import io.reactivex.disposables.Disposable;

public interface BaseView {

    void addDisposable(Disposable disposable);

}
