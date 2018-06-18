package br.com.tecapp.mvparchitecture.shared.exception;

import com.google.gson.annotations.SerializedName;

public class AppException {

    @SerializedName("code") private long errorCode;
    @SerializedName("message") private String message;

    AppException(long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
