package com.tobawoo.nh2016.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NonggaData;
import com.tobawoo.nh2016.data.NonggaType;

/**
 * Created by tommy on 2016-02-11.
 */
public class BangyeokAdapter<T> extends SampleTableAdapter{

        Context mContext;
        private NonggaType nonggaType;
        private float density;

        private final String headers[];

        private final int[] widths;

        OnTableItemClick onTableItemClick;

        public interface OnTableItemClick{
            public void onListItemClicked(View view, int position);
        }


        public BangyeokAdapter(Context context, String[] headers, int[] widths, NonggaType nonggaType) {
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

        public void setOnTableItemClick(OnTableItemClick itemClick){
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
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header, parent, false);
            }
            //Logger.log("getHeader : " + headers[column + 1]);
            if(column+2 < headers.length) {
                ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[column + 2]);
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
                height = 35;
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
