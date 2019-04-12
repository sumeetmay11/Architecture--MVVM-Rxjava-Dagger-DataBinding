package com.app.archi.architecture.ui.data;

import com.app.archi.architecture.ui.data.Model.Tracks;

import io.reactivex.Single;

public interface DataManager {
    Single<Tracks> searchAnything(String s);
     Single<Tracks> getLatestTracks();
}
