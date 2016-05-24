package com.kth.tobawoo.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.NonggaMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.ui.fragment.GaecheJilbyeongTabFrag;
import com.kth.tobawoo.ui.fragment.GaecheJungboTabFrag;
import com.kth.tobawoo.ui.fragment.NongaBangyokSearchTabFrag;
import com.kth.tobawoo.ui.fragment.NongaSearchTabFrag;
import com.kth.tobawoo.ui.fragment.GaecheSujeongBunmanTabFrag;
import com.kth.tobawoo.utils.Logger;

public class TableMainActivity extends SubBaseActivity implements OnTableItemClickListener{

    public static final int _PAGE_NONGGA_SELECT = 100;
    public static final int _PAGE_GACHE_JONGBO_SELECT = 100;
    private FragmentTabHost mTabHost;

    private String[] titles = {"농가정보" , "방역정보" , "개체정보" , "질병정보" , "수정/분만정보"};

    private int _PAGE_SELECT = 100;

    NonggaType nt = new NonggaType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        init();
    }

    public void init(){

        _PAGE_SELECT = getIntent().getIntExtra("page" , _PAGE_NONGGA_SELECT);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        int length = 0;
        if(_PAGE_SELECT == _PAGE_NONGGA_SELECT) {
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[0]).setIndicator(titles[0], null),
                    NongaSearchTabFrag.class, null);
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[1]).setIndicator(titles[1], null),
                    NongaBangyokSearchTabFrag.class, null);

            length = 2;
        }else if(_PAGE_SELECT == _PAGE_GACHE_JONGBO_SELECT) {
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[0]).setIndicator(titles[0], null),
                    NongaSearchTabFrag.class, null);
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[2]).setIndicator(titles[2], null),
                    GaecheJungboTabFrag.class, null);
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[3]).setIndicator(titles[3], null),
                    GaecheJilbyeongTabFrag.class, null);
            mTabHost.addTab(
                    mTabHost.newTabSpec(titles[4]).setIndicator(titles[4], null),
                    GaecheSujeongBunmanTabFrag.class, null);

            length = 4;
        }
        for(int i=0;i<length;i++){
            setTextView(mTabHost , i);
        }

        setTableLayout();

    }

    private void setTextView(TabHost mTabHost , int pos){
        TabWidget tw = (TabWidget)mTabHost.findViewById(android.R.id.tabs);
        View tabView = tw.getChildTabViewAt(pos);
        TextView tv = (TextView)tabView.findViewById(android.R.id.title);
        tv.setTextSize(20);
    }

    public void setTableLayout() {
        String[] mainHeaders = new String[]{
                "농가명",
                "농가(목장)번호",
                "축협명",
                "지역",
                "생년월일",
                "사육두수 전체",
                "사육두수 암",
                "사육두수 수",
                "사육두수 거세",
                "휴대폰",
                "전화번호",
                "우편번호",
                "농가기본주소",
                "농가상세주소"

        };
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100
        };



        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final NonggaMainAdapter<String> matrixTableAdapter = new NonggaMainAdapter<String>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {

                        for (int i = 0; i < 100; i++) {
                            nt.list.add(new NonggaData("id" + i, "축협" + i, "code" + i, "테스트", "번식농가", "유지", "3" + i, "", "test2" + i, "test3" + i, "2015-12-08", "1" + i , "3" + i , "3" + i));
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);

                        matrixTableAdapter.notifyDataSetChanged();

                        tableFixHeaders.scrollTo(0,0);
                    }
                }.execute();
            }
        }, 500);


    }

    @Override
    public void onListItemClicked(View view, int position) {
        NonggaData data = nt.list.get(position);
        Logger.log(data.toString());
    }
}
