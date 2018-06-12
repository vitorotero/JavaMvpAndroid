package com.example.vitormachado.testarchitecture.shared.dagger.shared;

import android.app.Application;
import android.content.Context;

import com.example.vitormachado.testarchitecture.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vitormachado.testarchitecture.util.DateUtils.DATE_TIME_SERVER;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    static Retrofit provideRetrofit(Context context) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.SERVER_API_URL))
                .addConverterFactory(GsonConverterFactory.create(createGSON()))
                .build();
    }

    private static Gson createGSON() {
        return new GsonBuilder()
                .setDateFormat(DATE_TIME_SERVER)
                .create();
    }

}
