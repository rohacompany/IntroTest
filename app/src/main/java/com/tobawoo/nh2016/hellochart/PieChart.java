package com.tobawoo.nh2016.hellochart;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * Created by tommy on 2016-01-15.
 */
public class PieChart implements PieChartOnValueSelectListener {

    Context mContext;

    private PieChartView mPieChartView;
    private PieChartData mPieChartData;

    private boolean hasLabels = false;
    private boolean hasLabelsOutside = false;
    private boolean hasCenterCircle = false;
    private boolean hasCenterText1 = false;
    private boolean hasCenterText2 = false;
    private boolean isExploded = false;
    private boolean hasLabelForSelected = false;

    public PieChart(Context context, PieChartView view){

        this.mContext = context;

        this.mPieChartView = view;

        mPieChartView.setOnValueTouchListener(this);

        generateData();

    }

    private void reset() {
        mPieChartView.setCircleFillRatio(1.0f);
        hasLabels = false;
        hasLabelsOutside = false;
        hasCenterCircle = false;
        hasCenterText1 = false;
        hasCenterText2 = false;
        isExploded = false;
        hasLabelForSelected = false;
    }

    private void generateData() {
        int numValues = 6;

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15, ChartUtils.pickColor());
            values.add(sliceValue);
        }

        mPieChartData = new PieChartData(values);
        mPieChartData.setHasLabels(hasLabels);
        mPieChartData.setHasLabelsOnlyForSelected(hasLabelForSelected);
        mPieChartData.setHasLabelsOutside(hasLabelsOutside);
        mPieChartData.setHasCenterCircle(hasCenterCircle);

        if (isExploded) {
            mPieChartData.setSlicesSpacing(24);
        }

        if (hasCenterText1) {
            mPieChartData.setCenterText1("Hello!");

//            // Get roboto-italic font.
//            Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "Roboto-Italic.ttf");
//            mPieChartData.setCenterText1Typeface(tf);

//            // Get font size from dimens.xml and convert it to sp(library uses sp values).
//            mPieChartData.setCenterText1FontSize(ChartUtils.px2sp(mContext.getResources().getDisplayMetrics().scaledDensity,
//                    (int) mContext.getResources().getDimension(R.dimen.pie_chart_text1_size)));
        }

        if (hasCenterText2) {
            mPieChartData.setCenterText2("Charts (Roboto Italic)");

//            Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "Roboto-Italic.ttf");

//            mPieChartData.setCenterText2Typeface(tf);
//            mPieChartData.setCenterText2FontSize(ChartUtils.px2sp(mContext.getResources().getDisplayMetrics().scaledDensity,
//                    (int) mContext.getResources().getDimension(R.dimen.pie_chart_text2_size)));
        }

        mPieChartView.setPieChartData(mPieChartData);
    }

    private void explodeChart() {
        isExploded = !isExploded;
        generateData();

    }

    private void toggleLabelsOutside() {
        // has labels have to be true:P
        hasLabelsOutside = !hasLabelsOutside;
        if (hasLabelsOutside) {
            hasLabels = true;
            hasLabelForSelected = false;
            mPieChartView.setValueSelectionEnabled(hasLabelForSelected);
        }

        if (hasLabelsOutside) {
            mPieChartView.setCircleFillRatio(0.7f);
        } else {
            mPieChartView.setCircleFillRatio(1.0f);
        }

        generateData();

    }

    private void toggleLabels() {
        hasLabels = !hasLabels;

        if (hasLabels) {
            hasLabelForSelected = false;
            mPieChartView.setValueSelectionEnabled(hasLabelForSelected);

            if (hasLabelsOutside) {
                mPieChartView.setCircleFillRatio(0.7f);
            } else {
                mPieChartView.setCircleFillRatio(1.0f);
            }
        }

        generateData();
    }

    private void toggleLabelForSelected() {
        hasLabelForSelected = !hasLabelForSelected;

        mPieChartView.setValueSelectionEnabled(hasLabelForSelected);

        if (hasLabelForSelected) {
            hasLabels = false;
            hasLabelsOutside = false;

            if (hasLabelsOutside) {
                mPieChartView.setCircleFillRatio(0.7f);
            } else {
                mPieChartView.setCircleFillRatio(1.0f);
            }
        }

        generateData();
    }

    private void prepareDataAnimation() {
        for (SliceValue value : mPieChartData.getValues()) {
            value.setTarget((float) Math.random() * 30 + 15);
        }
    }


    @Override
    public void onValueDeselected() {

    }

    @Override
    public void onValueSelected(int i, SliceValue sliceValue) {
        Toast.makeText(mContext, "Selected: " + sliceValue, Toast.LENGTH_SHORT).show();
    }
}
