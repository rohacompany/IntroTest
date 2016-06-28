package com.tobawoo.nh2016.ui.fragment.old;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.ui.NoticeMainActivity;
import com.tobawoo.nh2016.ui.custom.CustomCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by tommy on 2016-01-14.
 */
public class MainFrag extends BaseFrag{
    CalendarView calendar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main , container , false);

        aq = new AQuery(view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    public void init(){

        setLayoutMainTitle(R.id.view_main_card_view_layout_1, "공지사항");
        setLayoutMainTitle(R.id.view_main_card_view_layout_2, "일정안내");
//        setLayoutMainTitle(R.id.view_main_card_view_layout_3 , "컨설팅정보");
//        setLayoutMainTitle(R.id.view_main_card_view_layout_4 , "기타");

        ArrayList<String> dataset = new ArrayList<String>();
        for(int i=1;i<5 ; i++){
            dataset.add(i + "번째 샘플 내용입니다.");
        }

        setListView(dataset);

        initializeCalendar();

        setButtonMore();
    }

    public void setButtonMore(){
        aq.id(R.id.view_main_card_view_layout_1).id(R.id.btn_more).clicked(this, "openEventMore");
    }

    public void openEventMore(){
        Intent intent = new Intent(getActivity() , NoticeMainActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void setLayoutMainTitle(int resId , String title){
        View view = getView().findViewById(resId);

        TextView tv = (TextView)view.findViewById(R.id.title);
        tv.setText(title);
    }

    public void setListView(ArrayList<String> dataset){

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataset);

        setAdapter(R.id.view_main_card_view_layout_1 , itemsAdapter);
        setAdapter(R.id.view_main_card_view_layout_2 , itemsAdapter);
//        setAdapter(R.id.view_main_card_view_layout_3 , itemsAdapter);
//        setAdapter(R.id.view_main_card_view_layout_4 , itemsAdapter);
//        setAdapter(R.id.view_main_card_view_layout_5 , itemsAdapter);
//        setAdapter(R.id.view_main_card_view_layout_6, itemsAdapter);

    }

    public void setAdapter(int resId , ArrayAdapter<String> adapter){
        View view = getView().findViewById(resId);

        ListView lv = (ListView) view.findViewById(R.id.list);
        lv.setAdapter(adapter);
    }

    public void initializeCalendar() {

        CustomCalendar calendar = (CustomCalendar)aq.find(R.id.calendar_view).getView();
        HashSet<Date> eventsDates = new HashSet<Date>();
        Date date1 = new Date();
        eventsDates.add(date1);
        calendar.updateCalendar(eventsDates);
    }
}
