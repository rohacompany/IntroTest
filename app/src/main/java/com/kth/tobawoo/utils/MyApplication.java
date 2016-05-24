package com.kth.tobawoo.utils;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.kth.tobawoo.data.NonggaSearchResultData;

/**
 * Created by tommy on 2016-01-12.
 */
public class MyApplication extends Application{
    NonggaSearchResultData nonggaSearchResultData;

    public NonggaSearchResultData getNonggaSearchResultData() {
        return nonggaSearchResultData;
    }

    public void setNonggaSearchResultData(NonggaSearchResultData nonggaSearchResultData) {
        this.nonggaSearchResultData = nonggaSearchResultData;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }
}
