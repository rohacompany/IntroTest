package com.kth.tobawoo.ui.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.kth.tobawoo.R;

/**
 * Created by tommy on 2016-01-15.
 */
public class SettingsFrag extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_setting);
    }
}

