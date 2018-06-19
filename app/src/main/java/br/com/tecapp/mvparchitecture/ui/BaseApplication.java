package br.com.tecapp.mvparchitecture.ui;

import android.content.Context;
import android.support.multidex.MultiDex;

import br.com.tecapp.mvparchitecture.shared.dagger.shared.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.realm.Realm;

/**
 * @author vitor.machado on 11/06/18.
 */
public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
