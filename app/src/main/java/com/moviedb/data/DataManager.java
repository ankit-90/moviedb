package com.moviedb.data;

import com.moviedb.data.api.ApiClient;
import com.moviedb.data.api.MovieDbService;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Created by ANKIT on 08-04-2017.
 * The responsibility of this class is to Choose the appropriate providers
 * like db,preference, webservice etc and get's the data from it
 */

public class DataManager  {

    private final MovieDbService movieDbService;

    public DataManager() {
        this.movieDbService = ApiClient.getInstance();
    }


    public Observable<String> getMovieList(){
        return movieDbService.getMovieList()
                .flatMap(new Function<String, ObservableSource<? extends String>>() {
                    @Override
                    public ObservableSource<? extends String> apply(@NonNull String s) throws Exception {
                        return null;
                    }
                });
    }


}
