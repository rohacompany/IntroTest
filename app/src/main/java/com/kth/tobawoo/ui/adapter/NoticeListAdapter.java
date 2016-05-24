package com.kth.tobawoo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NoticeData;
import com.kth.tobawoo.fixedtablelayout.adapters.BaseTableAdapter;

import java.util.List;

/**
 * Created by tommy on 2016-02-16.
 */
public class NoticeListAdapter extends BaseAdapter{
    Context mCtx;
    List<NoticeData> mList;
    public NoticeListAdapter(Context context , List<NoticeData> list){
        this.mCtx = context;
        this.mList = list;
    }

    @Override
    public NoticeData getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(mCtx).inflate(android.R.layout.simple_list_item_2 , null);
        }

        TextView title = (TextView) convertView.findViewById(android.R.id.text1);
        title.setText(getItem(position).getTitle());
        TextView content = (TextView) convertView.findViewById(android.R.id.text2);
        content.setText(getItem(position).getContent());
        return convertView;
    }
}
