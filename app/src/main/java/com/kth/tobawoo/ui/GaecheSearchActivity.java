package com.kth.tobawoo.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.GachejeongboMainAdapter;
import com.kth.tobawoo.ui.adapter.NonggaMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.utils.Logger;

public class GaecheSearchActivity extends SubBaseActivity implements OnTableItemClickListener {

    NonggaType nt = new NonggaType();

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_search);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("개체 결과 관리 조회");

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
        finish();
    }

    public void setTableLayout() {
        String[] mainHeaders = new String[]{
                "귀표번호",
                "농가(목장)명",
                "축협명",
                "시군구",
                "읍면동",
                "등록구분",
                "산차",
                "교배일자",
                "씨수소",
                "교배일자",
                "씨수소",
                "교배일자",
                "씨수소",
                "분만예정일자",
                "분만일자",
                "인공수정사",
                "개체관리번호",
                "목장주소",
                "목장전화번호",
                "핸드폰번호"
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
                100,
                100,
                150,
                100,
                150,
                150,
                100
        };



        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final GachejeongboMainAdapter<String> matrixTableAdapter = new GachejeongboMainAdapter<String>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {

                        for (int i = 0; i < 100; i++) {
                            nt.list.add(new NonggaData("KOR-002-094705076","(274685-1)신장섭(신장섭)","양평","양평군","양평읍","혈통","1","2016-01-04","KPN950","2016-01-04","KPN950","2016-01-04","KPN950","2016-10-15","미분만","이재광","3190114031221","덕평리 278","031-774-0626","011-9180-1627"));
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

        NonggaData nonggaData = nt.list.get(position);

        NonggaSearchResultData data = new NonggaSearchResultData();
        data.setNo(100);
        data.setNongga_id("12312");
        data.setChukju_name("축주이름");

//        Intent intent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("data", data);
//        intent.putExtras(bundle);
//        intent.putExtra("name" , "test");

        myApplication.setNonggaSearchResultData(data);

        setResult(RESULT_OK);
        finish();


    }
}
