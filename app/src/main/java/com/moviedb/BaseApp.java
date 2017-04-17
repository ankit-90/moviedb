package com.moviedb;

import android.app.Application;

/**
 * Created by ANKIT on 08-04-2017.
 */

public class BaseApp extends Application {

    private static BaseApp baseApp;


    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApp getContext(){
         return baseApp;
    }


}
