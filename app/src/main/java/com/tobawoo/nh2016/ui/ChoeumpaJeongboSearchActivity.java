package com.tobawoo.nh2016.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.BunmanjeongboResultData;
import com.tobawoo.nh2016.data.ChoeumpaData;
import com.tobawoo.nh2016.data.ChoeumpaResultData;
import com.tobawoo.nh2016.data.ChulhajeongboResultData;
import com.tobawoo.nh2016.data.CommonInter;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.adapter.ChoeumpaMainAdapter;
import com.tobawoo.nh2016.ui.adapter.OnTableItemClickListener;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.ui.popup.ActionItem;
import com.tobawoo.nh2016.ui.popup.QuickAction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChoeumpaJeongboSearchActivity extends SubBaseActivity implements OnTableItemClickListener {

    CommonResultType nt = null;

    AQuery aq;

    ChoeumpaData choeumpaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        nt = new CommonResultType();

        aq = new AQuery(this);

        aq.id(R.id.table_result_search_title).text("초음파 정보 결과 조회");

        choeumpaData = (ChoeumpaData) getIntent().getExtras().getSerializable("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("분만 정보 결과 관리 조회");

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
                "사업단명",
                "판독여부",
                "월령",
                "성별",
                "체중",
                "생년월일",
                "이력추적 생년월일",
                "측정일자",
                "판독일자",
                "등록일자",
                "측정자",
                "등지방 두께",
                "등심 단면적",
                "근내 지방도",
                "예상 육량",
                "예상 육질",
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
                100,
                100,
                100,
                100
        };

        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final ChoeumpaMainAdapter<String> matrixTableAdapter = new ChoeumpaMainAdapter<>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_CHOEUMPAJEONGBO_LIST, choeumpaData.getParamMap(), JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
//                Logger.log("츠 : " + object);
                if(object!=null){
                    Logger.log("개체검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            ChoeumpaResultData nrd = gson.fromJson(item.toString() , ChoeumpaResultData.class);
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
        final ChoeumpaResultData choeumpaResultData = (ChoeumpaResultData) commonInter;

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
                bundle.putSerializable("data" , choeumpaResultData);
                switch (actionId){
                    case  CommonUtils.ID_VIEW_SEARCH_GAECHE:
                        intent = new Intent(ChoeumpaJeongboSearchActivity.this , GaecheDetailTabAllActivity.class);
                        intent.putExtra("search_barcode" , choeumpaResultData.getBarcode());
                        break;
                    case CommonUtils.ID_VIEW_DETAIL:
                        intent = new Intent(ChoeumpaJeongboSearchActivity.this , GaecheDetailActivity.class);
                        break;
                }
                if(intent!=null) {
                    intent.putExtras(bundle);
                    startActivity(intent);
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
