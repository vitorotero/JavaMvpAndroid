package br.com.tecapp.mvparchitecture.shared.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericModal;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericOneButton;
import br.com.tecapp.mvparchitecture.ui.dialog.buttons.GenericTwoButton;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity implements BaseView {

    private CompositeDisposable disposables;

    protected abstract int contentLayout();

    protected abstract void create();

    protected abstract void destroy();

    public static Intent getIntent(Context from) {
        throw new IllegalArgumentException("Please override this method");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentLayout());
        ButterKnife.bind(this);

        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }

        create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposables != null) {
            disposables.clear();
            disposables.dispose();
        }

        destroy();
    }

    @Override
    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void showGenericOneButton(GenericButtonModal buttonModal) {
        GenericModal modal = GenericOneButton.newInstance(buttonModal);
        modal.show(getFragmentManager(), GenericOneButton.class.getSimpleName());
    }

    @Override
    public void showGenericTwoButton(GenericButtonModal buttonModal) {
        GenericModal modal = GenericTwoButton.newInstance(buttonModal);
        modal.show(getFragmentManager(), GenericTwoButton.class.getSimpleName());
    }
}
