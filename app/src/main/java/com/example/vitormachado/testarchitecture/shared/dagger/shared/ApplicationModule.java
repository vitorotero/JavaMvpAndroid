package com.example.vitormachado.testarchitecture.shared.dagger.shared;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * @author vitor.machado on 12/06/18.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

}
