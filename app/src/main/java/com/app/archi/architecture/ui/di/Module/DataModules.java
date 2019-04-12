package com.app.archi.architecture.ui.di.Module;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.archi.architecture.ui.data.AppDataManager;
import com.app.archi.architecture.ui.data.DataManager;
import com.app.archi.architecture.ui.data.Local.PreferenceManager;
import com.app.archi.architecture.ui.data.Local.SharedPreferenceInterface;
import com.app.archi.architecture.ui.data.Remote.ApiConstants;
import com.app.archi.architecture.ui.data.Remote.ApiInterface;
import com.app.archi.architecture.ui.data.Remote.AppApiManager;
import com.app.archi.architecture.ui.di.ApiKey;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModules {

    @Singleton
    @Provides
    SharedPreferences getSharedPreference(Context context)
    {
        return context.getSharedPreferences(PreferenceManager.PREFERENCE_KEY, Context.MODE_PRIVATE);

    }

    @ApiKey
    @Provides
    String getApiKey (SharedPreferenceInterface sharedPreferences)
    {
        return !ApiConstants.API_KEY.isEmpty()?ApiConstants.API_KEY:sharedPreferences.getApiKey();

    }

    @Singleton
    @Provides
    ApiInterface getApiManager(AppApiManager appApiManager)
    {
        return appApiManager;
    }

    @Singleton
    @Provides
    SharedPreferenceInterface getPreferenceManager(PreferenceManager preferenceManager)
    {
        return preferenceManager;
    }
/*
    @Singleton
    @Provides
    DBInterface getDbInterface(@ApplicationContext Context context)
    {
        return new DatabaseManager(Room.databaseBuilder(context, DbReprository.class,"LiteFmDb").build());
    }*/

    @Singleton
    @Provides
    DataManager getDataManager(AppDataManager dataManager)
    {
        return dataManager;
    }


}
