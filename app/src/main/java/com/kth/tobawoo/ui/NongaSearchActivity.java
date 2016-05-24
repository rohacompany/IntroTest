package com.kth.tobawoo.ui;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.NonggaMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.utils.Logger;

public class NongaSearchActivity extends SubBaseActivity implements OnTableItemClickListener{

    NonggaType nt = new NonggaType();

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_search);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("농가관리결과조회");

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

        setTableLayout();

        aq.find(R.id.btn_close).clicked(this , "closeActivity");
    }

    public void closeActivity(){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void setTableLayout() {
        String[] mainHeaders = new String[]{
                "농가명",
                "농가(목장)번호",
                "축협명",
                "시군구",
                "읍면동",
                "생년월일",
                "전체",
                "암",
                "수",
                "거세",
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
                150,
                150,
                150,
                200,
                150,
                150
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
                            nt.list.add(new NonggaData("권순원","310121-1","양평","양평군" + i, "양평읍" + i, "490131", "30", "20", "3" + i, "10", "010-2930-1080" + i, "031-774-1080" + i, "476-804", "경기도 양평균 양평읍 회현1리" + i, "Apr-80" + i));
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);

                        matrixTableAdapter.notifyDataSetChanged();

                        tableFixHeaders.scrollTo(0, 0);
                    }
                }.execute();
            }
        }, 500);


    }

    @Override
    public void onListItemClicked(View view, int position) {
        Logger.log("onListItemClicked ok!! : " + position);

        if(position>0) {
            NonggaData nonggaData = nt.list.get(position);


//        Intent intent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("data", data);
//        intent.putExtras(bundle);
//        intent.putExtra("name" , "test");

//        myApplication.setNonggaSearchResultData(nonggaData);

        }
        setResult(RESULT_OK);
        finish();


    }
}
