package com.example.vitormachado.mvparchitecture.shared.base;

import io.reactivex.disposables.Disposable;

public interface BaseView {

    void addDisposable(Disposable disposable);

}
