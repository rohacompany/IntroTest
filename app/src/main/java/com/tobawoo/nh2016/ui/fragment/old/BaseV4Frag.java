package com.tobawoo.nh2016.ui.fragment.old;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.Logger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by tommy on 2016-01-13.
 */
public class BaseV4Frag extends Fragment implements DatePickerDialog.OnDateSetListener{

    AQuery aq = null;
    public EditText targetDateTimeET;
    Activity uiActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        uiActivity = activity;
    }

    public void setTitle(String title){
        uiActivity.setTitle(title);
    }

    public void setSearchBox(){
        if(aq.find(R.id.view_search_box_ck_1)!=null) {
            aq.find(R.id.view_search_box_ck_1).clicked(this, "showSearchBox");
        }
        aq.find(R.id.view_search_box_ck_2).clicked(this , "showSearchBox");
        aq.find(R.id.view_search_box_ck_3).clicked(this, "showSearchBox");
        aq.find(R.id.view_search_box_ck_4).clicked(this, "showSearchBox");
        aq.find(R.id.view_search_box_ck_5).clicked(this, "showSearchBox");
    }

    public void showSearchBox(View view){

        CheckBox cb = (CheckBox)view;
        int target_include_redId = -1;
        switch (view.getId()){
            case R.id.view_search_box_ck_1:
                target_include_redId = R.id.view_search_box_2;
                break;
            case R.id.view_search_box_ck_2:
                target_include_redId = R.id.view_search_box_3;
                break;
            case R.id.view_search_box_ck_3:
                target_include_redId = R.id.view_search_box_4;
                break;
            case R.id.view_search_box_ck_4:
                target_include_redId = R.id.view_search_box_5;
                break;
//            case R.id.view_search_box_ck_5:
//                target_include_redId = R.id.view_search_box_6;
//                break;
        }

        final CardView cv = (CardView)aq.id(target_include_redId).getView();

        if(cb.isChecked()){
            cv.setVisibility(View.VISIBLE);
        }else{
            cv.setVisibility(View.GONE);
        }

    }

    public void setDatePickerEvent(){
//        aq.find(R.id.ibtn_type2_open_date_popup_start).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type2_open_date_popup_end).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_start).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_end).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type4_open_date_popup_start).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type4_open_date_popup_end).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_start_1).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_end_1).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_start_2).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_end_2).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_start_3).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_end_3).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_start_4).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_end_4).clicked(this, "showDatePicker");
    }

    public void showDatePicker(View view){
        Logger.log("showDatePicker execute!!");
        int targetTextView = -1;
        switch (view.getId()){
//            case R.id.ibtn_type2_open_date_popup_start:
//                targetTextView = R.id.tv_type2_date_popup_start;//tv_type2_date_popup_start
//                break;
//            case R.id.ibtn_type2_open_date_popup_end:
//                targetTextView = R.id.tv_type2_date_popup_end;
//                break;
//            case R.id.ibtn_type3_open_date_popup_start:
//                targetTextView = R.id.tv_type3_date_popup_start;
//                break;
//            case R.id.ibtn_type3_open_date_popup_end:
//                targetTextView = R.id.tv_type3_date_popup_end;
//                break;
//            case R.id.ibtn_type4_open_date_popup_start:
//                targetTextView = R.id.tv_type4_date_popup_start;
//                break;
//            case R.id.ibtn_type4_open_date_popup_end:
//                targetTextView = R.id.tv_type4_date_popup_end;
//                break;
//            case R.id.ibtn_type5_open_date_popup_start_1:
//                targetTextView = R.id.tv_type5_date_popup_start_1;
//                break;
//            case R.id.ibtn_type5_open_date_popup_end_1:
//                targetTextView = R.id.tv_type5_date_popup_end_1;
//                break;
//            case R.id.ibtn_type5_open_date_popup_start_2:
//                targetTextView = R.id.tv_type5_date_popup_start_2;
//                break;
//            case R.id.ibtn_type5_open_date_popup_end_2:
//                targetTextView = R.id.tv_type5_date_popup_end_2;
//                break;
//            case R.id.ibtn_type5_open_date_popup_start_3:
//                targetTextView = R.id.tv_type5_date_popup_start_3;
//                break;
//            case R.id.ibtn_type5_open_date_popup_end_3:
//                targetTextView = R.id.tv_type5_date_popup_end_3;
//                break;
//            case R.id.ibtn_type5_open_date_popup_start_4:
//                targetTextView = R.id.tv_type5_date_popup_start_4;
//                break;
//            case R.id.ibtn_type5_open_date_popup_end_4:
//                targetTextView = R.id.tv_type5_date_popup_end_4;
//                break;
        }
//        Logger.log("select id -> " + R.id.tv_type2_date_popup_start + "," + targetTextView );
        targetDateTimeET = aq.id(targetTextView).getEditText();

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        Logger.log("캘린더 오픈!!");
        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = year + "년 " + (monthOfYear+1) + "월 " + dayOfMonth+"일";
        Logger.log("date -> " + date);
        if(targetDateTimeET!=null)
            targetDateTimeET.setText(date);
        //dateTextView.setText(date);
    }

    public void fadeAnimation(final View tv, final boolean checked) {

        final Animation animationFade;

        tv.setAlpha(0f);

        if (!checked) {

            animationFade = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);

        } else {

            animationFade = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);

        }

        animationFade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Logger.log("onAnimationEnd -> " + checked);
                if (!checked) {
                    tv.setVisibility(View.GONE);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tv.setAlpha(1);
                tv.startAnimation(animationFade);
            }
        });

    }

    public void saveDone(){
        Toast.makeText(getActivity(), "onOptionClicked!!", Toast.LENGTH_SHORT).show();
    }

    boolean nongae_expand = true;
    public void expend(View view){
        View container = aq.find(R.id.view_gaeche_content_container).getView();
        if(container.getVisibility() == View.GONE) {
            Logger.log("visible 1111111");
            aq.find(R.id.ic_nonga_expand).image(R.drawable.ic_action_return_from_full_screen);
//            aq.id(container).visible();
        }else{
            Logger.log("visible 22222222");
            aq.find(R.id.ic_nonga_expand).image(R.drawable.ic_action_full_screen);
//            aq.id(container).gone();
        }

        nongae_expand = !nongae_expand;

        setVisibleAnimation(container);
    }

    public void setVisibleAnimation(final View viewToAnimate){
        if(viewToAnimate.getVisibility() == View.VISIBLE) {
            viewToAnimate.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    viewToAnimate.setVisibility(View.GONE);
                }
            });
        } else {
            viewToAnimate.animate().alpha(1.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationEnd(animation);
                    viewToAnimate.setVisibility(View.VISIBLE);
                }
            });
        }
    }
    
}
