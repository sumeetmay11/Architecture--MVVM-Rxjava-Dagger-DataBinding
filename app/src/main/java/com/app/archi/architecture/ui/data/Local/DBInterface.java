package com.app.archi.architecture.ui.data.Local;

import com.app.archi.architecture.ui.data.Model.Track;

import java.util.List;

import io.reactivex.Single;

public interface DBInterface  {
    Single<List<Track>> getAllTracks();
}
