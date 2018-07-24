package br.com.tecapp.mvparchitecture.shared.base;

import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
import io.reactivex.disposables.Disposable;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface BaseView {

    void addDisposable(Disposable disposable);

    void showGenericOneButton(GenericButtonModal buttonModal);

    void showGenericTwoButton(GenericButtonModal buttonModal);

    void showLoading();

    void hideLoading();

}
