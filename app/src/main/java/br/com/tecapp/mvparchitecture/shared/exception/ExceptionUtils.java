package br.com.tecapp.mvparchitecture.shared.exception;

public interface ExceptionUtils {

    AppException getMessageFromThrowable(Throwable throwable);

}
