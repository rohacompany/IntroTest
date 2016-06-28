package com.tobawoo.nh2016.ui.fragment.old;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.OnEventClickListener;
import com.tobawoo.nh2016.ui.PopupActivity;

/**
 * Created by tommy on 2016-01-16.
 */
public class WriteNongaMainFrag extends Fragment implements View.OnClickListener{OnEventClickListener mListener;
    PopupActivity uiActivity;
    AQuery aq;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_write_nonggamain , container , false);

        aq = new AQuery(view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.uiActivity = (PopupActivity)activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        uiActivity.setAppbarTitle("농가정보등록");

        init();
    }

    public void init(){
        aq.id(R.id.btn_nonga_container1).clicked(this);
        aq.id(R.id.btn_nonga_container2).clicked(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nonga_container1:
                aq.id(R.id.nongga_main_container1).visible();
                aq.id(R.id.nongga_main_container2).gone();
                aq.id(R.id.btn_nonga_container1).textColor(getActivity().getResources().getColor(R.color.Crimson));
                aq.id(R.id.btn_nonga_container2).textColor(getActivity().getResources().getColor(R.color.LightGrey));
                break;
            case R.id.btn_nonga_container2:
                aq.id(R.id.nongga_main_container1).gone();
                aq.id(R.id.nongga_main_container2).visible();
                aq.id(R.id.btn_nonga_container1).textColor(getActivity().getResources().getColor(R.color.LightGrey));
                aq.id(R.id.btn_nonga_container2).textColor(getActivity().getResources().getColor(R.color.Crimson));
                break;
        }
    }

    public void saveDone(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("저장 하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getActivity().onBackPressed();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }
}
