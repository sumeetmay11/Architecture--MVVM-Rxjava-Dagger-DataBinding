package com.app.archi.architecture.ui.data.Remote;

import com.app.archi.architecture.ui.data.Model.Response;
import com.app.archi.architecture.ui.data.Model.Tracks;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class AppApiManager implements ApiInterface {
    ApiHeader apiHeader;
    @Inject
    TracksService tracksService;

    @Inject
    public AppApiManager(ApiHeader apiHeader)
    {
        this.apiHeader=apiHeader;
    }



    @Override
    public Single<Tracks> getLatestTracks() {
        return tracksService.getTracks(apiHeader.publicApiHeader.getApiKey()).map(new Function<Response<Tracks>, Tracks>() {
            @Override
            public Tracks apply(Response<Tracks> tracksResponse) throws Exception {
                return tracksResponse.getResponse();
            }
        });
    }

    @Override
    public Single<Tracks> getTracksByTag() {
        return null;
    }

    @Override
    public Single<Tracks> getTracksByArtist() {
        return null;
    }

    @Override
    public ApiHeader getAppApiHeader() {
       return apiHeader;
    }


}
