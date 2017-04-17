package com.moviedb.data.api;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ANKIT on 08-04-2017.
 */

public interface MovieDbService {

    @GET
    Observable<String> getMovieList();

}
