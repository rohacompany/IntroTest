package com.tobawoo.nh2016.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.data.CommonTableData;
import com.tobawoo.nh2016.data.GasanggyobaeResultData;
import com.tobawoo.nh2016.common.Logger;

import java.util.List;

/**
 * Created by tommy on 2016-02-11.
 */
public class GasangGyobaeMainAdapter<T> extends SampleTableAdapter{

        Context mContext;
        private CommonResultType nonggaType;
        private float density;

        OnTableItemClickListener onTableItemClick;

        List<CommonTableData> mTabList;

        public GasangGyobaeMainAdapter(Context context, List<CommonTableData> tabList, CommonResultType nonggaType) {
            super(context);
            this.mContext = context;

            this.mTabList = tabList;

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
            return mTabList.size() - 2;
        }

        @Override
        public int getWidth(int column) {
            return Math.round(mTabList.get(column+2).getWidth() * density);
        }

        public String getHeader(int pos){
            return mTabList.get(pos).getTitle();
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
            ((TextView) convertView.findViewById(R.id.text1)).setText( getHeader(0));
            ((TextView) convertView.findViewById(R.id.text2)).setText( getHeader(1));

            return convertView;
        }

        private View getHeader(int row, int column, View convertView, ViewGroup parent) {
            TextView tv1 = null;
            TextView tv2 = null;

            Logger.log("column -> " + column);

            if(column >=2 && column <=5){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header_w_two_rows, parent, false);

                tv2 = (TextView) convertView.findViewById(android.R.id.text2);
            }else{
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table_header, parent, false);
            }

            tv1 = (TextView) convertView.findViewById(android.R.id.text1);


            if(column+2 < mTabList.size()) {
                tv1.setText(getHeader(column + 2));
                //Logger.log("랜더링 된 컬럼 : " + column + "," + headers[column + 2]);
            }

            if(column >=2 && column <=5){

                if(column == 3) {
                    tv2.setText("가상송아지");
                    tv2.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
                }else if(column == 4) {
                    tv2.setText(" 유전능력(EPD)");
                    tv2.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                }else{
                    if(tv2!=null)
                        tv2.setText(null);
                }

                if(column == 5){
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

            return convertView;
        }

        private View getBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_table, parent, false);
            }
            //Logger.log("getBody : " + getDevice(row).data[column + 1]);
            convertView.setBackgroundResource(row % 2 == 0 ? R.drawable.bg_table_color1 : R.drawable.bg_table_color2);
//            if(column + 2 < getDevice(row).data.length) {
            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(getCellString(row,column+2));
            tv.setGravity(mTabList.get(column+2).getGravity());
//            }
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
            String data = null;
            GasanggyobaeResultData gasanggyobaeResultData = getDevice(row);
            switch (column){
                case 0:
                    data = gasanggyobaeResultData.getMengho();
                    break;
                case 1:
                    data = gasanggyobaeResultData.getKpn_no();
                    break;
                case 2:
                    data = gasanggyobaeResultData.getGeungyogyesu();
                    break;
                case 3:
                    data = gasanggyobaeResultData.getGeungyogyesu_level();
                    break;
                case 4:
                    data = gasanggyobaeResultData.getDo_weight();
                    break;
                case 5:
                    data = gasanggyobaeResultData.getDeungsimdanmyeonjeok();
                    break;
                case 6:
                    data = gasanggyobaeResultData.getDeungjibangdukke();
                    break;
                case 7:
                    data = gasanggyobaeResultData.getGeunnaejibangdo();
                    break;
                case 8:
                    data = gasanggyobaeResultData.getSunbaljisu();
                    break;
                case 9:
                    data = gasanggyobaeResultData.getRank();
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

        private GasanggyobaeResultData getDevice(int row) {
            if(row<0)
                return new GasanggyobaeResultData();

            return (GasanggyobaeResultData) nonggaType.get(row);
        }

        @Override
        public int getViewTypeCount() {
            return 5;
        }

}
