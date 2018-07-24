package br.com.tecapp.mvparchitecture.shared.exception;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class AppException {

    @SerializedName("code") private long errorCode;
    @SerializedName("message") private String message;

    public AppException(long errorCode, String message) {
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
