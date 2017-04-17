package com.moviedb.data.api;

import android.support.annotation.Nullable;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by ANKIT on 08-04-2017.
 * An okHttp interceptor that adds security headers to the api call
 * as well as provided the time
 */
public class SecurityInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request originalRequest = chain.request();

        final String apiKey = "b7cd3340a794e5a2f35e3abb820b497f";

        Request modifiedRequest = getModifiedRequest(originalRequest, apiKey);
        return chain.proceed(modifiedRequest);
    }

    /**
     * Adds security headers to the original request
     */
    private Request getModifiedRequest(Request originalRequest,
                                       @Nullable String apiKey) {

        return originalRequest.newBuilder()
                .addHeader("api_key", apiKey)
                .build();
    }
}
