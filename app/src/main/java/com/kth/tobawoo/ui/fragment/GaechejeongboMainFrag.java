package com.kth.tobawoo.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.kth.tobawoo.R;
import com.kth.tobawoo.common.OnEventClickListener;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.BangyeokSearchActivity;
import com.kth.tobawoo.ui.GaecheSearchActivity;
import com.kth.tobawoo.ui.adapter.StyledAdapter;
import com.kth.tobawoo.utils.Logger;

/**
 * Created by tommy on 2016-01-18.
 */
public class GaechejeongboMainFrag extends BaseFrag implements OnChartValueSelectedListener {

    OnEventClickListener mClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_gaeche_main , container , false);
        aq = new AQuery(view);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mClickListener = (OnEventClickListener) activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setTitle(getString(R.string.title_activity_gaechejeongbo_main));

        aq.find(R.id.table_result_search_title).text("개체정보조회");

        aq.find(R.id.btn_more).clicked(this, "showMorePage");

        //검색 박스 설정
        setSearchBox();

        //데이트 피커 이벤트 설정
        setDatePickerEvent();

        //테이블 레이아웃 설정
//        setTableLayout();

//        //차트 데이터 설정
//        setLineChartLayout();
        aq.id(R.id.btn_search).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
    }

    public void showResult(){
        Logger.log("showResult execute!!");
        Intent intent = new Intent(getActivity() , GaecheSearchActivity.class);
        getActivity().startActivityForResult(intent, 100);
    }

    public void setTableLayout(){
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100
        };
        String[] mainHeaders = new String[]{
                "귀표번호",
                "농가코드",
                "농가명",
                "축협명",
                "시군구",
                "읍면동",
                "성별",
                "생년월일",
                "월령",
                "등록구분",
                "개체상태",
                "계대",
                "어미귀표번호",
                "어미혈통",
                "씨수소",
                "외조부",
                "외증조부",
                "개체구분",
                "개체관리번호",
                "목장주소"

        };


        NonggaType nt = new NonggaType();
        for(int i=0;i<100;i++) {
            nt.list.add(new NonggaData("KOR-002-094705076","2582","김종권","양평","양평군","양평읍","암","2014-09-25","15","기초","사육","0","KOR-002-300594740","혈통","KPN710","KPN769","","번식우","3190114051089","경기 양평군 양평읍 창대1리 23-1"));
        }

        TableFixHeaders tableFixHeaders = (TableFixHeaders) getView().findViewById(R.id.table);
        StyledAdapter<String> matrixTableAdapter = new StyledAdapter<String>(getActivity() , mainHeaders , mainWidths , nt);
        tableFixHeaders.setAdapter(matrixTableAdapter);

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        Logger.log("Value: " + e.getVal() + ", xIndex: " + e.getXIndex() + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {

    }

    public void showMorePage(){
        mClickListener.onOptionClicked();
    }
}
