package com.tobawoo.nh2016.ui.fragment.old;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.OnEventClickListener;
import com.tobawoo.nh2016.data.NonggaSearchResultData;
import com.tobawoo.nh2016.data.NonggaType;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.hellochart.BarChart;
import com.tobawoo.nh2016.hellochart.LineChart;
import com.tobawoo.nh2016.hellochart.PieChart;
import com.tobawoo.nh2016.ui.NongaSearchActivity;
import com.tobawoo.nh2016.ui.adapter.StyledAdapter;
import com.tobawoo.nh2016.common.Logger;

import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * Created by tommy on 2016-01-13.
 */
public class NongaMainFrag extends BaseFrag {

    private LineChartView lineChhartView;
    private PieChartView pieChartView;
    private ColumnChartView barChartView;

    OnEventClickListener mClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_nonga_main, container, false);
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

        setTitle(getString(R.string.frag_nonga_title));

        aq.find(R.id.btn_more).clicked(this , "showMorePage");

        //검색 박스 설정
        setSearchBox();

        //데이트 피커 이벤트 설정
        setDatePickerEvent();

        //테이블 레이아웃 설정
//        setTableLayout();

        //차트 데이터 설정
        setLineChartLayout();

        setPieChartLayout();

        setBarChartLayout();

        aq.id(R.id.btn_search).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
    }

    public void showResult(){
        Logger.log("showResult execute!!");
        Intent intent = new Intent(getActivity() , NongaSearchActivity.class);
        getActivity().startActivityForResult(intent , 100);
    }

    public void showMorePage(){
        mClickListener.onOptionClicked();
    }

    public void setTableLayout() {
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
        for (int i = 0; i < 10; i++) {
//            nt.list.add(new NonggaData("id" + i, "축협" + i, "code" + i, "테스트", "번식농가", "유지", "3" + i, "", "test2" + i, "test3" + i, "2015-12-08", "1" + i));
        }

        TableFixHeaders tableFixHeaders = (TableFixHeaders) getView().findViewById(R.id.table);
        StyledAdapter<String> matrixTableAdapter = new StyledAdapter<String>(getActivity(), mainHeaders, mainWidths, nt);
        tableFixHeaders.setAdapter(matrixTableAdapter);

    }

    public void setLineChartLayout() {

        lineChhartView = (LineChartView) aq.find(R.id.line_chart).getView();

        new LineChart(getActivity(), lineChhartView);

    }

    public void setPieChartLayout(){
        pieChartView = (PieChartView)aq.find(R.id.pie_chart).getView();

        new PieChart(getActivity() , pieChartView);

    }

    public void setBarChartLayout(){
        barChartView = (ColumnChartView)aq.find(R.id.bar_chart).getView();

        new BarChart(getActivity() , barChartView);

    }

    public void setNonggaData(NonggaSearchResultData data){
//        aq.find(R.id.view_search_result).visible();
//        aq.find(R.id.nongga_id).text(data.getNongga_id());
//        aq.find(R.id.chukju_name).text(data.getChukju_name());
//        aq.find(R.id.nongga_code).text(data.getNongga_code());
//        aq.find(R.id.nongga_member_code).text(data.getNongga_member_code());
//        aq.find(R.id.nongga_address).text(data.getNongga_address());
//        aq.find(R.id.nongga_phone_number).text(data.getNongga_phone_number());
//        aq.find(R.id.nongga_home_number).text(data.getNongga_home_number());
    }


}
