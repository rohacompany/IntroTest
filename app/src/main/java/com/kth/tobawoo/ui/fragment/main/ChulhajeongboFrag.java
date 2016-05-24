package com.kth.tobawoo.ui.fragment.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;

/**
 * Created by tommy on 2016-05-24.
 */
public class ChulhajeongboFrag extends Fragment{
    AQuery aq;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_chulhajeongbo, container , false);

        aq = new AQuery(view);

        aq.id(R.id.btn_search_nonga).clicked(this , "click");
        aq.id(R.id.btn_search_gaeche).clicked(this , "click");

        aq.id(R.id.view_frag_common_title).text("출하정보");
        return view;
    }

    OnFragmentClickedListener clickedListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        clickedListener = (OnFragmentClickedListener) activity;
    }

    public void click(View view){
        clickedListener.onClicked(view);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
