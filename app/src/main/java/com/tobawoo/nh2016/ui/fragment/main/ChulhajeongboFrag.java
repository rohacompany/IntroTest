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
import com.tobawoo.nh2016.data.ChulhajeongboData;

/**
 * Created by tommy on 2016-05-24.
 */
public class ChulhajeongboFrag extends MainCommonFrag{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_chulhajeongbo, container , false);

        aq = new AQuery(view);

        aq.id(R.id.btn_search_chulha).clicked(this , "click");
        aq.id(R.id.btn_search_chulha_summary).clicked(this , "click");

        aq.id(R.id.view_frag_common_title).text("출하정보");

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
        ChulhajeongboData chulhajeongboData = new ChulhajeongboData();

        paramMap.put("searchHouseCode" , aq.id(R.id.et_nonga_id).getText().toString());
        chulhajeongboData.setParamMap(paramMap);

        clickedListener.onClicked(chulhajeongboData , getClass().getName() , view);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
