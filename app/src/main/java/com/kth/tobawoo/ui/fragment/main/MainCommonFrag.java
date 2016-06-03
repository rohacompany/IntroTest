package com.kth.tobawoo.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.CommonData;
import com.kth.tobawoo.utils.DBHelper;
import com.kth.tobawoo.utils.Logger;

import java.util.ArrayList;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DBHelper(getActivity());

        aq = new AQuery(getActivity());

    }

    public void setup(){
        dbHelper.open();
        siDoList = dbHelper.fetchSido();

        dbHelper.close();


        ArrayAdapter<String> sidoAdapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item , siDoList);

        aq.find(R.id.sp_sido).adapter(sidoAdapter).getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Logger.log("7777777 onItemSelected!!");
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
                Logger.log("8888888 onItemSelected!!");
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

    }

}
