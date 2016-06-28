package com.tobawoo.nh2016.ui.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.data.NoticeData;
import com.tobawoo.nh2016.ui.NoticeItemListActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016-04-15.
 */
public class HomeFrag extends Fragment{
    AQuery aq;
    List<NoticeData> noticeDataList = new ArrayList<NoticeData>();
    NoticeAdapter mNoticeAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main , container , false);

        aq=  new AQuery(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setNoticeData();
    }

    private void setNoticeData(){
        View include1 = getView().findViewById(R.id.view_main_card_view_layout_1);
        TextView titleView = (TextView) include1.findViewById(R.id.title);
        BootstrapButton btnMore = (BootstrapButton) include1.findViewById(R.id.btn_more);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity() , NoticeItemListActivity.class);
                startActivity(intent);
            }
        });
        titleView.setText("공지사항");
        ListView lv = (ListView)include1.findViewById(R.id.list);
        lv.setAdapter(mNoticeAdapter = new NoticeAdapter());
//        setNoticeData();


        aq.ajax(URLManager._GET_NOTICE_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                Logger.log("공지사항 -> " + object);
                if(object!=null){
                    try {
                        noticeDataList.clear();
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();
                        for(int i=0;i<results.length();i++){
                            JSONObject item = results.getJSONObject(i);
                            NoticeData nd = gson.fromJson(item.toString() , NoticeData.class);
                            noticeDataList.add(nd);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        mNoticeAdapter.notifyDataSetChanged();
                    }

                }
            }
        });
    }

    class NoticeAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return noticeDataList.size();
        }

        @Override
        public NoticeData getItem(int position) {
            return noticeDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1 , parent , false);
            }
            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(getItem(position).getTitle());
            tv.setSingleLine();
            tv.setEllipsize(TextUtils.TruncateAt.END);
            return convertView;
        }
    }
}
