package com.kth.tobawoo.ui.fragment;

import android.app.Activity;
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
import com.kth.tobawoo.ui.GaechejeongboMainActivity;
import com.kth.tobawoo.ui.TableMainActivity;
import com.kth.tobawoo.ui.adapter.StyledAdapter;
import com.kth.tobawoo.utils.Logger;

public class GaechejeongboGeoseFrag extends BaseFrag implements OnChartValueSelectedListener {

    OnEventClickListener mClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_gaeche_geose , container , false);
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

        setTitle(getString(R.string.title_activity_gaechegeose_main));

        aq.find(R.id.btn_more).clicked(this, "showMorePage");

        aq.find(R.id.btn_select_nongga).clicked(this, "selectList");

        aq.find(R.id.ic_nonga_expand).clicked(this , "expend");
//        aq.find(R.id.btn_select_gaeche).clicked(this , "selectList");
//        aq.find(R.id.btn_select_gaese).clicked(this , "selectList");
        //검색 박스 설정
        //setSearchBox();

        //데이트 피커 이벤트 설정
        //setDatePickerEvent();

//        테이블 레이아웃 설정
        setTableLayout();

//        //차트 데이터 설정
//        setLineChartLayout();
    }



    public void selectList(View view){
        Intent intent = new Intent(getActivity(), TableMainActivity.class);
        ((GaechejeongboMainActivity)getActivity()).startActivity(intent);
    }

    public void setTableLayout(){
        String[] mainHeaders = new String[]{
                "농가아이디",
                "지역(축협)",
                "농가코드",
                "축주명",
                "농가형태",
                "농가상태",
                "두수",
                "방역명",
                "방역자",
                "방역일시",
                "방역자수"
        };
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
        };

        NonggaType nt = new NonggaType();
        for(int i=0;i<10;i++) {
//            nt.list.add(new NonggaData("id"+ i,"축협" + i, "code" + i, "테스트", "번식농가", "유지", "3" + i, "", "test2" + i, "test3" + i, "2015-12-08", "1" + i));
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
