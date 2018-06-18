package com.example.vitormachado.mvparchitecture.shared.exception;

public interface ExceptionUtils {

    AppException getMessageFromThrowable(Throwable throwable);

}
