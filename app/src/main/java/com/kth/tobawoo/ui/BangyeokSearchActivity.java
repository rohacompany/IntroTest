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
import com.kth.tobawoo.ui.adapter.BangyeokAdapter;
import com.kth.tobawoo.utils.Logger;

public class BangyeokSearchActivity extends SubBaseActivity implements BangyeokAdapter.OnTableItemClick{

    NonggaType nt = new NonggaType();

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("방역관리 결과조회");

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
                "농가아이디",
                "농가코드",
                "축주명",
                "방역명",
                "방역자",
                "방역일시",
                "방역차수"
        };
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                100
        };



        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final BangyeokAdapter<String> matrixTableAdapter = new BangyeokAdapter<String>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {

                        for (int i = 0; i < 100; i++) {
                            nt.list.add(new NonggaData("id" + i, "축협" + i, "code" + i, "테스트", "번식농가", "유지", "3" + i, "", "test2" + i, "test3" + i, "2015-12-08", "1" + i, "3" + i, "3" + i));
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
//        data.setNo(100);
//        data.setNongga_id("12312");
//        data.setChukju_name("축주이름");

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
