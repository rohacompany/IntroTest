package com.kth.tobawoo.ui.fragment.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.ui.GaecheSearchActivity;
import com.kth.tobawoo.ui.NongaSearchActivity;
import com.kth.tobawoo.ui.UIMainActivity;
import com.kth.tobawoo.utils.DBHelper;
import com.kth.tobawoo.utils.Logger;

/**
 * Created by tommy on 2016-04-15.
 */
public class NonggaMainFrag extends MainCommonFrag{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_nonga , container , false);

        aq = new AQuery(view);

        aq.id(R.id.btn_search_nonga).clicked(this , "click");
        aq.id(R.id.btn_search_gaeche).clicked(this , "click");

        aq.id(R.id.view_frag_common_title).text("농가찾기");

        setup();

       return view;
    }


    OnFragmentClickedListener clickedListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        clickedListener = (OnFragmentClickedListener) activity;
    }

    public void searchNonga() {

    }
    public void click(View view){

        setupData();

        String nonga_id = aq.id(R.id.et_nonga_id).getText().toString();
        String member_yn = (String) aq.id(R.id.sp_member_yn).getSelectedItem();
        String breed_dosu_start = aq.id(R.id.et_breed_dosu_start).getText().toString();
        String breed_dosu_end = aq.id(R.id.et_breed_dosu_end).getText().toString();
        String breed_company = aq.id(R.id.et_breed_company_name).getText().toString();
        String breed_name = aq.id(R.id.et_breed_name).getText().toString();

        NonggaData nonggaData = new NonggaData();
        nonggaData.setNonga_id(nonga_id);
        nonggaData.setMember_yn(member_yn);
        nonggaData.setBreed_dosu_start(breed_dosu_start);
        nonggaData.setBreed_dosu_end(breed_dosu_end);
        nonggaData.setBreed_company(breed_company);
        nonggaData.setBreed_name(breed_name);
        nonggaData.setCommonData(commonData); //공통 코드
        Logger.log(commonData.toString());

        clickedListener.onClicked(view , nonggaData);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
