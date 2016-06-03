package com.kth.tobawoo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kth.tobawoo.R;

public class NongaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_detail);

        setTitle("농가관리 상세보기");
    }
}
