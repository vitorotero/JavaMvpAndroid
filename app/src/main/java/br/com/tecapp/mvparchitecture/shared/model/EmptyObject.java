package br.com.tecapp.mvparchitecture.shared.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class EmptyObject {

    public static final int ICON_RESOURCE_ZERO = 0;

    private String message;
    private int icon;
    private String buttonText;
    private View.OnClickListener listener;
    private View.OnClickListener layoutListener;

    public EmptyObject(String message, @DrawableRes int icon) {
        this.message = message;
        this.icon = icon;
    }

    public EmptyObject(String message,
                       @DrawableRes int icon,
                       @Nullable View.OnClickListener layoutListener) {
        this.message = message;
        this.icon = icon;
        this.layoutListener = layoutListener;
    }

    public EmptyObject(String message) {
        this.message = message;
    }

    public EmptyObject(String message,
                       @DrawableRes int icon,
                       @Nullable View.OnClickListener layoutListener,
                       @Nullable String buttonText,
                       @Nullable View.OnClickListener listener) {
        this.message = message;
        this.icon = icon;
        this.buttonText = buttonText;
        this.listener = listener;
        this.layoutListener = layoutListener;
    }

    public EmptyObject(@Nullable String buttonText,
                       @Nullable View.OnClickListener listener) {

        this.buttonText = buttonText;
        this.listener = listener;
    }

    public String getMessage() {
        return message;
    }

    public int getIcon() {
        return icon;
    }

    public String getButtonText() {
        return buttonText;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public View.OnClickListener getLayoutListener() {
        return layoutListener;
    }

    public void setLayoutListener(View.OnClickListener layoutListener) {
        this.layoutListener = layoutListener;
    }
}
