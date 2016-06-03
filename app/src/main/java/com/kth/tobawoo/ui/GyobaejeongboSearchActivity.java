package com.kth.tobawoo.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.CommonInter;
import com.kth.tobawoo.data.CommonResultType;
import com.kth.tobawoo.data.GaechSearchResultData;
import com.kth.tobawoo.data.GyobaejeongboResultData;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.GachejeongboMainAdapter;
import com.kth.tobawoo.ui.adapter.GyobaejeongboMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.ui.common.URLManager;
import com.kth.tobawoo.utils.CommonUtils;
import com.kth.tobawoo.utils.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GyobaejeongboSearchActivity extends SubBaseActivity implements OnTableItemClickListener {

    CommonResultType nt = null;

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        nt = new CommonResultType();

        aq = new AQuery(this);

        aq.id(R.id.table_result_search_title).text("교배 정보 결과 조회");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("교배 정보 결과 관리 조회");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setTableLayout();

        aq.find(R.id.btn_close).clicked(this , "closeActivity");
    }

    public void closeActivity(){
        finish();
    }

    public void setTableLayout() {
        String[] mainHeaders = new String[]{
                "귀표번호",
                "농가명",
                "축협",
                "시군",
                "구군",
                "읍면동",
                "등록구분",
                "산차",
                "생년월일",
                "월령",
                "교배일자",
                "씨수소",
                "교배일자",
                "씨수소",
                "교배일자",
                "씨수소",
                "분만예정일자",
                "분만일자",
                "인공수정사",
                "개체관리번호",
                "목장주소",
                "목장전화번호",
                "핸드폰번호"
        };
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                150,
                100,
                150,
                150,
                200,
                200,
                200,
                200,
                400
        };

        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final GyobaejeongboMainAdapter<String> matrixTableAdapter = new GyobaejeongboMainAdapter<>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_GYOBAEJEONGBO_LIST, JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                Logger.log("개체검색 : " + object);
                if(object!=null){
                    Logger.log("개체검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            GyobaejeongboResultData nrd = gson.fromJson(item.toString() , GyobaejeongboResultData.class);
                            nt.list.add(nrd);
                            Logger.log(i + " 번째 데이터 : " + nrd.toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {

                        aq.id(R.id.table_result_search_title2).text("( 총 "+nt.list.size()+"건 )");
                        matrixTableAdapter.notifyDataSetChanged();

                        tableFixHeaders.scrollTo(0, 0);
                    }
                }else{
                    Logger.log("개체 검색 결과 : null");
                }
            }
        });


    }

//    @Override
//    public void onListItemClicked(View view, int position) {
//        Logger.log("onListItemClicked ok!! : " + position);
//
//        NonggaData nonggaData = nt.list.get(position);
//
//        NonggaSearchResultData data = new NonggaSearchResultData();
////        data.setNo(100);
////        data.setNongga_id("12312");
////        data.setChukju_name("축주이름");
//
////        Intent intent = new Intent();
////        Bundle bundle = new Bundle();
////        bundle.putSerializable("data", data);
////        intent.putExtras(bundle);
////        intent.putExtra("name" , "test");
//
//        myApplication.setNonggaSearchResultData(data);
//
//        setResult(RESULT_OK);
//        finish();
//
//
//    }

    @Override
    public void onListItemClicked(View view,CommonInter commonInter, int row, int column) {

    }
}
