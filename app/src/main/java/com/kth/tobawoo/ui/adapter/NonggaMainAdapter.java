package com.kth.tobawoo.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kth.tobawoo.R;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.data.CommonResultType;
import com.kth.tobawoo.utils.Logger;

/**
 * Created by tommy on 2016-02-11.
 */
public class NonggaMainAdapter<T> extends SampleTableAdapter{

        Context mContext;
        private CommonResultType nonggaType;
        private float density;

        private final String headers[];

        private final int[] widths;

        OnTableItemClickListener onTableItemClick;

        public NonggaMainAdapter(Context context, String[] headers, int[] widths, CommonResultType nonggaType) {
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

            if(row>-1) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onTableItemClick.onListItemClicked(view, getDevice(row), row, column);
                    }
                });
            }
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

            Logger.log("column -> " + column);

            if((column >=5 && column <=8) || (column >=1 && column <=3)){
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

            if((column >=5 && column <=8) || (column >=1 && column <=3)){

                if(column == 6) {
                    tv2.setText("사육");
                    tv2.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
                }else if(column == 7) {
                    tv2.setText(" 두수");
                    tv2.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                }else if(column == 2) {
                    tv2.setText("지역");
                    tv2.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
                }else{
                    if(tv2!=null)
                        tv2.setText(null);
                }

                if(column == 7 || column==3){
                    convertView.findViewById(R.id.separator_line).setVisibility(View.VISIBLE);
                }else{
                    convertView.findViewById(R.id.separator_line).setVisibility(View.GONE);
                }
            }

            return convertView;
        }

        private View getFirstBody(int row, int column, View convertView, ViewGroup parent) {
            Logger.log("getFirstBody start ==========");
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_item_table_first, parent, false);
            }
            //Logger.log("getFirstBody : " + getDevice(row).data[column + 1]+ "," + row + "," + column);
            convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
            TextView tv1 = ((TextView) convertView.findViewById(R.id.text1));
            TextView tv2 = ((TextView) convertView.findViewById(R.id.text2));
            ImageButton ibtnEdit = (ImageButton) convertView.findViewById(R.id.ibtnEdit);
            tv1.setText(getCellString(row,column + 1));
            tv2.setText(getCellString(row,column + 2));
            ibtnEdit.setVisibility(View.GONE);

            tv1.setTextColor(mContext.getResources().getColor(R.color.DarkBlue));
            tv1.setPaintFlags(tv1.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
//            if(column + 2 < getDevice(row).data.length) {
//                ((TextView) convertView.findViewById(R.id.text2)).setText(getDevice(row).data[column + 2]);
//            }

            Logger.log("getFirstBody end ==========");

            return convertView;
        }

        private View getBody(int row, int column, View convertView, ViewGroup parent) {
            Logger.log("getBody start ==========");
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table, parent, false);
            }
            //Logger.log("getBody : " + getDevice(row).data[column + 1]);
            convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
//            if(column + 2 < getDevice(row).data.length) {
                ((TextView) convertView.findViewById(android.R.id.text1)).setText(getCellString(row,column+2));
//            }
            Logger.log("getBody end ==========");
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
            Logger.log("getCellString : " + row + " , " + column);
            String data = null;
            NonggaSearchResultData nonggaSearchResultData = getDevice(row);
            int arm_cnt = 0,su_cnt=0,gese_cnt=0;
            switch (column){
                case 0:
                    data = nonggaSearchResultData.getHouse_name();
                    break;
                case 1:
                    data = nonggaSearchResultData.getHouse_code();
                    break;
                case 2:
                    data = nonggaSearchResultData.getChukhyup_name();
                    break;
                case 3:
                    data = nonggaSearchResultData.getSido();
                    break;
                case 4:
                    data = nonggaSearchResultData.getArea1();
                    break;
                case 5:
                    data = nonggaSearchResultData.getArea2();
                    break;
                case 6:
                    data = nonggaSearchResultData.getBirth();
                    break;
                case 7:
                    int total = nonggaSearchResultData.getArm_cnt() + nonggaSearchResultData.getSu_cnt() + nonggaSearchResultData.getGese_cnt();
                    data = total+ "";
                    break;
                case 8:
                    arm_cnt = nonggaSearchResultData.getArm_cnt();
                    data = arm_cnt + "";
                    break;
                case 9:
                    su_cnt = nonggaSearchResultData.getSu_cnt();
                    data = su_cnt + "";
                    break;
                case 10:
                    gese_cnt = nonggaSearchResultData.getGese_cnt();
                    data = gese_cnt + "";
                    break;
                case 11:
                    data = nonggaSearchResultData.getMobile();
                    break;
                case 12:
                    data = nonggaSearchResultData.getPhone();
                    break;
                case 13:
                    data = nonggaSearchResultData.getZipcode();
                    break;
                case 14:
                    data = nonggaSearchResultData.getHouse_addr1();
                    break;
                case 15:
                    data = nonggaSearchResultData.getHouse_addr2();
                    break;
                case 16:
                    data = nonggaSearchResultData.getFax();
                    break;
                case 17:
                    data = nonggaSearchResultData.getEmail();
                    break;
                case 18:
                    data = nonggaSearchResultData.getZipcode();
                    break;
                case 19:
                    data = nonggaSearchResultData.getFarm_addr1();
                    break;
                case 20:
                    data = nonggaSearchResultData.getFarm_addr2();
                    break;
                default:
                    data = "";
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

        private NonggaSearchResultData getDevice(int row) {
            if(row<0)
                return new NonggaSearchResultData();

            return (NonggaSearchResultData) nonggaType.get(row);
        }

        @Override
        public int getViewTypeCount() {
            return 5;
        }

}
