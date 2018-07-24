package br.com.tecapp.mvparchitecture.shared.exception;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface ExceptionUtils {

    AppException getMessageFromThrowable(Throwable throwable);

}
