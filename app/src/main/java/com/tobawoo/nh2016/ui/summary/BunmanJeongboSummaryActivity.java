package com.tobawoo.nh2016.ui.summary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.BunmanSummaryData;
import com.tobawoo.nh2016.ui.summary.fragment.BunmanSummaryFrag1;
import com.tobawoo.nh2016.ui.summary.fragment.BunmanSummaryFrag2;
import com.tobawoo.nh2016.ui.summary.fragment.BunmanSummaryFrag3;
import com.tobawoo.nh2016.ui.summary.fragment.CommonSummaryFrag;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;

public class BunmanJeongboSummaryActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost mTabHost;

    private AQuery aq;

    ArrayList<BunmanSummaryData> list = new ArrayList<BunmanSummaryData>();

    CommonSummaryFrag commonSummaryFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("분만 정보 요약");

        setContentView(R.layout.activity_common_summary);

        setFinishOnTouchOutside(false);

        aq = new AQuery(this);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(BunmanJeongboSummaryActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

        ArrayList<BunmanSummaryData> datas = getIntent().getExtras().getParcelableArrayList("datas");

        Bundle bundle = getIntent().getExtras();

//        bundle.getParcelableArrayList()
        addTab( bundle );

    }

    public void setFragment(CommonSummaryFrag summaryFrag){
        this.commonSummaryFrag = summaryFrag;
        //commonSummaryFrag.setNongaSummaryList(list);
    }

    public void addTab(Bundle bundle){

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("분만두수별", null),
                BunmanSummaryFrag1.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("성별별", null),
                BunmanSummaryFrag2.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("월령구분별", null),
                BunmanSummaryFrag3.class, bundle);
    }


    @Override
    public void onTabChanged(String tabId) {
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
//    }
}
