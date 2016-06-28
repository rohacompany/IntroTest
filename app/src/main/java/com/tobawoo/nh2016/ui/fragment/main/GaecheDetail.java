package com.tobawoo.nh2016.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.data.CommonResultType;
import com.tobawoo.nh2016.data.CommonTableData;
import com.tobawoo.nh2016.data.GaechSearchResultData;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.adapter.GachejeongboMainAdapter;
import com.tobawoo.nh2016.ui.fragment.main.common.CommonFragDatas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tommy on 2016-06-23.
 */
public class GaecheDetail extends Fragment{
    CommonResultType nt = null;
    private String barcode;
    AQuery aq;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.view_common_fixed_layout , container , false);

        if(getArguments()!=null)
            barcode = getArguments().getString("search_barcode");

        aq = new AQuery(view);

        nt = new CommonResultType();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setTableLayout();

    }

    public void setTableLayout() {

        final TableFixHeaders tableFixHeaders = (TableFixHeaders) getView().findViewById(R.id.table);
        final GachejeongboMainAdapter<String> matrixTableAdapter = new GachejeongboMainAdapter<String>(getActivity() , CommonFragDatas.getGaecheHeaderList() , nt);
//        matrixTableAdapter.setOnTableItemClick(this);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        Logger.log("GaecheDeatilFrag barcode -> " + barcode);

        HashMap<String, String> paramMap = new HashMap<String,String>();
        paramMap.put("search_barcode" , barcode);
//        if(CommonUtils.isNull(searchHouseCode)) {
//            paramMap = gaecheData.getParamMap();
//        }else{
//            paramMap = new HashMap<String,String>();
//            paramMap.put("search_house_code" , searchHouseCode);
//        }

        aq.progress(CommonUtils.getProgressDialog(getActivity())).ajax(URLManager._GET_GAECHE_LIST , paramMap , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
//                Logger.log("개체검색 : " + object);
                if(object!=null){
//                    Logger.log("개체검색 결과 : " + object);
                    Gson gson = new Gson();
                    try {
                        JSONArray array = object.getJSONArray("results");
//                        String sql = URLDecoder.decode(object.getString("sql"));
//                        Logger.log("sql : " + sql);
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
}
