package br.com.tecapp.mvparchitecture.ui.dialog.buttons;

import android.view.View;

import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;

public class GenericOneButton extends GenericModal {

    @Override
    protected void create(View view) {
        super.create(view);
        btnNegative.setVisibility(View.GONE);
    }

    public static GenericModal newInstance(GenericButtonModal buttonModal) {
        return newInstance(new GenericOneButton(), buttonModal);
    }

}
