package br.com.tecapp.mvparchitecture.ui.dialog.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.base.BaseDialog;
import br.com.tecapp.mvparchitecture.shared.model.GenericButtonModal;
import butterknife.BindView;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class GenericModal extends BaseDialog {

    @BindView(R.id.alert_generic_iv_icon) ImageView ivIcon;
    @BindView(R.id.alert_generic_tv_message) TextView tvMessage;
    @BindView(R.id.alert_generic_btn_positive) Button btnPositive;
    @BindView(R.id.alert_generic_btn_negative) Button btnNegative;

    private GenericButtonModal buttonModal;

    @Override
    protected int contentLayout() {
        return R.layout.alert_generic_modal;
    }

    @Override
    protected void create(View view) {
        ivIcon.setImageResource(getButtonModal().getIcon());

        if (getButtonModal().getMessageStr() != null) {
            tvMessage.setText(getButtonModal().getMessageStr());
        } else {
            tvMessage.setText(getButtonModal().getMessage());
        }

        btnPositive.setOnClickListener(view1 -> {
            if (getButtonModal().getPositiveClick() != null) {
                getButtonModal().getPositiveClick().onClick(view1);
            }
            dismiss();
        });
    }

    public static GenericModal newInstance(GenericModal modal, GenericButtonModal buttonModal) {
        modal.setButtonModal(buttonModal);
        modal.setCancelable(true);
        return modal;
    }

    public GenericButtonModal getButtonModal() {
        return buttonModal;
    }

    public void setButtonModal(GenericButtonModal buttonModal) {
        this.buttonModal = buttonModal;
    }
}
