package com.tobawoo.nh2016.ui.fragment.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.GyobaejeongboData;
import com.tobawoo.nh2016.common.Logger;

/**
 * Created by tommy on 2016-04-15.
 */
public class GyobaejeongboMainFrag extends MainCommonFrag{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_gyobae , container , false);

        aq = new AQuery(view);

        aq.id(R.id.btn_search_gyobae).clicked(this , "click");
        aq.id(R.id.btn_search_gyobae_summary).clicked(this , "click");

        aq.id(R.id.view_frag_common_title).text("교배정보");

        setup();

        return view;
    }

    OnFragmentClickedListener clickedListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        clickedListener = (OnFragmentClickedListener) activity;
    }

    public void click(View view){
        Logger.log("onClick : " + view.getId());
        setupData();
        GyobaejeongboData data = new GyobaejeongboData();

        paramMap.put("search_crossbreed_dt1", aq.id(R.id.tv_type3_date_popup_start).getText().toString());
        paramMap.put("search_crossbreed_dt2", aq.id(R.id.tv_type3_date_popup_end).getText().toString());
        paramMap.put("search_hus_kpn_no" , aq.id(R.id.et_sisuso_husband).getText().toString());
        paramMap.put("search_breed_schedule_dt1" , aq.id(R.id.tv_type4_date_popup_start).getText().toString());
        paramMap.put("search_breed_schedule_dt2" , aq.id(R.id.tv_type4_date_popup_end).getText().toString());

        data.setParamMap(paramMap);

        clickedListener.onClicked( data , getClass().getName(), view);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
