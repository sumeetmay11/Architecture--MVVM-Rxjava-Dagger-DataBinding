package com.app.archi.architecture.ui;

import android.app.Application;

import com.app.archi.architecture.ui.di.Component.AppComponent;
import com.app.archi.architecture.ui.di.Component.DaggerAppComponent;
import com.app.archi.architecture.ui.di.Module.ContextModule;

import timber.log.Timber;

public class Architecture extends Application {
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        init();

    }
    void init()
    {
        Timber.plant(new Timber.DebugTree());
        appComponent= DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
        appComponent.injectThis(this);
    }
    public Architecture  get()
    {
        return this;
    }
     public AppComponent getAppComponent()
    {
       return appComponent;
    }



}
