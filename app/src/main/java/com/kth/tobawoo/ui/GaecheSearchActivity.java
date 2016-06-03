package com.kth.tobawoo.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.data.NonggaType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.GachejeongboMainAdapter;
import com.kth.tobawoo.ui.adapter.NonggaMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.ui.common.URLManager;
import com.kth.tobawoo.utils.CommonUtils;
import com.kth.tobawoo.utils.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GaecheSearchActivity extends SubBaseActivity implements OnTableItemClickListener {

    CommonResultType nt = null;

    AQuery aq;

    private String selectedHouseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        nt = new CommonResultType();

        selectedHouseCode = getIntent().getStringExtra("house_code");

        aq = new AQuery(this);

        aq.id(R.id.table_result_search_title).text("개체관리 결과 조회");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("개체 결과 관리 조회");

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
                "읍면",
                "동",
                "농가코드",
                "성별",
                "생년월일",
                "월령",
                "등록구분",
                "개체상태",
                "마지막종부일",
                "마지막분만일",
                "마지막산차",
                "계대",
                "어미귀표번호",
                "어미혈통",
                "씨수소",
                "외조부",
                "외증조부",
                "개체구분",
                "개체관리번호",
                "목장주소"
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
                100,
                150,
                100,
                150,
                150,
                100,
                100,
                200,
                300,
                400
        };

        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final GachejeongboMainAdapter<String> matrixTableAdapter = new GachejeongboMainAdapter<String>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        Logger.log("2100 selectedHouseCode -> " + selectedHouseCode);

        HashMap<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("house_code" , selectedHouseCode);
        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_GAECHE_LIST , paramMap , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
//                Logger.log("개체검색 : " + object);
                if(object!=null){
                    Logger.log("개체검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        String sql = object.getString("sql");
                        Logger.log("sql : " + sql);
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            GaechSearchResultData nrd = gson.fromJson(item.toString() , GaechSearchResultData.class);
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
    public void onListItemClicked(View view , CommonInter commonInter, int row, int column) {

    }
}
