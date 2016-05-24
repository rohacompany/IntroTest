package com.kth.tobawoo.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.utils.Logger;

/**
 * Created by tommy on 2016-02-11.
 */
public class NonggaMainAdapter<T> extends SampleTableAdapter{

        Context mContext;
        private NonggaType nonggaType;
        private float density;

        private final String headers[];

        private final int[] widths;

        OnTableItemClickListener onTableItemClick;




        public NonggaMainAdapter(Context context, String[] headers, int[] widths, NonggaType nonggaType) {
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
        public View getView(final int row, int column, final View convertView, final ViewGroup parent) {
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
                    onTableItemClick.onListItemClicked(view, row);
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

            //Logger.log("getHeader : " + headers[column + 1]);

            if((column >=4 && column <=7) || (column >=1 && column <=2)){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header_w_two_rows, parent, false);
                Logger.log("column value -> " + headers[column + 2]);
                tv2 = (TextView) convertView.findViewById(android.R.id.text2);
            }else{
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header, parent, false);
            }

            tv1 = (TextView) convertView.findViewById(android.R.id.text1);


            if(column+2 < headers.length) {
                tv1.setText(headers[column + 2]);
                //Logger.log("랜더링 된 컬럼 : " + column + "," + headers[column + 2]);
            }

            if((column >=4 && column <=7) || (column >=1 && column <=2)){

                if(column == 5) {
                    tv2.setText("사육");
                    tv2.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
                }else if(column == 6) {
                    tv2.setText(" 두수");
                    tv2.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                }else if(column == 1) {
                        tv2.setText("지");
                        tv2.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                }else if(column == 2) {
                    tv2.setText("역");
                    tv2.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                }else{
                    tv2.setText(null);
                }

                if(column == 7 || column==2){
                    convertView.findViewById(R.id.separator_line).setVisibility(View.VISIBLE);
                }else{
                    convertView.findViewById(R.id.separator_line).setVisibility(View.GONE);
                }
            }

            return convertView;
        }

        private View getFirstBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_item_table_first, parent, false);
            }
            //Logger.log("getFirstBody : " + getDevice(row).data[column + 1]+ "," + row + "," + column);
            convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
            ((TextView) convertView.findViewById(R.id.text1)).setText(getDevice(row).data[column + 1]);
            if(column + 2 < getDevice(row).data.length) {
                ((TextView) convertView.findViewById(R.id.text2)).setText(getDevice(row).data[column + 2]);
            }

            return convertView;
        }

        private View getBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table, parent, false);
            }
            //Logger.log("getBody : " + getDevice(row).data[column + 1]);
            convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
            if(column + 2 < getDevice(row).data.length) {
                ((TextView) convertView.findViewById(android.R.id.text1)).setText(getDevice(row).data[column + 2]);
            }
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
            return getDevice(row).data[column + 1];
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

        private NonggaData getDevice(int row) {

            return nonggaType.get(row);
        }

        @Override
        public int getViewTypeCount() {
            return 5;
        }

}
