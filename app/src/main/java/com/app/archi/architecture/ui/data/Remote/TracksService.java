package com.app.archi.architecture.ui.data.Remote;

import com.app.archi.architecture.ui.data.Model.Response;
import com.app.archi.architecture.ui.data.Model.Tracks;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TracksService {
    @GET("?method=chart.gettoptracks&format=json")
     Single<Response<Tracks>> getTracks(@Query("api_key") String apiKey);
}
