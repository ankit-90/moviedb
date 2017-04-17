package com.moviedb.ui.movieList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.moviedb.R;
import com.moviedb.ui.base.BaseActivity;

/**
 * Created by ANKIT on 08-04-2017.
 */

public class MovieListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

}
