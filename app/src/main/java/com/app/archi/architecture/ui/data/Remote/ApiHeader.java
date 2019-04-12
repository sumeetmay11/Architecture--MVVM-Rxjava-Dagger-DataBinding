package com.app.archi.architecture.ui.data.Remote;

import com.app.archi.architecture.ui.di.ApiKey;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {
    PublicApiHeader publicApiHeader;
    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader)
    {
        this.publicApiHeader=publicApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return publicApiHeader;
    }

    @Singleton
    public static class PublicApiHeader {

      String mApiKey;
        @Inject
        public PublicApiHeader(@ApiKey String mApiKey) {
            this.mApiKey = mApiKey;
        }

        public String getApiKey() {
            return mApiKey;
        }

        public void setApiKey(String mApiKey) {
            this.mApiKey = mApiKey;
        }
    }


}
