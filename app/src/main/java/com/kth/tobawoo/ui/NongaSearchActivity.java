package com.kth.tobawoo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.CommonInter;
import com.kth.tobawoo.data.NonggaData;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.data.CommonResultType;
import com.kth.tobawoo.fixedtablelayout.TableFixHeaders;
import com.kth.tobawoo.ui.adapter.NonggaMainAdapter;
import com.kth.tobawoo.ui.adapter.OnTableItemClickListener;
import com.kth.tobawoo.ui.common.URLManager;
import com.kth.tobawoo.ui.popup.ActionItem;
import com.kth.tobawoo.ui.popup.QuickAction;
import com.kth.tobawoo.utils.CommonUtils;
import com.kth.tobawoo.utils.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NongaSearchActivity extends SubBaseActivity implements OnTableItemClickListener{

    CommonResultType nt = new CommonResultType();

    AQuery aq;

    List<NonggaSearchResultData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        NonggaData nonggaData = (NonggaData) getIntent().getExtras().getSerializable("data");

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
        String[] mainHeaders = new String[]{
                "농가명",
                "농가(목장)\n번호",
                "축협명",
                "시군",
                "읍면",
                "동",
                "생년월일",
                "전체",
                "암",
                "수",
                "거세",
                "휴대폰",
                "전화번호",
                "우편번호",
                "농가기본주소",
                "농가상세주소",
                "팩스번호",
                "이메일",
                "우편번호",
                "목장기본주소",
                "목장상세주소"



        };
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                50,
                50,
                50,
                50,
                150, //휴대폰,
                150,
                150,
                200,
                150,
                100,
                150, //이메일
                100,
                200,
                200,
                200
        };


        final TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        final NonggaMainAdapter<String> matrixTableAdapter = new NonggaMainAdapter<String>(this, mainHeaders, mainWidths, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_NONGA_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){
                    Logger.log("농가검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
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

    private static final int ID_VIEW_DETAIL = 1;
    private static final int ID_VIEW_MODIFY = 2;
    private static final int ID_VIEW_SEARCH_GAECHE = 3;
    private static final int ID_VIEW_DELETE = 4;

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

        ActionItem itemDetail 		= new ActionItem(ID_VIEW_DETAIL, "상세보기", getResources().getDrawable(R.drawable.ic_action_full_screen));
        ActionItem itemSearchGaeche 		= new ActionItem(ID_VIEW_SEARCH_GAECHE, "개체검색", getResources().getDrawable(R.drawable.ic_action_search));
        ActionItem itemModify 	= new ActionItem(ID_VIEW_MODIFY, "수정하기", getResources().getDrawable(R.drawable.ic_action_edit));
        ActionItem itemDelete 	= new ActionItem(ID_VIEW_DELETE, "삭제하기", getResources().getDrawable(R.drawable.ic_action_remove_light));

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
                    case  ID_VIEW_SEARCH_GAECHE:
                        intent = new Intent(NongaSearchActivity.this , GaecheSearchActivity.class);
                        intent.putExtra("house_code" , nonggaSearchResultData.getHouse_code());
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case ID_VIEW_DETAIL:
                        intent = new Intent(NongaSearchActivity.this , NongaDetailActivity.class);
                        startActivity(intent);
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
