package com.moviedb.ui.base;

/**
 * Created by ANKIT on 08-04-2017.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void onRetryClicked();

}
