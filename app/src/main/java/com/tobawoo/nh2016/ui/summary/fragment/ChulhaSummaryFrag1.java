package com.tobawoo.nh2016.ui.summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.ChulhaSummaryData;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.common.CommonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChulhaSummaryFrag1 extends CommonSummaryFrag implements OnChartValueSelectedListener {

    ArrayList<ChulhaSummaryData> list = null;

    TableLayout tableLayout;

    AQuery aq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_frag_chulha_tab1_summary, container, false);

        aq = new AQuery(v);

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

    int sex_f_cnt_total = 0, sex_m_cnt_total = 0, sex_n_cnt_total = 0, sex_cnt_total = 0;

    private void setTableData() {

        for (int i = 0; i < list.size(); i++) {
            ChulhaSummaryData nsd = list.get(i);

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_4columns, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            TextView tv3 = (TextView) view.findViewById(R.id.tv3);
            TextView tv4 = (TextView) view.findViewById(R.id.tv4);

            tv1.setTextSize(13);
            tv2.setTextSize(13);
            tv3.setTextSize(13);
            tv4.setTextSize(13);


            title.setText(nsd.getChukhyup_name());
            tv1.setText(nsd.getSex_f_cnt() + "\n( " + Math.round(nsd.getSex_f_per()) + "%)");
            tv2.setText(nsd.getSex_m_cnt() + "\n( " + Math.round(nsd.getSex_m_per()) + "%)");
            tv3.setText(nsd.getSex_n_cnt() + "\n(" + Math.round(nsd.getSex_n_per()) + "%)");
            tv4.setText(nsd.getSex_cnt() + "\n(" + Math.round(nsd.getSex_per()) + "%)");

            sex_f_cnt_total += nsd.getSex_f_cnt();
            sex_m_cnt_total += nsd.getSex_m_cnt();
            sex_n_cnt_total += nsd.getSex_n_cnt();
            sex_cnt_total += nsd.getSex_cnt();

            tableLayout.addView(view);
        }

        addTotal();
    }

    public void addTotal() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_frag_tab_summaray_tb_item_4columns, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);
        TextView tv3 = (TextView) view.findViewById(R.id.tv3);
        TextView tv4 = (TextView) view.findViewById(R.id.tv4);

        tv1.setTextSize(13);
        tv2.setTextSize(13);
        tv3.setTextSize(13);
        tv4.setTextSize(13);

        title.setText("합계");
        tv1.setText(sex_f_cnt_total + "");
        tv2.setText(sex_m_cnt_total + "");
        tv3.setText(sex_n_cnt_total + "");
        tv4.setText(sex_cnt_total + "");

        tableLayout.addView(view);
    }

    public void setChart() {
        super.setChart();

        aq.id(R.id.chart_title).text("성별 출하성적");

        aq.progress(CommonUtils.getProgressDialog(getActivity())).ajax(URLManager._GET_CHULHA_SUMMARY_CHART_TYPE1_LIST, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {

                try {
                    ArrayList<String> xVals = new ArrayList<String>();

                    String[] xTitles = {"생체중(kg)", "도체중량(kg)", "동지방두께(mm)", "등심단면적(cm2)", "육량지수", "근내지방도(No)"};
                    for (String s : xTitles) {
                        xVals.add(s);
                    }

                    BarDataSet set1, set2, set3, set4, set5, set6, set7;

                    ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();


                    JSONArray array = object.getJSONArray("results");


                    for (int i = 0; i < array.length(); i++) {

                        JSONObject item = array.getJSONObject(i);

                        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

                        yVals1.add(new BarEntry(  item.getInt("birth_weight") , 0));
                        yVals1.add(new BarEntry(  item.getInt("weight") , 1));
                        yVals1.add(new BarEntry(  item.getInt("etc02") , 2));
                        yVals1.add(new BarEntry(  item.getInt("etc01") , 3));
                        yVals1.add(new BarEntry(  item.getInt("etc10") , 4));
                        yVals1.add(new BarEntry(  item.getInt("etc03") , 5));


                        if (mChart.getData() != null &&
                                mChart.getData().getDataSetCount() > 0) {
                            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(i);
                            set1.setYVals(yVals1);


                        } else {
                            String legendTitle = item.getString("value");
                            if(legendTitle.equals("거")){
                                legendTitle = "거세";
                            }
                            set1 = new BarDataSet(yVals1, legendTitle);

                            set1.setColor(CommonUtils.randomColor(getActivity(), i));

                            set1.setDrawValues(false);
                            dataSets.add(set1);
                        }

                    }

                    if (mChart.getData() != null &&
                            mChart.getData().getDataSetCount() > 0) {

                        mChart.getData().setXVals(xVals);

                        mChart.getData().notifyDataChanged();
                        mChart.notifyDataSetChanged();

                    } else {

                        BarData data = new BarData(xVals, dataSets);
//        data.setValueFormatter(new LargeValueFormatter());

                        // add space between the dataset groups in percent of bar-width
                        data.setGroupSpace(80f);
                        data.setValueTypeface(tf);

                        mChart.setData(data);

                    }

                    mChart.invalidate();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
