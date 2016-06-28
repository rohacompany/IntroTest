package com.tobawoo.nh2016.common;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.tobawoo.nh2016.data.NonggaSearchResultData;
import com.tsengvn.typekit.Typekit;

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

        /*
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/NanumGothic.otf"))
                .addBold(Typekit.createFromAsset(this, "fonts/NanumGothicBold.otf"));

        */
    }
}
