package com.tobawoo.nh2016.ui.summary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NongaSummaryData;
import com.tobawoo.nh2016.ui.summary.fragment.CommonSummaryFrag;
import com.tobawoo.nh2016.ui.summary.fragment.GyobaeSummaryFrag1;
import com.tobawoo.nh2016.ui.summary.fragment.GyobaeSummaryFrag2;
import com.tobawoo.nh2016.ui.summary.fragment.GyobaeSummaryFrag3;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;

public class GyobaeJeongboSummaryActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost mTabHost;

    private AQuery aq;

    ArrayList<NongaSummaryData> list = new ArrayList<NongaSummaryData>();

    CommonSummaryFrag commonSummaryFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("교배 정보 요약");

        setContentView(R.layout.activity_common_summary);

        setFinishOnTouchOutside(false);

        aq = new AQuery(this);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(GyobaeJeongboSummaryActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

        Bundle bundle = getIntent().getExtras();

//        bundle.getParcelableArrayList()
        addTab( bundle );

    }

    public void setFragment(CommonSummaryFrag summaryFrag){
        this.commonSummaryFrag = summaryFrag;
        commonSummaryFrag.setNongaSummaryList(list);
    }


    public void addTab(Bundle bundle){

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("산차별", null),
                GyobaeSummaryFrag1.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("혈통별", null),
                GyobaeSummaryFrag2.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("월령별", null),
                GyobaeSummaryFrag3.class, bundle);
    }


    @Override
    public void onTabChanged(String tabId) {
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
//    }
}
