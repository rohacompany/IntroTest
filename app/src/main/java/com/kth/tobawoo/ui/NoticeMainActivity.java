package com.kth.tobawoo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;

import com.kth.tobawoo.data.NoticeData;
import com.kth.tobawoo.ui.adapter.NoticeListAdapter;
import com.kth.tobawoo.ui.dummy.DummyContent;
import com.kth.tobawoo.ui.fragment.ListDetailActivityDetailFragment;

import java.util.ArrayList;
import java.util.List;

public class NoticeMainActivity extends SubBaseActivity {

    private boolean mTwoPane;
    List<NoticeData> mList;

    AQuery aq;

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
    }

    private void init(){

        mList = new ArrayList<NoticeData>();

        for(int i=0;i<100;i++){ //샘플 데이터 입력
            NoticeData data = new NoticeData();
            data.setNo(i);
            data.setTitle("공지사항 : " + i);
            data.setContent("2015-02-16");
            mList.add(data);
        }

        NoticeListAdapter adapter = new NoticeListAdapter(this , mList);

        aq.find(android.R.id.list).adapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
