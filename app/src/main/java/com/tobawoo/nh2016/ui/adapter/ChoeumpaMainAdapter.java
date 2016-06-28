package com.tobawoo.nh2016.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.ChoeumpaResultData;
import com.tobawoo.nh2016.data.CommonResultType;

/**
 * Created by tommy on 2016-02-11.
 */
public class ChoeumpaMainAdapter<T> extends SampleTableAdapter{

    Context mContext;
    private CommonResultType nonggaType;
    private float density;

    private final String headers[];

    private final int[] widths;

    OnTableItemClickListener onTableItemClick;

    public ChoeumpaMainAdapter(Context context, String[] headers, int[] widths, CommonResultType nonggaType) {
        super(context);
        this.mContext = context;

        this.headers = headers;
        this.widths = widths;

        this.nonggaType = nonggaType;

        Resources resources = context.getResources();

        density = context.getResources().getDisplayMetrics().density;

//        for(NonggaData data : nonggaType.list){
//            Logger.log("NonggaData content : " + data.toString());
//        }

    }

    public void setOnTableItemClick(OnTableItemClickListener itemClick){
        this.onTableItemClick = itemClick;
    }

    @Override
    public int getRowCount() {
        return nonggaType.list.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length - 2;
    }

    @Override
    public int getWidth(int column) {
        return Math.round(widths[column + 1] * density);
    }

    @Override
    public View getView(final int row, final int column, final View convertView, final ViewGroup parent) {
        //Logger.log("getView -> " + getItemViewType(row, column));
        final View view;
        switch (getItemViewType(row, column)) {
            case 0:
                view = getFirstHeader(row, column, convertView, parent);
                break;
            case 1:
                view = getHeader(row, column, convertView, parent);
                break;
            case 2:
                view = getFirstBody(row, column, convertView, parent);
                break;
            case 3:
                view = getBody(row, column, convertView, parent);
                break;
            default:
                throw new RuntimeException("wtf?");
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTableItemClick.onListItemClicked(view ,  getDevice(row), row , column);
            }
        });
        return view;
    }

    private View getFirstHeader(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_item_table_header_first, parent, false);
        }
        //Logger.log("getFirstHeader : " + headers[0]);
        ((TextView) convertView.findViewById(R.id.text1)).setText(headers[0]);
        ((TextView) convertView.findViewById(R.id.text2)).setText(headers[1]);

        return convertView;
    }

    private View getHeader(int row, int column, View convertView, ViewGroup parent) {
        TextView tv1 = null;
        TextView tv2 = null;

        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header, parent, false);

        tv1 = (TextView) convertView.findViewById(android.R.id.text1);

        if(column+2 < headers.length) {
            tv1.setText(headers[column + 2]);
            //Logger.log("랜더링 된 컬럼 : " + column + "," + headers[column + 2]);
        }

        return convertView;
    }

    private View getFirstBody(int row, int column, View convertView, ViewGroup parent) {
//        Logger.log("getFirstBody start ==========");
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_item_table_first, parent, false);
        }
        //Logger.log("getFirstBody : " + getDevice(row).data[column + 1]+ "," + row + "," + column);
        convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
        TextView tv1 = ((TextView) convertView.findViewById(R.id.text1));
        TextView tv2 = ((TextView) convertView.findViewById(R.id.text2));
        tv1.setText(getCellString(row,column + 1));
        tv2.setText(getCellString(row,column + 2));

//        tv1.setTextColor(mContext.getResources().getColor(R.color.DarkBlue));
//        tv1.setPaintFlags(tv1.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
//            if(column + 2 < getDevice(row).data.length) {
//                ((TextView) convertView.findViewById(R.id.text2)).setText(getDevice(row).data[column + 2]);
//            }

//        Logger.log("getFirstBody end ==========");

        return convertView;
    }

    private View getBody(int row, int column, View convertView, ViewGroup parent) {
//        Logger.log("getBody start ==========");
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table, parent, false);
        }
        //Logger.log("getBody : " + getDevice(row).data[column + 1]);
        convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
//            if(column + 2 < getDevice(row).data.length) {
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(getCellString(row,column+2));
//            }
//        Logger.log("getBody end ==========");
        return convertView;
    }

    @Override
    public int getHeight(int row) {
        final int height;
        if (row == -1) {
            height = 70;
        } else {
            height = 45;
        }
        return Math.round(height * density);
    }

    @Override
    public String getCellString(int row, int column) {
//        Logger.log("getCellString : " + row + " , " + column);
        String data = "";
        ChoeumpaResultData resultData = getDevice(row);
        switch (column){
            case 0:
                data = resultData.getBarcode();
                break;
            case 1:
                data = resultData.getHouse_name();
                break;
            case 2:
                data = resultData.getChukhyup_name();
                break;
            case 3:
                data = resultData.getEnterprise_organization_name();
                break;
            case 4:
                data = resultData.getDecipher_yn();
                break;
            case 5:
                data = resultData.getMonth();
                break;
            case 6:
                data = resultData.getSex();
                break;
            case 7:
                data = resultData.getWeight();
                break;
            case 8:
                data = resultData.getBirth();
                break;
            case 9:
                data = resultData.getBirth_log();
                break;
            case 10:
                data = resultData.getMeasurement_dt();
                break;
            case 11:
                data = resultData.getDecipher_dt();
                break;
            case 12:
                data = resultData.getRed_dt();
                break;
            case 13:
                data = resultData.getMeasurement_charge_name();
                break;
            case 14:
                data = resultData.getEtc01();
                break;
            case 15:
                data = resultData.getEtc02();
                break;
            case 16:
                data = resultData.getEtc03();
                break;
            case 17:
                data = resultData.getEtc04();
                break;
            case 18:
                data = resultData.getEtc05();
                break;

        }
        return data;
    }

    @Override
    public int getLayoutResource(int row, int column) {
        final int layoutResource;
        switch (getItemViewType(row, column)) {
            case 0:
                layoutResource = R.layout.item_table1_header;
                break;
            case 1:
                layoutResource = R.layout.item_table1;
                break;
            default:
                throw new RuntimeException("wtf?");
        }
        return layoutResource;
    }

    @Override
    public int getItemViewType(int row, int column) {
        final int itemViewType;
        if (row == -1 && column == -1) {
            itemViewType = 0;
        } else if (row == -1) {
            itemViewType = 1;
        } else if (column == -1) {
            itemViewType = 2;
        } else {
            itemViewType = 3;
        }
        return itemViewType;
    }

    private ChoeumpaResultData getDevice(int row) {

        return (ChoeumpaResultData) nonggaType.get(row);
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

}
