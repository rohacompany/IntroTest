package com.tobawoo.nh2016.ui.summary.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NongaSummaryData;
import com.tobawoo.nh2016.ui.summary.MyMarkerView;

import java.util.ArrayList;

/**
 * Created by tommy on 2016-06-11.
 */
public class CommonSummaryFrag extends Fragment{
    ArrayList<NongaSummaryData> list = new ArrayList<NongaSummaryData>();
    AQuery aq;
    BarChart mChart;
    Typeface tf;

    ArrayList<Integer> colorList = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setUp(){
        list = getArguments().getParcelableArrayList("datas");

    }

    public void setChart(){
        mChart = (BarChart) getView().findViewById(R.id.chart1);

        setChartnit(mChart);
    }

    public void setChartnit(BarChart mChart){

        mChart.setDescription("");

//        mChart.setDrawBorders(true);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(true);

        mChart.setDrawBarShadow(false);

        mChart.setDrawGridBackground(false);

//        mChart.setDrawValueAboveBar(false);


        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);

        // define an offset to change the original position of the marker
        // (optional)
        // mv.setOffsets(-mv.getMeasuredWidth() / 2, -mv.getMeasuredHeight());

        mChart.animateXY(1500,1500);

        // set the marker to the chart
        mChart.setMarkerView(mv);

        tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/NanumGothic.otf");

//
//        mSeekBarX.setProgress(10);
//        mSeekBarY.setProgress(100);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        l.setTypeface(tf);
        l.setYOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(10f);

        XAxis xl = mChart.getXAxis();
        xl.setTypeface(tf);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawGridLines(false);
        xl.setSpaceBetweenLabels(2);


        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTypeface(tf);
//        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(30f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        mChart.getAxisRight().setEnabled(false);
    }

    public void setNongaSummaryList(ArrayList<NongaSummaryData> list){
        this.list = list;
    }
}
