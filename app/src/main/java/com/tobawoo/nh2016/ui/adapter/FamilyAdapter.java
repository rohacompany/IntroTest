package com.tobawoo.nh2016.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NonggaData;
import com.tobawoo.nh2016.data.NonggaType;
import com.tobawoo.nh2016.fixedtablelayout.adapters.BaseTableAdapter;
import com.tobawoo.nh2016.common.Logger;

/**
 * Created by tommy on 2016-01-12.
 */
public class FamilyAdapter extends BaseTableAdapter {

    Context mContext;
    private final NonggaType familys[];
    private final String headers[] = {
            "No",
            "지역(축협)",
            "농가아이디",
            "농가코드",
            "축주명",
            "농가형태",
            "농가상태",
            "두수",
            "방역명",
            "방역자",
            "방역일시",
            "방역자수",
    };

    private final int[] widths = {
            60,
            100,
            140,
            60,
            70,
            60,
            60,
            60,
            70,
            60,
            60,
            60,
    };
    private final float density;

    public FamilyAdapter(Context context) {
        this.mContext = context;

        familys = new NonggaType[]{
                new NonggaType("Mobiles"),
                new NonggaType("Tablets"),
                new NonggaType("Others"),
        };

        density = context.getResources().getDisplayMetrics().density;

//        familys[0].list.add(new NonggaData("Nexus One", "HTC", "Gingerbread", "10", "512 MB", "3.7\"", "512 MB" ,"test1" , "test2" , "test3" , "test4" , "test5"));
//        familys[0].list.add(new NonggaData("Nexus S", "Samsung", "Gingerbread", "10", "16 GB", "4\"", "512 MB" ,"test1" , "test2" , "test3" , "test4" , "test5"));
//        familys[0].list.add(new NonggaData("Galaxy Nexus (16 GB)", "Samsung", "Ice cream Sandwich", "15", "16 GB", "4.65\"", "1 GB" ,"test1" , "test2" , "test3" , "test4" , "test5"));
//        familys[0].list.add(new NonggaData("Galaxy Nexus (32 GB)", "Samsung", "Ice cream Sandwich", "15", "32 GB", "4.65\"", "1 GB" ,"test1" , "test2" , "test3" , "test4" , "test5"));
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount() {
        return headers.length - 1;
    }

    @Override
    public View getView(int row, int column, View convertView, ViewGroup parent) {
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
            case 4:
                view = getFamilyView(row, column, convertView, parent);
                break;
            default:
                throw new RuntimeException("wtf?");
        }
        return view;
    }

    private View getFirstHeader(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header_first, parent, false);
        }
        Logger.log("getFirstHeader : " + headers[0]);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[0]);
        return convertView;
    }

    private View getHeader(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header, parent, false);
        }
        Logger.log("getHeader : " + headers[column + 1]);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[column + 1]);
        return convertView;
    }

    private View getFirstBody(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_first, parent, false);
        }
        Logger.log("getFirstBody : " + getDevice(row).data[column + 1]);
        convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(getDevice(row).data[column + 1]);
        return convertView;
    }

    private View getBody(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table, parent, false);
        }
        Logger.log("getBody : " + getDevice(row).data[column + 1]);
        convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(getDevice(row).data[column + 1]);
        return convertView;
    }

    private View getFamilyView(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_family, parent, false);
        }
        final String string;
        if (column == -1) {
            string = getFamily(row).name;
        } else {
            string = "";
        }
        Logger.log("getFamilyView : " + string);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(string);
        return convertView;
    }

    @Override
    public int getWidth(int column) {
        return Math.round(widths[column + 1] * density);
    }

    @Override
    public int getHeight(int row) {
        final int height;
        if (row == -1) {
            height = 35;
        } else if (isFamily(row)) {
            height = 25;
        } else {
            height = 45;
        }
        return Math.round(height * density);
    }

    @Override
    public int getItemViewType(int row, int column) {
        final int itemViewType;
        if (row == -1 && column == -1) {
            itemViewType = 0;
        } else if (row == -1) {
            itemViewType = 1;
        } else if (isFamily(row)) {
            itemViewType = 4;
        } else if (column == -1) {
            itemViewType = 2;
        } else {
            itemViewType = 3;
        }
        return itemViewType;
    }

    private boolean isFamily(int row) {
        int family = 0;
        while (row > 0) {
            row -= familys[family].size() + 1;
            family++;
        }
        return row == 0;
    }

    private NonggaType getFamily(int row) {
        int family = 0;
        while (row >= 0) {
            row -= familys[family].size() + 1;
            family++;
        }
        return familys[family - 1];
    }

    private NonggaData getDevice(int row) {
        int family = 0;
        while (row >= 0) {
            row -= familys[family].size() + 1;
            family++;
        }
        family--;
        return familys[family].get(row + familys[family].size());
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

}
