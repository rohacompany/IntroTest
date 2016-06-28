package com.tobawoo.nh2016.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.CommonInter;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.data.CommonTableData;
import com.tobawoo.nh2016.data.GaechSearchResultData;
import com.tobawoo.nh2016.data.GaecheData;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.adapter.GachejeongboMainAdapter;
import com.tobawoo.nh2016.ui.adapter.OnTableItemClickListener;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.ui.fragment.main.common.CommonFragDatas;
import com.tobawoo.nh2016.ui.popup.ActionItem;
import com.tobawoo.nh2016.ui.popup.QuickAction;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GaecheSearchActivity extends SubBaseActivity implements OnTableItemClickListener {

    CommonResultType nt = null;

    AQuery aq;

    private GaecheData gaecheData;
    private String searchHouseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        nt = new CommonResultType();

        gaecheData = (GaecheData) getIntent().getExtras().getSerializable("data");
        searchHouseCode = getIntent().getStringExtra("search_house_code");
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


        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final GachejeongboMainAdapter<String> matrixTableAdapter = new GachejeongboMainAdapter<String>(this, CommonFragDatas.getGaecheHeaderList() , nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        HashMap<String, String> paramMap = null;
        if(CommonUtils.isNull(searchHouseCode)) {
             paramMap = gaecheData.getParamMap();
        }else{
            paramMap = new HashMap<String,String>();
            paramMap.put("search_house_code" , searchHouseCode);
        }

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_GAECHE_LIST , paramMap , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
//                Logger.log("개체검색 : " + object);
                if(object!=null){
//                    Logger.log("개체검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        String sql = URLDecoder.decode(object.getString("sql"));
                        Logger.log("sql : " + sql);
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            GaechSearchResultData nrd = gson.fromJson(item.toString() , GaechSearchResultData.class);
                            nt.list.add(nrd);
//                            Logger.log(i + " 번째 데이터 : " + nrd.toString());
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

        final GaechSearchResultData gaechSearchResultData = (GaechSearchResultData) commonInter;


//       view.setBackgroundColor(getResources().getColor(R.color.DarkGray));

        ActionItem itemDetail 		= new ActionItem(CommonUtils.ID_VIEW_DETAIL, "상세보기", getResources().getDrawable(R.drawable.ic_action_full_screen));
        ActionItem itemSearchGaeche 		= new ActionItem(CommonUtils.ID_VIEW_SEARCH_GAECHE, "검색하기", getResources().getDrawable(R.drawable.ic_action_search));
        ActionItem itemModify 	= new ActionItem(CommonUtils.ID_VIEW_MODIFY, "수정하기", getResources().getDrawable(R.drawable.ic_action_edit));
        ActionItem itemDelete 	= new ActionItem(CommonUtils.ID_VIEW_DELETE, "삭제하기", getResources().getDrawable(R.drawable.ic_action_remove_light));

        //use setSticky(true) to disable QuickAction dialog being dismissed after an item is clicked

        itemSearchGaeche.setSticky(true);

        final QuickAction mQuickAction 	= new QuickAction(this);

        mQuickAction.addActionItem(itemDetail);
        mQuickAction.addActionItem(itemSearchGaeche);
        mQuickAction.addActionItem(itemModify);
        mQuickAction.addActionItem(itemDelete);

        //setup the action item click listener

        mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
            @Override
            public void onItemClick(QuickAction quickAction, int pos, int actionId) {
                ActionItem actionItem = quickAction.getActionItem(pos);
                Intent intent = null;
                Bundle bundle = new Bundle();
                bundle.putSerializable("data" , gaechSearchResultData);
                switch (actionId){
                    case  CommonUtils.ID_VIEW_SEARCH_GAECHE:
                        intent = new Intent(GaecheSearchActivity.this , GaecheDetailTabAllActivity.class);
                        intent.putExtra("search_barcode" , gaechSearchResultData.getBarcode());
                        startActivity(intent);
                        break;
                    case CommonUtils.ID_VIEW_DETAIL:
                        intent = new Intent(GaecheSearchActivity.this , GaecheDetailActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in , android.R.anim.fade_out);
                        break;
                }

            }
        });

        mQuickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(getApplicationContext(), "Ups..dismissed", Toast.LENGTH_SHORT).show();
//                view.setBackgroundResource(getResources().getColor(R.color.transparent));
            }
        });

        mQuickAction.show(view);
        mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);

    }
}
