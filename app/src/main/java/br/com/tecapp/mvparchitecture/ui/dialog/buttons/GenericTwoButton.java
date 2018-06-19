package br.com.tecapp.mvparchitecture.ui.dialog.buttons;

import android.view.View;

import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;

public class GenericTwoButton extends GenericModal {

    @Override
    protected void create(View view) {
        super.create(view);
        btnNegative.setVisibility(View.VISIBLE);

        btnNegative.setOnClickListener(view1 -> {
            if (getButtonModal().getNegativeClick() != null) {
                getButtonModal().getNegativeClick().onClick(view1);
            }
            dismiss();
        });
    }

    public static GenericModal newInstance(GenericButtonModal buttonModal) {
        return newInstance(new GenericTwoButton(), buttonModal);
    }

}
