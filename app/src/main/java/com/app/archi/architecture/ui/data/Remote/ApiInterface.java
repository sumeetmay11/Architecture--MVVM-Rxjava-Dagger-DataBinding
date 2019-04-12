package com.app.archi.architecture.ui.data.Remote;


import com.app.archi.architecture.ui.data.Model.Tracks;

import io.reactivex.Single;

public interface ApiInterface  {
    Single<Tracks> getLatestTracks();
    Single<Tracks> getTracksByTag();
    Single<Tracks> getTracksByArtist();


    ApiHeader getAppApiHeader();
}
