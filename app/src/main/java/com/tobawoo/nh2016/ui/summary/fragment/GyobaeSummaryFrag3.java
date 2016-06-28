package com.tobawoo.nh2016.ui.summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.GyobaeSummaryData;
import com.tobawoo.nh2016.common.CommonUtils;

import java.util.ArrayList;

public class GyobaeSummaryFrag3 extends CommonSummaryFrag implements OnChartValueSelectedListener {

    ArrayList<GyobaeSummaryData> list = null;

    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_frag_gyobae_tab3_summary, container, false);

        list = getArguments().getParcelableArrayList("datas");

        tableLayout = (TableLayout) v.findViewById(R.id.table);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTableData();
        setChart();
    }

    private void setTableData(){
        for(int i=0;i<list.size();i++){
            GyobaeSummaryData nsd = (GyobaeSummaryData) list.get(i);

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_8columns, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            TextView tv3 = (TextView) view.findViewById(R.id.tv3);
            TextView tv4 = (TextView) view.findViewById(R.id.tv4);
            TextView tv5 = (TextView) view.findViewById(R.id.tv5);
            TextView tv6 = (TextView) view.findViewById(R.id.tv6);
            TextView tv7 = (TextView) view.findViewById(R.id.tv7);
            TextView tv8 = (TextView) view.findViewById(R.id.tv8);

            title.setText(nsd.getChukhyup_name());
            tv1.setText(nsd.getMonth_15_cnt() + "");
            tv2.setText(nsd.getMonth_30_cnt() + "");
            tv3.setText(nsd.getMonth_45_cnt() + "");
            tv4.setText(nsd.getMonth_60_cnt() + "");
            tv5.setText(nsd.getMonth_75_cnt() + "");
            tv6.setText(nsd.getMonth_90_cnt() + "");
            tv7.setText(nsd.getMonth_over_cnt() + "");
            tv8.setText(nsd.getMonth_cnt() + "");

            tableLayout.addView(view);

        }
    }

    public void setChart(){
        super.setChart();

        aq = new AQuery(getView());
        aq.id(R.id.chart_title).text("축협별 교배두수(어미혈통구분)");

        ArrayList<String> xVals = new ArrayList<String>();


        String[] xTitles = {"15개월미만" , "~30개월" , "~45개월" , "~60개월" , "~75개월" , "~90개월" , "90개월이상"};
        for(String s : xTitles){
            xVals.add(s);
        }

        BarDataSet set1;

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        for(int i=0;i<list.size();i++) {

            ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

            yVals1.add(new BarEntry(list.get(i).getMonth_15_cnt(), 0));
            yVals1.add(new BarEntry(list.get(i).getMonth_30_cnt(), 1));
            yVals1.add(new BarEntry(list.get(i).getMonth_45_cnt(), 2));
            yVals1.add(new BarEntry(list.get(i).getMonth_60_cnt(), 3));
            yVals1.add(new BarEntry(list.get(i).getMonth_75_cnt(), 4));
            yVals1.add(new BarEntry(list.get(i).getMonth_90_cnt(), 5));
            yVals1.add(new BarEntry(list.get(i).getMonth_over_cnt(), 6));


            if (mChart.getData() != null &&
                    mChart.getData().getDataSetCount() > 0) {
                set1 = (BarDataSet) mChart.getData().getDataSetByIndex(i);
                set1.setYVals(yVals1);


            } else {
                set1 = new BarDataSet(yVals1, list.get(i).getChukhyup_name());

                set1.setColor(CommonUtils.randomColor(getActivity() , i));

                set1.setDrawValues(false);
                dataSets.add(set1);
            }

        }

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {

            mChart.getData().setXVals(xVals);

            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();

        }else {

            BarData data = new BarData(xVals, dataSets);
//        data.setValueFormatter(new LargeValueFormatter());

            // add space between the dataset groups in percent of bar-width
            data.setGroupSpace(80f);
            data.setValueTypeface(tf);

            mChart.setData(data);

        }

        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
