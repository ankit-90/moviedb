package com.moviedb.data.api;

import android.support.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ANKIT on 08-04-2017.
 */


public class ApiClient {


    private static final String mBaseUrl = "https://api.themoviedb.org/3/movie/";
    private static MovieDbService movieDbService;

    private ApiClient() {
        //no instances
    }

    public static MovieDbService getInstance() {
        if ( movieDbService == null) {
            final OkHttpClient okHttpClient = makeOkHttpClient();

            final Retrofit client = makeRetrofit(okHttpClient);
            movieDbService = client.create(MovieDbService.class);
        }
        return  movieDbService;
    }

    @NonNull
    private static Retrofit makeRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @NonNull
    private static OkHttpClient makeOkHttpClient() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //add the interceptor for logging the curl commands
        return new OkHttpClient.Builder()
                .addInterceptor(new SecurityInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new CurlLoggingInterceptor())
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(null)
                .build();
    }
}
