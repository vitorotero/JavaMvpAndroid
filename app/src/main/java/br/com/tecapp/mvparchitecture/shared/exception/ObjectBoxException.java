package com.example.vitormachado.mvparchitecture.shared.exception;

import android.support.annotation.StringRes;

public class ObjectBoxException extends Exception {

    private int messageRes;

    public ObjectBoxException(@StringRes int messageRes) {
        this.messageRes = messageRes;
    }

    public int getMessageRes() {
        return messageRes;
    }

}
