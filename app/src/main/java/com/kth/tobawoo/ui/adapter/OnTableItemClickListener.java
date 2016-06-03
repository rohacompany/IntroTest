package com.kth.tobawoo.ui.adapter;

import android.view.View;

import com.kth.tobawoo.data.CommonInter;

/**
 * Created by tommy on 2016-02-23.
 */
public interface OnTableItemClickListener {
    public void onListItemClicked(View view,CommonInter commonInter, int row, int column);
}
