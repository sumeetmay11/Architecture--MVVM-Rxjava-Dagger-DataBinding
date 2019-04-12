package com.app.archi.architecture.ui.data.Local;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferenceManager implements  SharedPreferenceInterface {
    public static final String PREFERENCE_KEY="";
    public static final String PREFERENCE_API_KEY="";

    SharedPreferences sharedPreferences;

    @Inject
    PreferenceManager(SharedPreferences sharedPreferences)
    {
        this.sharedPreferences=sharedPreferences;
    }

    @Override
    public void saveApiKey(String apiKey) {
        sharedPreferences.edit().putString(PREFERENCE_API_KEY,"").apply();
    }

    @Override
    public String getApiKey() {
       return  sharedPreferences.getString(PREFERENCE_API_KEY,"");
    }
}
