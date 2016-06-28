package com.tobawoo.nh2016.ui.summary;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NongaSummaryData;
import com.tobawoo.nh2016.ui.summary.fragment.CommonSummaryFrag;
import com.tobawoo.nh2016.ui.summary.fragment.NongaSummaryFrag1;
import com.tobawoo.nh2016.ui.summary.fragment.NongaSummaryFrag2;
import com.tobawoo.nh2016.ui.summary.fragment.NongaSummaryFrag3;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;

public class NongaSummaryActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost mTabHost;

    private AQuery aq;

    ArrayList<NongaSummaryData> list = new ArrayList<NongaSummaryData>();

    CommonSummaryFrag commonSummaryFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("농가 정보 요약");

        setContentView(R.layout.activity_common_summary);

        setFinishOnTouchOutside(false);

        aq = new AQuery(this);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(NongaSummaryActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

        ArrayList<NongaSummaryData> datas = getIntent().getExtras().getParcelableArrayList("datas");

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
                mTabHost.newTabSpec("tab1").setIndicator("농가정보", null),
                NongaSummaryFrag1.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("사육두수", null),
                NongaSummaryFrag2.class, bundle);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("출하두수", null),
                NongaSummaryFrag3.class, bundle);
    }


    @Override
    public void onTabChanged(String tabId) {
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
//    }
}
