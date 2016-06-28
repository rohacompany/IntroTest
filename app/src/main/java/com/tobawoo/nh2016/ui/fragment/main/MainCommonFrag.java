package com.tobawoo.nh2016.ui.fragment.main;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.CommonData;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.DBHelper;
import com.tobawoo.nh2016.common.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tommy on 2016-05-27.
 */
public class MainCommonFrag extends Fragment{
    AQuery aq;
    DBHelper dbHelper = null;
    List<String> gugunList = new ArrayList<String>();
    List<String> dongList = new ArrayList<String>();
    List<String> siDoList;
    ArrayAdapter<String> gugunAdapter,dongAdapter;
    private String si,gugun,dong;
    CommonData commonData;
    HashMap<String,String> paramMap;
    EditText targetDateTimeET;
    int year, month, day, hour, minute;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DBHelper(getActivity());

//        aq = new AQuery(getActivity());

    }

    public void setup(){

        aq.find(R.id.btn_search_result).clicked(this , "click");
        aq.find(R.id.btn_search_result_summary).clicked(this , "click");
        aq.find(R.id.btn_search_reset).clicked(this,"reset");

        dbHelper.open();
        siDoList = dbHelper.fetchSido();

        dbHelper.close();


        ArrayAdapter<String> sidoAdapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item , siDoList);

        aq.find(R.id.sp_sido).adapter(sidoAdapter).getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                si = siDoList.get(position);
                dbHelper.open();
                dbHelper.fetchGuGun(si , gugunList);
                dbHelper.close();
                gugunAdapter.notifyDataSetChanged();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gugunAdapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item , gugunList);
        aq.find(R.id.sp_gugun).adapter(gugunAdapter).itemSelected(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gugun = gugunList.get(position);
                dbHelper.open();
                dbHelper.fetchDong(si , gugun, dongList);
                dbHelper.close();
                dongAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       dongAdapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item , dongList);
        aq.find(R.id.sp_dong).adapter(dongAdapter);

        setDatePickerEvent();
    }

    /**
     * 초기화버튼에 대한 함수
     */
    public void reset(){
        ViewGroup viewGroup = (ViewGroup) getView();
        resetAll(viewGroup);
    }

    /**
     * 초기화 재귀함수
     * @param viewGroup
     */
    private void resetAll(ViewGroup viewGroup) {
        for (int i = 0, N = viewGroup.getChildCount(); i < N; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                if (child instanceof Spinner) {
                    ((Spinner)child).setSelection(0);
                }else {
                    resetAll((ViewGroup) child);
                }
            } else if (child instanceof EditText) {
                ((EditText) child).setText("");
            }
        }
    }

    protected void setupData(){
        commonData = new CommonData();
        String si = (String)aq.id(R.id.sp_sido).getSelectedItem();
        String gubun = (String)aq.id(R.id.sp_gugun).getSelectedItem();
        String dong = (String)aq.id(R.id.sp_dong).getSelectedItem();
        String chukhyup_name = aq.id(R.id.et_chukhyup_name).getText().toString();
        String nonga_name =aq.id(R.id.et_nonga_name).getText().toString();
        String pumjong = (String) aq.id(R.id.sp_pumjong).getSelectedItem();
        String sex = (String)aq.id(R.id.sp_sex).getSelectedItem();
        String breed_type = (String)aq.id(R.id.sp_breed_type).getSelectedItem();
        String deungrokgubun = (String)aq.id(R.id.sp_deungrokgubun).getSelectedItem();
        String gwipyobeonho = aq.id(R.id.et_gwipyobeonho).getText().toString();
        String mom_gwipyobeonho = aq.id(R.id.et_mom_gwipyobeonho).getText().toString();
        String abissisusobeonho = aq.id(R.id.et_abissisusobeonho).getText().toString();
        String wolryeong_start = aq.id(R.id.et_wolryeong_start).getText().toString();
        String wolryeong_end = aq.id(R.id.et_wolryeong_end).getText().toString();
        String sancha_start = aq.id(R.id.et_sancha_start).getText().toString();
        String sancha_end = aq.id(R.id.et_sancha_end).getText().toString();

        commonData = new CommonData();
        commonData.setSido(si);
        commonData.setGubun(gubun);
        commonData.setDong(dong);
        commonData.setChukhyup_name(chukhyup_name);
        commonData.setHouse_name(nonga_name);
        commonData.setPumjong(pumjong);
        commonData.setSex(sex);
        commonData.setBreed_type(breed_type);
        commonData.setDeungrokgubun(deungrokgubun);
        commonData.setGwipyobeonho(gwipyobeonho);
        commonData.setMom_gwipyobeonho(mom_gwipyobeonho);
        commonData.setAbissisusobeonho(abissisusobeonho);
        commonData.setWolryeong_start(wolryeong_start);
        commonData.setWolryeong_end(wolryeong_end);
        commonData.setSancha_start(sancha_start);
        commonData.setSancha_end(sancha_end);

        paramMap = new HashMap<String,String>();
        paramMap.put("search_sido" , CommonUtils.fixNull(commonData.getSido())); //시
        paramMap.put("search_gugun" , CommonUtils.fixNull(commonData.getGubun()));//구군
        paramMap.put("search_dong" , CommonUtils.fixNull(commonData.getDong())); //동
        paramMap.put("search_chukhyup_name" , commonData.getChukhyup_name()); //축협명
        paramMap.put("search_house_name" , commonData.getHouse_name());//농가명
        paramMap.put("search_kind" , CommonUtils.fixNull(commonData.getPumjong()));//품종
        paramMap.put("search_cow_sex" , CommonUtils.fixNull(commonData.getSex())); //성별
        paramMap.put("search_entity_status" , CommonUtils.fixNull(commonData.getBreed_type())); //사육상태
        paramMap.put("search_register_gubun" , CommonUtils.fixNull(commonData.getDeungrokgubun())); //등록구분
        paramMap.put("search_barcode" , commonData.getGwipyobeonho());
        paramMap.put("search_mother_barcode" , commonData.getMom_gwipyobeonho()); //어미귀표번호
        paramMap.put("search_kpn_no" , commonData.getAbissisusobeonho());
        paramMap.put("search_live_month_start" , commonData.getWolryeong_start());
        paramMap.put("search_live_month_end" , commonData.getWolryeong_end());
        paramMap.put("search_last_breed_count_start" , commonData.getSancha_start());
        paramMap.put("search_last_breed_count_end" , commonData.getSancha_end());


    }

    public void setDatePickerEvent(){
        aq.id(R.id.ibtn_type1_open_date_popup_start).clicked(this, "showDatePicker");
        aq.id(R.id.ibtn_type1_open_date_popup_end).clicked(this, "showDatePicker");
        aq.id(R.id.ibtn_type3_open_date_popup_start).clicked(this, "showDatePicker");
        aq.id(R.id.ibtn_type3_open_date_popup_end).clicked(this, "showDatePicker");
        aq.id(R.id.ibtn_type4_open_date_popup_start).clicked(this, "showDatePicker");
        aq.id(R.id.ibtn_type4_open_date_popup_end).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_start).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_end).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type2_open_date_popup_start_1).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type2_open_date_popup_end_1).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_start_2).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type3_open_date_popup_end_2).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type4_open_date_popup_start_3).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type4_open_date_popup_end_3).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_start_4).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type5_open_date_popup_end_4).clicked(this, "showDatePicker");
    }

    public void showDatePicker(View view){
        Logger.log("howDatePicker execute!");
        int targetTextView = -1;
        switch (view.getId()){
            case R.id.ibtn_type1_open_date_popup_start:
                targetTextView = R.id.tv_type1_date_popup_start;
                break;
            case R.id.ibtn_type1_open_date_popup_end:
                targetTextView = R.id.tv_type1_date_popup_end;
                break;
            case R.id.ibtn_type3_open_date_popup_start:
                targetTextView = R.id.tv_type3_date_popup_start;
                break;
            case R.id.ibtn_type3_open_date_popup_end:
                targetTextView = R.id.tv_type3_date_popup_end;
                break;
            case R.id.ibtn_type4_open_date_popup_start:
                targetTextView = R.id.tv_type4_date_popup_start;
                break;
            case R.id.ibtn_type4_open_date_popup_end:
                targetTextView = R.id.tv_type4_date_popup_end;
                break;
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
        targetDateTimeET = aq.find(targetTextView).getEditText();

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        new DatePickerDialog(getActivity(), dateSetListener, year, month, day).show();
//        Calendar now = Calendar.getInstance();
//        com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
//                this,
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DAY_OF_MONTH)
//        );
//        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

//    @Override
//    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//        String date = year + "년 " + (monthOfYear+1) + "월 " + dayOfMonth+"일";
//        Logger.log("date -> " + date);
//        if(targetDateTimeET!=null)
//            targetDateTimeET.setText(date);
//        //dateTextView.setText(date);
//    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            int month = monthOfYear + 1;
            String formattedMonth = "" + month;
            String formattedDayOfMonth = "" + dayOfMonth;

            if(month < 10){

                formattedMonth = "0" + month;
            }
            if(dayOfMonth < 10){

                formattedDayOfMonth = "0" + dayOfMonth;
            }

            targetDateTimeET.setText( year + "-"+  formattedMonth + "-"+ formattedDayOfMonth );
        }
    };

}
