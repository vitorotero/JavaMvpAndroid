package br.com.tecapp.mvparchitecture.shared.exception;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.Log;

import br.com.tecapp.mvparchitecture.R;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExceptionUtilsImp implements ExceptionUtils {

    private static final long DEFAULT_CODE = -1;
    private static final String TAG = ExceptionUtilsImp.class.getSimpleName();
    private Retrofit retrofit;
    private Context context;

    public ExceptionUtilsImp(Retrofit retrofit, Context context) {
        this.retrofit = retrofit;
        this.context = context;
    }

    @Override
    public AppException getMessageFromThrowable(Throwable throwable) {
        AppException appException =
                new AppException(DEFAULT_CODE, getString(R.string.generic_error_message));

        if (throwable instanceof HttpException) {
            appException = converterResponse(((HttpException) throwable).response());
        } else if (throwable instanceof IOException) {
            appException = new AppException(DEFAULT_CODE,
                    getString(R.string.generic_error_no_network)
            );
        } else if (throwable instanceof ObjectBoxException) {
            String message = getString(((ObjectBoxException) throwable).getMessageRes());
            appException = new AppException(DEFAULT_CODE, message);
        } else if (throwable instanceof NullPointerException) {
            appException = new AppException(DEFAULT_CODE, throwable.getMessage());
        }

        return appException;
    }

    private AppException converterResponse(Response<?> response) {
        Converter<ResponseBody, AppException> converter = retrofit.responseBodyConverter
                (AppException.class, new Annotation[0]);

        try {
            return converter.convert(response.errorBody());
        } catch (IOException
                | NullPointerException
                | IllegalStateException
                | JsonSyntaxException e) {
            Log.d(TAG, "converterResponse: ", e);
        }

        return new AppException(response.code(),
                getString(R.string.generic_service_error_message)
        );
    }

    private String getString(@StringRes int res) {
        return context.getString(res);
    }
}
