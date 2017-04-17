package com.moviedb.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.moviedb.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ANKIT on 08-04-2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.retry_view)
    View retryView;
    @BindView(R.id.progress_bar)
    ContentLoadingProgressBar progressBar;
    FrameLayout container;
    @Nullable
    protected View btn_Retry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        container = (FrameLayout) findViewById(R.id.container);
        View view = LayoutInflater.from(this).inflate(getLayout(),null,false);
        container.addView(view,0);
        ButterKnife.bind(this);
    }

    /**
     * @return id of the layout to be used
     */
    public abstract
    @LayoutRes
    int getLayout();

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        lazilyLoadRetryView();
        retryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        if (retryView != null)
            retryView.setVisibility(View.GONE);
    }

    @Override
    public void onRetryClicked() {
        // do something cool in child activity
    }

    /**
     * This lazily loads the retry view. You can use the view after loading it.
     */
    protected void lazilyLoadRetryView() {
        if (retryView == null || btn_Retry == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.retry_view);
            retryView = viewStub.inflate();
            btn_Retry = retryView.findViewById(R.id.btn_retry);
            btn_Retry.setOnClickListener(v -> onRetryClicked());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressBar != null) {
            progressBar.hide();
            progressBar = null;
        }
    }
}
