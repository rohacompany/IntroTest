package com.tobawoo.nh2016.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.OnEventClickListener;
import com.tobawoo.nh2016.data.NonggaSearchResultData;
import com.tobawoo.nh2016.ui.fragment.old.NongaBangyokMainFrag;
import com.tobawoo.nh2016.common.Logger;

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
