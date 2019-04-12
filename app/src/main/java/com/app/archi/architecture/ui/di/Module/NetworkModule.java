package com.app.archi.architecture.ui.di.Module;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.app.archi.architecture.ui.Utils.Schedular;
import com.app.archi.architecture.ui.Utils.SchedularProvider;
import com.app.archi.architecture.ui.data.Remote.ApiConstants;
import com.app.archi.architecture.ui.data.Remote.TracksService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;


@Module
public class NetworkModule {

    @Singleton
    @Provides
    Cache getCache(Context context)
    {
        return new Cache(context.getCacheDir(),10*1024*1024);
    }

    @Singleton
    @Provides
    Gson getGson()
    {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    WifiManager getWifiManager(Context context)
    {
        return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }
    @Singleton
    @Provides
    HttpLoggingInterceptor getLoggingInterceptor()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Singleton
    @Provides
    Interceptor getNetworkInterceptor(WifiManager wifiManager)
    {
        return chain -> {
            Request request=chain.request();
           // Timber.i("Network url-> %s ,method-> %s , header-> %s body-> %s  ",request.url() ,request.method(),request.headers(),request.body());
            request=request.newBuilder().header("api_key",ApiConstants.API_KEY).build();
           if(!wifiManager.isWifiEnabled())
            {
                CacheControl cacheControl=new CacheControl.Builder().maxStale(2, TimeUnit.HOURS).build();
                request=request.newBuilder().cacheControl(cacheControl).build();
            }
            Response response= chain.proceed(request);
            CacheControl cacheControl=new CacheControl.Builder().maxAge(2, TimeUnit.MINUTES).build();
            response=response.newBuilder().header("CACHE_CONTROL",cacheControl.toString()).build();
            //Timber.i("Response header-> %s",request.headers());

            /*if(request.url().toString().contains(ApiConstants.BASE_URL));
            {
                ResponseBody responseBody = response.body();
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // request the entire body.
                Buffer buffer = source.buffer();
                // clone buffer before reading from it
                String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));
                Timber.i("Response ->%s", responseBodyString);
            }*/
            return response;
        };

    }

    @Singleton
    @Provides
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor,Interceptor httpInterceptor, Cache cache)
    {
        return new OkHttpClient.Builder()
                .addInterceptor(httpInterceptor)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();

    }

    @Singleton
    @Provides
    Retrofit getRetrofit(OkHttpClient okHttpClient,Gson gson)
    {
       return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
               .build();
    }

    @Singleton
    @Provides
    OkHttp3Downloader getOkHttpDownloader(OkHttpClient okHttpClient)
    {
        return new OkHttp3Downloader(okHttpClient);

    }

    @Singleton
    @Provides
    Picasso getImageLibrary(Context context,OkHttp3Downloader okHttp3Downloader)
    {
        return new Picasso.Builder(context).downloader(okHttp3Downloader).build();
    }

    @Singleton
    @Provides
    TracksService getTrackService(Retrofit retrofit)
    {
        return retrofit.create(TracksService.class);
    }

    @Singleton
    @Provides
    SchedularProvider getSchedular()
    {
        return new Schedular();
    }
}
