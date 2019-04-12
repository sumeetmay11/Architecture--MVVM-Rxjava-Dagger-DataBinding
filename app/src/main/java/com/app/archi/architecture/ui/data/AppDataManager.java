package com.app.archi.architecture.ui.data;

import com.app.archi.architecture.ui.data.Local.DBInterface;
import com.app.archi.architecture.ui.data.Local.SharedPreferenceInterface;
import com.app.archi.architecture.ui.data.Model.Tracks;
import com.app.archi.architecture.ui.data.Remote.ApiInterface;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataManager implements DataManager {
    ApiInterface apiInterface;
    SharedPreferenceInterface sharedPreferenceInterface;
    DBInterface dbInterface;

    @Inject
    public AppDataManager(ApiInterface apiInterface, SharedPreferenceInterface sharedPreferenceInterface) {
        this.apiInterface = apiInterface;
        this.sharedPreferenceInterface = sharedPreferenceInterface;

    }

    @Override
    public Single<Tracks> getLatestTracks() {
        return apiInterface.getLatestTracks();
        }


    @Override
    public Single<Tracks> searchAnything(String s) {
        return null;
    }

}
