package br.com.tecapp.mvparchitecture.shared.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class GenericButtonModal {

    private int icon;
    private int message;
    private String messageStr;
    private ButtonModalClick positiveClick;
    private ButtonModalClick negativeClick;

    public GenericButtonModal(@DrawableRes int icon,
                              @StringRes int message,
                              @NonNull ButtonModalClick positiveClick,
                              @NonNull ButtonModalClick negativeClick) {
        this.icon = icon;
        this.message = message;
        this.positiveClick = positiveClick;
        this.negativeClick = negativeClick;
    }

    public GenericButtonModal(@DrawableRes int icon,
                              @StringRes int message,
                              @NonNull ButtonModalClick positiveClick) {
        this.icon = icon;
        this.message = message;
        this.positiveClick = positiveClick;
    }

    public GenericButtonModal(@DrawableRes int icon,
                              @StringRes int message) {
        this.icon = icon;
        this.message = message;
    }

    /**
     * Construtor reservado apenas para erros genericos do BasePresenter
     *
     * @param icon    icone a ser exibido no modal
     * @param message mensagem a ser exibida no modal
     */
    public GenericButtonModal(@DrawableRes int icon,
                              @NonNull String message) {
        this.icon = icon;
        this.messageStr = message;
    }

    public int getIcon() {
        return icon;
    }

    public int getMessage() {
        return message;
    }

    public String getMessageStr() {
        return messageStr;
    }

    public ButtonModalClick getPositiveClick() {
        return positiveClick;
    }

    public ButtonModalClick getNegativeClick() {
        return negativeClick;
    }

    public interface ButtonModalClick {
        void onClick(View view);
    }

}
