package com.tobawoo.nh2016.ui.summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NongaSummaryData;

import java.util.ArrayList;

public class NongaSummaryFrag3 extends CommonSummaryFrag implements OnChartValueSelectedListener {

    private TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_frag_nonga_tab3_summary, container, false);

        tableLayout = (TableLayout) v.findViewById(R.id.table);

        setUp();

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
            NongaSummaryData nsd = (NongaSummaryData) list.get(i);

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_4columns, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            TextView tv3 = (TextView) view.findViewById(R.id.tv3);
            TextView tv4 = (TextView) view.findViewById(R.id.tv4);

            title.setText(nsd.getChukhyup_name());
            tv1.setText(nsd.getShipment_sex_m_cnt() + "");
            tv2.setText(nsd.getShipment_sex_f_cnt()+"");
            tv3.setText(nsd.getShipment_sex_n_cnt() + "");
            tv4.setText(nsd.getShipment_sex_cnt() + "");

            tableLayout.addView(view);

        }
    }

    public void setChart(){
        super.setChart();

        aq = new AQuery(getView());
        aq.id(R.id.chart_title).text("축협별 출하두수(성별)");

        setChart1(mChart);
    }

    private void setChart1(BarChart mChart){
        ArrayList<String> xVals = new ArrayList<String>();

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals4 = new ArrayList<BarEntry>();

        for(int i=0;i<list.size();i++){
            NongaSummaryData nsd = list.get(i);
            xVals.add(nsd.getChukhyup_name());
            yVals1.add(new BarEntry(nsd.getShipment_sex_m_cnt(),i));
            yVals2.add(new BarEntry(nsd.getShipment_sex_f_cnt(),i));
            yVals3.add(new BarEntry(nsd.getShipment_sex_n_cnt(),i));
            yVals4.add(new BarEntry(nsd.getShipment_sex_cnt(),i));
        }

        BarDataSet set1, set2, set3 , set4;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet)mChart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet)mChart.getData().getDataSetByIndex(2);
            set4 = (BarDataSet)mChart.getData().getDataSetByIndex(3);
            set1.setYVals(yVals1);
            set2.setYVals(yVals2);
            set3.setYVals(yVals3);
            set4.setYVals(yVals4);
            mChart.getData().setXVals(xVals);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create 3 datasets with different types
            set1 = new BarDataSet(yVals1, "암");
            set1.setColor(getResources().getColor(R.color.md_amber_500));
            set2 = new BarDataSet(yVals2, "수");
            set2.setColor(getResources().getColor(R.color.md_light_green_500));
            set3 = new BarDataSet(yVals3, "거세");
            set3.setColor(getResources().getColor(R.color.md_light_blue_500));
            set4 = new BarDataSet(yVals4, "전체");
            set3.setColor(getResources().getColor(R.color.md_red_500));

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);
            dataSets.add(set3);
            dataSets.add(set4);

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
