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
import com.tobawoo.nh2016.data.ChulhaSummaryData;
import com.tobawoo.nh2016.common.Logger;

import java.util.ArrayList;

public class ChulhaSummaryFrag3 extends CommonSummaryFrag implements OnChartValueSelectedListener {

    ArrayList<ChulhaSummaryData> list = null;

    TableLayout tableLayout,tableLayout2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_frag_chulha_tab3_summary, container, false);

        list = getArguments().getParcelableArrayList("datas");

        tableLayout = (TableLayout) v.findViewById(R.id.table);
        tableLayout2 = (TableLayout) v.findViewById(R.id.table2);

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
            ChulhaSummaryData nsd = list.get(i);

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_7columns, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            TextView tv3 = (TextView) view.findViewById(R.id.tv3);
            TextView tv4 = (TextView) view.findViewById(R.id.tv4);
            TextView tv5= (TextView) view.findViewById(R.id.tv5);
            TextView tv6 = (TextView) view.findViewById(R.id.tv6);
            TextView tv7 = (TextView) view.findViewById(R.id.tv7);

            tv1.setTextSize(10);
            tv2.setTextSize(10);
            tv3.setTextSize(10);
            tv4.setTextSize(10);
            tv5.setTextSize(10);
            tv6.setTextSize(10);
            tv7.setTextSize(10);


            title.setText(nsd.getChukhyup_name());
            tv1.setText(nsd.getOne_p_p_cnt() +"\n("+nsd.getOne_p_p_per() + "%)");
            tv2.setText(nsd.getOne_p_cnt() +"\n("+nsd.getOne_p_per() + "%)");
            tv3.setText(nsd.getOne_cnt() +"\n("+nsd.getOne_per() + "%)");
            tv4.setText(nsd.getOne_total_cnt() +"\n("+nsd.getOne_total_per() + "%)");

            tv5.setText(nsd.getTwo_cnt() +"\n("+nsd.getTwo_per() + "%)");
            tv6.setText(nsd.getThree_cnt() +"\n("+nsd.getThree_per() + "%)");
            tv7.setText(nsd.getEtc11() +"\n("+nsd.getEtc11_per() + "%)");

            tableLayout.addView(view);
        }


//        addTotal();
//        addTotal2();
    }

//    public void addTotal(){
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_4columns, null);
//        TextView title = (TextView) view.findViewById(R.id.title);
//        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
//        TextView tv2 = (TextView) view.findViewById(R.id.tv2);
//        TextView tv3 = (TextView) view.findViewById(R.id.tv3);
//        TextView tv4 = (TextView) view.findViewById(R.id.tv4);
//
//        tv1.setTextSize(13);
//        tv2.setTextSize(13);
//        tv3.setTextSize(13);
//        tv4.setTextSize(13);
//
//
//        title.setText("합계");
//        tv1.setText(birth_weight_total+"");
//        tv2.setText(weight_total+"");
//        tv3.setText(etc02_total+"");
//        tv4.setText(etc01_total+"");
//
//
//        tableLayout.addView(view);
//    }
//
//    public void addTotal2(){
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_3columns, null);
//        TextView title = (TextView) view.findViewById(R.id.title);
//        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
//        TextView tv2 = (TextView) view.findViewById(R.id.tv2);
//        TextView tv3 = (TextView) view.findViewById(R.id.tv3);
//
//        tv1.setTextSize(13);
//        tv2.setTextSize(13);
//        tv3.setTextSize(13);
//
//
//        title.setText("합계");
//        tv1.setText(etc03_total+"");
//        tv2.setText(etc10_total+"");
//        tv3.setText(etc08_total+"");
//
//
//        tableLayout2.addView(view);
//    }

    public void setChart(){
        super.setChart();

        aq = new AQuery(getView());
        aq.id(R.id.chart_title).text("성별 출하성적(비율)");

        ArrayList<String> xVals = new ArrayList<String>();

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();

        for(int i=0;i<list.size();i++){
            ChulhaSummaryData nsd = list.get(i);
            xVals.add(nsd.getChukhyup_name());
            Logger.log("data -> " + nsd.getSex_f_per() + "," + nsd.getSex_m_per() + "," + nsd.getSex_per());
            yVals1.add(new BarEntry(nsd.getSex_f_per(),i));
            yVals2.add(new BarEntry(nsd.getSex_m_per(),i));
            yVals3.add(new BarEntry(nsd.getSex_n_per(),i));

        }

        BarDataSet set1, set2, set3;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet)mChart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet)mChart.getData().getDataSetByIndex(2);
            set1.setYVals(yVals1);
            set2.setYVals(yVals2);
            set3.setYVals(yVals3);
            mChart.getData().setXVals(xVals);

            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create 3 datasets with different types
            set1 = new BarDataSet(yVals1, "암");
            // set1.setColors(ColorTemplate.createColors(getApplicationContext(),
            // ColorTemplate.FRESH_COLORS));
            set1.setColor(getResources().getColor(R.color.md_amber_500));
            set2 = new BarDataSet(yVals2, "수");
            set2.setColor(getResources().getColor(R.color.colorAccent));
            set3 = new BarDataSet(yVals3, "거세");
            set3.setColor(getResources().getColor(R.color.md_light_blue_500));

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);
            dataSets.add(set3);

            set1.setDrawValues(false);
            set2.setDrawValues(false);
            set3.setDrawValues(false);

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
