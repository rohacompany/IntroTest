package com.kth.tobawoo.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
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
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

}
