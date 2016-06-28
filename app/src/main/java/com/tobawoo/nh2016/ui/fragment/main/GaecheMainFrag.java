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
import com.tobawoo.nh2016.data.GaecheData;

/**
 * Created by tommy on 2016-04-15.
 */
public class GaecheMainFrag extends MainCommonFrag{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_gaeche , container , false);

        aq = new AQuery(view);

        aq.id(R.id.btn_search_gaeche).clicked(this , "click");
        aq.id(R.id.btn_search_gaeche_summary).clicked(this , "click");

        aq.id(R.id.view_frag_common_title).text("개체찾기");

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

        setupData();

        GaecheData gaecheData = new GaecheData();
        gaecheData.setHouse_code(aq.id(R.id.et_nonga_id).getText().toString());
        paramMap.put("search_house_code" , gaecheData.getHouse_code());
        paramMap.put("search_cow_sex_start" , gaecheData.getCow_sex_start());
        paramMap.put("search_cow_sex_end" , gaecheData.getCow_sex_end());
        gaecheData.setCommonData(commonData);
        gaecheData.setParamMap(paramMap);

        clickedListener.onClicked(gaecheData , getClass().getName(), view);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
