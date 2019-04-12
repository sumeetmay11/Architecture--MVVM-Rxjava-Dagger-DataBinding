package com.app.archi.architecture.ui.di.Component;

import com.app.archi.architecture.ui.Architecture;
import com.app.archi.architecture.ui.di.Module.ContextModule;
import com.app.archi.architecture.ui.di.Module.DataModules;
import com.app.archi.architecture.ui.di.Module.NetworkModule;
import com.app.archi.architecture.ui.ui.TracksActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={DataModules.class, NetworkModule.class, ContextModule.class})
public interface AppComponent {
     void injectThis(Architecture architecture);
     void injectThis(TracksActivity tracksActivity);
}
