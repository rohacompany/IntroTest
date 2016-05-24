package com.kth.tobawoo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kth.tobawoo.ui.fragment.EmptyFrag;
import com.kth.tobawoo.ui.fragment.main.BunmanjeongboMainFrag;
import com.kth.tobawoo.ui.fragment.main.ChoeumpaMainFrag;
import com.kth.tobawoo.ui.fragment.main.ChulhajeongboFrag;
import com.kth.tobawoo.ui.fragment.main.GaecheMainFrag;
import com.kth.tobawoo.ui.fragment.main.GyobaejeongboMainFrag;
import com.kth.tobawoo.ui.fragment.main.HomeFrag;
import com.kth.tobawoo.ui.fragment.main.NonggaMainFrag;

/**
 * Created by tommy on 2016-04-14.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private String[] TITLES;

    public MainViewPagerAdapter(FragmentManager fm , String[] titles) {
        super(fm);
        this.TITLES = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        switch (position){
            case 0:
                fragment = new HomeFrag();
                break;
            case 1:
                fragment = new NonggaMainFrag();
                break;
            case 2:
                fragment = new GaecheMainFrag();
                break;
            case 3:
                fragment = new GyobaejeongboMainFrag();
                break;
            case 4:
                fragment = new BunmanjeongboMainFrag();
                break;
            case 5:
                fragment = new ChoeumpaMainFrag();
                break;
            case 6:
                fragment = new ChulhajeongboFrag();
                break;
            default:
                fragment = new NonggaMainFrag();
                break;
        }
        return fragment;
    }
}
