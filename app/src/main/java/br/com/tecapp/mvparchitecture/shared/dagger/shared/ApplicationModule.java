package br.com.tecapp.mvparchitecture.shared.dagger.shared;

import android.app.Application;
import android.content.Context;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtils;
import br.com.tecapp.mvparchitecture.shared.exception.ExceptionUtilsImp;
import br.com.tecapp.mvparchitecture.shared.model.MyObjectBox;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static br.com.tecapp.mvparchitecture.util.DateUtils.DATE_TIME_SERVER;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    static Retrofit provideRetrofit(Context context) {
        Gson gson = createGSON();

        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.SERVER_API_URL))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    static BoxStore provideObjectBox(Context context) {
        return MyObjectBox.builder().androidContext(context).build();
    }

    @Provides
    static ExceptionUtils provideExceptionUtils(Retrofit retrofit, Context context) {
        return new ExceptionUtilsImp(retrofit, context);
    }

    private static Gson createGSON() {
        return new GsonBuilder()
                .setDateFormat(DATE_TIME_SERVER)
                .create();
    }

}
