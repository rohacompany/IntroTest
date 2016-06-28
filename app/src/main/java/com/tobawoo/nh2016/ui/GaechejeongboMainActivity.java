package com.tobawoo.nh2016.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.OnEventClickListener;
import com.tobawoo.nh2016.ui.fragment.old.BaseFrag;
import com.tobawoo.nh2016.ui.fragment.old.GaechejeongboGeoseFrag;
import com.tobawoo.nh2016.ui.fragment.old.GaechejeongboMainFrag;

public class GaechejeongboMainActivity extends SubBaseActivity implements OnEventClickListener{

    public final  static int _FRAG_GAECHEJEONGBO_MAIN = 100;
    public final  static int _FRAG_GAECHEJEONGBO_GEOSE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaechejeongbo_main);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    BaseFrag frag = null;

    public void init(){

        aq.find(R.id.btn_more).clicked(this, "showMorePage");
        int flag = getIntent().getIntExtra("flag" , _FRAG_GAECHEJEONGBO_MAIN);

        int backgroundResId = -1;
        switch (flag){
            case _FRAG_GAECHEJEONGBO_MAIN:
                frag = new GaechejeongboMainFrag();
                backgroundResId = R.drawable.img_cow_big4;
                break;
            case _FRAG_GAECHEJEONGBO_GEOSE:
                frag = new GaechejeongboGeoseFrag();
                backgroundResId = R.drawable.img_cow_big5;
                break;
        }

        addFragment(frag);

        setAppBackgroundImage(backgroundResId);
    }

    public void setAppBackgroundImage(int resId){
        aq.find(R.id.backgroundImageView).image(resId);
    }

    @Override
    public void onOptionClicked() {
        Intent intent = new Intent(this , TableMainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            frag.setNonggaData(myApplication.getNonggaSearchResultData());
        }
    }
}
