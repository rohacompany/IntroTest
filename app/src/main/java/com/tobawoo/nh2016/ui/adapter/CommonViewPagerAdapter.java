package com.tobawoo.nh2016.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tommy on 2016-06-23.
 */
public class CommonViewPagerAdapter extends FragmentPagerAdapter{
    private String[] TITLES;
    private Fragment[] fragments;

    public CommonViewPagerAdapter(FragmentManager fm , String[]  TITLES , Fragment[] fragments) {
        super(fm);
        this.TITLES = TITLES;
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}
