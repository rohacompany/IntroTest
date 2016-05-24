package com.kth.tobawoo.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.common.OnEventClickListener;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.ui.fragment.NongaBangyokMainFrag;
import com.kth.tobawoo.ui.fragment.NongaSearchTabFrag;
import com.kth.tobawoo.utils.Logger;

public class NongaBangyokMainActivity extends SubBaseActivity implements OnEventClickListener{

    OnEventClickListener mClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_bangyok_main);

        aq = new AQuery(this);

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

    NongaBangyokMainFrag frag;
    public void init(){

        aq.find(R.id.btn_more).clicked(this , "showMorePage");

        frag = new NongaBangyokMainFrag();

        addFragment(frag);

    }



    @Override
    public void onOptionClicked() {
        Intent intent = new Intent(this , TableMainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            NonggaSearchResultData resultData = myApplication.getNonggaSearchResultData();
            Logger.log(resultData.toString() + ",");

            frag.setNonggaData(resultData);
        }
    }
}
