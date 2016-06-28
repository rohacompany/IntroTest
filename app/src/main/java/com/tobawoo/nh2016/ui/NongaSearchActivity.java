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
import com.tobawoo.nh2016.data.CommonTableData;
import com.tobawoo.nh2016.data.NonggaData;
import com.tobawoo.nh2016.data.NonggaSearchResultData;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.adapter.NonggaMainAdapter;
import com.tobawoo.nh2016.ui.adapter.OnTableItemClickListener;
import com.tobawoo.nh2016.common.URLManager;
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
import java.util.Map;

public class NongaSearchActivity extends SubBaseActivity implements OnTableItemClickListener{

    CommonResultType nt = new CommonResultType();

    AQuery aq;

    List<NonggaSearchResultData> mList;

    NonggaData nonggaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        nonggaData = (NonggaData) getIntent().getExtras().getSerializable("data");

        mList = new ArrayList<NonggaSearchResultData>();

        aq = new AQuery(this);

        aq.id(R.id.table_result_search_title).text("농가관리 결과 조회");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("농가관리결과조회");

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
        setResult(RESULT_CANCELED);
        finish();
    }

    public void setTableLayout() {


        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("농가명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가(목장)\n번호",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("축협명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("시군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("읍면",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("동",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생년월일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("전체", Gravity.CENTER_VERTICAL|Gravity.RIGHT,50));
        tabDataList.add(new CommonTableData("암",Gravity.CENTER_VERTICAL|Gravity.RIGHT,50));
        tabDataList.add(new CommonTableData("수",Gravity.CENTER_VERTICAL|Gravity.RIGHT,50));
        tabDataList.add(new CommonTableData("거세",Gravity.CENTER_VERTICAL|Gravity.RIGHT,50));
        tabDataList.add(new CommonTableData("휴대폰",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("전화번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("우편번호",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가기본주소",Gravity.CENTER_VERTICAL|Gravity.LEFT,200));
        tabDataList.add(new CommonTableData("농가상세주소",Gravity.CENTER_VERTICAL|Gravity.LEFT,200));
        tabDataList.add(new CommonTableData("팩스번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("이메일",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("우편번호",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("목장기본주소",Gravity.CENTER_VERTICAL|Gravity.LEFT,200));
        tabDataList.add(new CommonTableData("목장상세주소",Gravity.CENTER_VERTICAL|Gravity.LEFT,200));


        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final NonggaMainAdapter<String> matrixTableAdapter = new NonggaMainAdapter<String>(this, tabDataList, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        HashMap<String,String> paramMap = nonggaData.getParamMap();

        for(Map.Entry<String,String> entry : paramMap.entrySet()){
            Logger.log("파라미터 : " + entry.getKey() + " : " + entry.getValue());
        }


        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_NONGA_LIST , nonggaData.getParamMap(),  JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){
                    Logger.log("농가검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        String sql = object.getString("sql");
                        Logger.log("3200 sql -> " + URLDecoder.decode(sql));

                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            NonggaSearchResultData nrd = gson.fromJson(item.toString() , NonggaSearchResultData.class);
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
                }
            }
        });

    }



    @Override
    public void onListItemClicked(final View view,CommonInter commonInter, int row , int column) {
        Logger.log("onListItemClicked ok!! : " + row + "," + column + "," + ((NonggaSearchResultData)commonInter).toString());

        final NonggaSearchResultData nonggaSearchResultData = (NonggaSearchResultData)commonInter;

//        if(column >= 0) {//앞에 제목컬럼이 아닐경우
//            Intent intent = new Intent(this , GaecheSearchActivity.class);
//            intent.putExtra("house_code" , nonggaSearchResultData.getHouse_code());
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        }else{
//            Intent intent = new Intent(this , Example1Activity.class);
//            startActivity(intent);
//        }

//       view.setBackgroundColor(getResources().getColor(R.color.DarkGray));

        ActionItem itemDetail 		= new ActionItem(CommonUtils.ID_VIEW_DETAIL, "상세보기", getResources().getDrawable(R.drawable.ic_action_full_screen));
        ActionItem itemSearchGaeche 		= new ActionItem(CommonUtils.ID_VIEW_SEARCH_GAECHE, "개체검색", getResources().getDrawable(R.drawable.ic_action_search));
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
                switch (actionId){
                    case  CommonUtils.ID_VIEW_SEARCH_GAECHE:
                        intent = new Intent(NongaSearchActivity.this , GaecheSearchActivity.class);
                        intent.putExtra("search_house_code" , nonggaSearchResultData.getHouse_code());
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case CommonUtils.ID_VIEW_DETAIL:
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data" , nonggaSearchResultData);
                        intent = new Intent(NongaSearchActivity.this , NongaDetailActivity.class);
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
