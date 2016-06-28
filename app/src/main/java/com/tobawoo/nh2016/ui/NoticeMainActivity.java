package com.tobawoo.nh2016.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;

import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.data.NoticeData;
import com.tobawoo.nh2016.ui.adapter.NoticeListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NoticeMainActivity extends SubBaseActivity {

    private boolean mTwoPane;
    List<NoticeData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdetailactivity_list);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("공지사항");

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

        setData();
    }

    private void init(){

        mList = new ArrayList<NoticeData>();

    }

    private void setData(){

        aq.ajax(URLManager._GET_NONGA_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){

                    try {
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();
                        for(int i=0;i<results.length();i++){
                            JSONObject item = results.getJSONObject(i);
                            NoticeData nd = gson.fromJson(item.toString() , NoticeData.class);
                            mList.add(nd);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void setTableLayout(){

    }
}
