package br.com.tecapp.mvparchitecture.shared.exception;

import android.support.annotation.StringRes;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class ObjectBoxException extends Exception {

    private int messageRes;

    public ObjectBoxException(@StringRes int messageRes) {
        this.messageRes = messageRes;
    }

    public int getMessageRes() {
        return messageRes;
    }

}
