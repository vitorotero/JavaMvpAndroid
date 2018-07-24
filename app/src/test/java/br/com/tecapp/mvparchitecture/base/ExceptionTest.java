package br.com.tecapp.mvparchitecture.base;

import br.com.tecapp.mvparchitecture.shared.exception.AppException;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class ExceptionTest implements ExceptionUtils {

    @Override
    public AppException getMessageFromThrowable(Throwable throwable) {
        return new AppException(-1, throwable.getMessage());
    }

}