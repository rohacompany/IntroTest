package com.tobawoo.nh2016.ui;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.CommonInter;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.data.CommonTableData;
import com.tobawoo.nh2016.data.GasanggyobaeResultData;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.adapter.GasangGyobaeMainAdapter;
import com.tobawoo.nh2016.ui.adapter.OnTableItemClickListener;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GasangGyobaePlanMainActivity extends SubBaseActivity implements OnTableItemClickListener {

    CommonResultType nt = null;

    private String et_doWeight = "1";
    private String et_deungsimdanmyeonjeok = "3";
    private String et_deungjibangdukke = "-1";
    private String et_geunnaejibangdo = "8";

    TableFixHeaders tableFixHeaders;
    GasangGyobaeMainAdapter<String> matrixTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasang_gyobae_plan_main);
        aq = new AQuery(this);
        nt = new CommonResultType();

        setTitle("가상교배");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("가상교배");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


//        aq.id(R.id.btnWeightPopup).clicked(this, "showWeightPopup");
        aq.id(R.id.btnSearch).clicked(this, "setData");

        BootstrapEditText be = (BootstrapEditText) aq.id(R.id.et_search_bar).getView();
        be.setTextSize(30f);
        be.setTypeface(null , Typeface.BOLD);

        setTableLayout();
    }

    private void setTableLayout(){
        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("가상송아지\n명호", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("아비명호",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("가상송아지\n근교계수",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("근교계수\n수준",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("도체중",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등심단면적",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등지방두께",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("근내지방도", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("선발지수",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("그룹",Gravity.CENTER,100));


        tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        matrixTableAdapter = new GasangGyobaeMainAdapter<>(this, tabDataList, nt);
        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);
    }


    public void setData() {
        nt.list.clear();
        Logger.log("setData execute!!");
        if(CommonUtils.isNull(aq.id(R.id.et_search_bar).getText().toString())){
            Toast.makeText(this , "바코드값을 입력해주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("barcode" , aq.id(R.id.et_search_bar).getText().toString());
        paramMap.put("A", aq.id(R.id.et_doWeight).getText().toString());
        paramMap.put("B" , aq.id(R.id.et_deungsimdanmyeonjeok).getText().toString());
        paramMap.put("C" , aq.id(R.id.et_deungjibangdukke).getText().toString());
        paramMap.put("D" , aq.id(R.id.et_geunnaejibangdo).getText().toString());

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_GASANG_GYOBAE_LIST, paramMap ,  JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                Logger.log("츠 : " + object);
                if(object!=null){
                    Logger.log("가상교배 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            GasanggyobaeResultData nrd = gson.fromJson(item.toString() , GasanggyobaeResultData.class);
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



    public void showWeightPopup(){
        Logger.log("showWeightPopup execute!!");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_gasang_gyobar_main , null);
        final AQuery dialog_aq = new AQuery(view);
        dialog_aq.id(R.id.et_doweight).text(et_doWeight);
        dialog_aq.id(R.id.et_deungsimdanmyeonjeok).text(et_deungsimdanmyeonjeok);
        dialog_aq.id(R.id.et_deungjibangdukke).text(et_deungjibangdukke);
        dialog_aq.id(R.id.et_geunnaejibangdo).text(et_geunnaejibangdo);
        builder.setView(view);
//        builder.setTitle("형질/가중치 설정");
        builder.setNegativeButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                et_doWeight = dialog_aq.id(R.id.et_doweight).getText().toString();
                et_deungsimdanmyeonjeok = dialog_aq.id(R.id.et_deungsimdanmyeonjeok).getText().toString();
                et_deungjibangdukke = dialog_aq.id(R.id.et_deungjibangdukke).getText().toString();
                et_geunnaejibangdo = dialog_aq.id(R.id.et_geunnaejibangdo).getText().toString();
            }
        });
        builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    @Override
    public void onListItemClicked(View view, CommonInter commonInter, int row, int column) {

    }
}

