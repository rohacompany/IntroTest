package com.tobawoo.nh2016.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.ui.adapter.CommonViewPagerAdapter;
import com.tobawoo.nh2016.ui.fragment.main.BunmanDetailFrag;
import com.tobawoo.nh2016.ui.fragment.main.ChoeumpaDetailFrag;
import com.tobawoo.nh2016.ui.fragment.main.ChulhaDetailFrag;
import com.tobawoo.nh2016.ui.fragment.main.CommonFixedTableFrag;
import com.tobawoo.nh2016.ui.fragment.main.GaecheDetail;
import com.tobawoo.nh2016.ui.fragment.main.GyobaejeongboDetailFrag;
import com.tobawoo.nh2016.ui.summary.fragment.FragmentTab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GaecheDetailTabAllActivity extends SubBaseActivity{

    private String[] page_titles;
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private CommonViewPagerAdapter adapter;
    private Fragment[] fragments;
    Map<String,View> views = new HashMap<String,View>();

    String barcode = null;

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaeche_detail_tab_all);

        barcode = getIntent().getStringExtra("search_barcode");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("개체 결과별 조회");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        upArrow.setColorFilter(getResources().getColor(R.color.Black), PorterDuff.Mode.SRC_ATOP);
//        toolbar.setNavigationIcon(upArrow);

        setUp();


        setFragmentTab();
    }

    public void setFragmentTab(){

        Bundle bundle = new Bundle();
        bundle.putString("search_barcode" , barcode);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(
                setIndicator(mTabHost.newTabSpec("개체정보")),
                GaecheDetail.class, bundle);
        mTabHost.addTab(
                setIndicator(mTabHost.newTabSpec("교배정보")),
                GyobaejeongboDetailFrag.class, bundle);
        mTabHost.addTab(
                setIndicator(mTabHost.newTabSpec("분만정보")),
                BunmanDetailFrag.class, bundle);

        mTabHost.addTab(
                setIndicator(mTabHost.newTabSpec("초음파정보")),
                ChoeumpaDetailFrag.class, bundle);

        mTabHost.addTab(
                setIndicator(mTabHost.newTabSpec("출하정보")),
                ChulhaDetailFrag.class, bundle);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Logger.log("onTabChanged -> " + tabId);
                for(String key : views.keySet()){
                    views.get(key).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                views.get(tabId).setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        });

        mTabHost.setCurrentTab(0);
    }

    private TabHost.TabSpec setIndicator(TabHost.TabSpec spec) {
        // TODO Auto-generated method stub
        View v = LayoutInflater.from(this).inflate(R.layout.view_fragment_tab_host, null);
        TextView text = (TextView) v.findViewById(R.id.tv);
        text.setText(spec.getTag());
        View line = v.findViewById(R.id.line);
        if(spec.getTag().equalsIgnoreCase("개체정보")){
            line.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        views.put(spec.getTag() , line);
        return spec.setIndicator(v);
    }

}
