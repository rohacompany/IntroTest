package com.tobawoo.nh2016.ui.summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.ChulhaSummaryData;

import java.util.ArrayList;

public class ChulhaSummaryFrag4 extends CommonSummaryFrag implements OnChartValueSelectedListener {

    ArrayList<ChulhaSummaryData> list = null;

    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_frag_chulha_tab4_summary, container, false);

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

    int sex_f_cnt_total = 0,sex_m_cnt_total=0,sex_n_cnt_total=0,sex_cnt_total=0;
    private void setTableData(){

        for(int i=0;i<list.size();i++){
            ChulhaSummaryData nsd = list.get(i);

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_5columns, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            TextView tv3 = (TextView) view.findViewById(R.id.tv3);
            TextView tv4 = (TextView) view.findViewById(R.id.tv4);
            TextView tv5 = (TextView) view.findViewById(R.id.tv5);

            tv1.setTextSize(13);
            tv2.setTextSize(13);
            tv3.setTextSize(13);
            tv4.setTextSize(13);
            tv5.setTextSize(13);

            title.setText(nsd.getChukhyup_name());
            tv1.setText(nsd.getA_cnt() + "\n( " + Math.round(nsd.getA_per()) + "%)");
            tv2.setText(nsd.getB_cnt() + "\n( " + Math.round(nsd.getB_per()) + "%)");
            tv3.setText(nsd.getC_cnt() + "\n( " + Math.round(nsd.getC_per()) + "%)");
            tv4.setText(nsd.getD_cnt() + "\n( " +  Math.round(nsd.getD_per()) + "%)");
            tv5.setText(nsd.getEtc12() + "\n( " +  Math.round(nsd.getEtc12_per()) + "%)");

            tableLayout.addView(view);
        }

//        addTotal();
    }


    public void setChart(){
        super.setChart();

        ArrayList<String> xVals = new ArrayList<String>();

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals4 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals5 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals6 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals7 = new ArrayList<BarEntry>();

        for(int i=0;i<list.size();i++){
            ChulhaSummaryData nsd = list.get(i);
            xVals.add(nsd.getChukhyup_name());
//            yVals1.add(new BarEntry(nsd.getBreed_0_cnt(),i));
//            yVals2.add(new BarEntry(nsd.getBreed_1_cnt(),i));
//            yVals3.add(new BarEntry(nsd.getBreed_2_cnt(),i));
//            yVals4.add(new BarEntry(nsd.getBreed_3_cnt(),i));
//            yVals5.add(new BarEntry(nsd.getBreed_4_cnt(),i));
//            yVals6.add(new BarEntry(nsd.getBreed_5_cnt(),i));
//            yVals7.add(new BarEntry(nsd.getBreed_over_cnt(),i));

        }

        BarDataSet set1, set2, set3 , set4 , set5 , set6 , set7;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet)mChart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet)mChart.getData().getDataSetByIndex(2);
            set4 = (BarDataSet)mChart.getData().getDataSetByIndex(3);
            set5 = (BarDataSet)mChart.getData().getDataSetByIndex(4);
            set6 = (BarDataSet)mChart.getData().getDataSetByIndex(5);
            set7 = (BarDataSet)mChart.getData().getDataSetByIndex(6);
            set1.setYVals(yVals1);
            set2.setYVals(yVals2);
            set3.setYVals(yVals3);
            set4.setYVals(yVals4);
            set5.setYVals(yVals5);
            set6.setYVals(yVals6);
            set7.setYVals(yVals7);
            mChart.getData().setXVals(xVals);

            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create 3 datasets with different types
            set1 = new BarDataSet(yVals1, "미경산우");
            set1.setColor(getResources().getColor(R.color.md_amber_500));
            set2 = new BarDataSet(yVals2, "1산차");
            set2.setColor(getResources().getColor(R.color.colorAccent));
            set3 = new BarDataSet(yVals3, "2산차");
            set3.setColor(getResources().getColor(R.color.md_light_blue_500));
            set4 = new BarDataSet(yVals4, "3산차");
            set4.setColor(getResources().getColor(R.color.md_red_500));
            set5 = new BarDataSet(yVals5, "4산차");
            set5.setColor(getResources().getColor(R.color.md_brown_500));
            set6 = new BarDataSet(yVals6, "5산차");
            set6.setColor(getResources().getColor(R.color.md_cyan_500));
            set7 = new BarDataSet(yVals7, "6산차이상");
            set7.setColor(getResources().getColor(R.color.md_deep_purple_500));

            set1.setDrawValues(false);
            set2.setDrawValues(false);
            set3.setDrawValues(false);
            set4.setDrawValues(false);
            set5.setDrawValues(false);
            set6.setDrawValues(false);
            set7.setDrawValues(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);
            dataSets.add(set3);
            dataSets.add(set4);
            dataSets.add(set5);
            dataSets.add(set6);
            dataSets.add(set7);

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
