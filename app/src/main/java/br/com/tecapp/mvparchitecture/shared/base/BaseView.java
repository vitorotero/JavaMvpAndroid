package br.com.tecapp.mvparchitecture.shared.base;

import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
import io.reactivex.disposables.Disposable;

public interface BaseView {

    void addDisposable(Disposable disposable);

    void showGenericOneButton(GenericButtonModal buttonModal);

    void showGenericTwoButton(GenericButtonModal buttonModal);

}
