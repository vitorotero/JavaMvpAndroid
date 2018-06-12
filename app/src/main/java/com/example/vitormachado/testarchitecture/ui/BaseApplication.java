package com.example.vitormachado.testarchitecture.ui;

import com.example.vitormachado.testarchitecture.shared.dagger.shared.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author vitor.machado on 11/06/18.
 */
public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
