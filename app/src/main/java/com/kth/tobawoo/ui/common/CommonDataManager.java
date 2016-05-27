package com.kth.tobawoo.ui.common;

import android.content.Context;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.kth.tobawoo.data.Zipcode;
import com.kth.tobawoo.utils.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tommy on 2016-05-27.
 */
public class CommonDataManager {
    Context context;
    AQuery aq;
    public CommonDataManager(Context context , AQuery aq){
        this.context = context;
        this.aq = aq;
    }

    public List<Zipcode> getSiDo(){
        final  List<Zipcode> mList = new ArrayList<Zipcode>();
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("flag" , "sido");
        aq.ajax(URLManager._GET_SI_DO , map , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){
                    try {
                        Gson gson = new Gson();
                        JSONArray array = object.getJSONArray("results");
                        Logger.log("0000 -> " + array.length());
                        for(int i=0;i<array.length();i++){
                            JSONObject item = array.getJSONObject(i);
                            Zipcode zipcode = gson.fromJson(item.toString() , Zipcode.class);
                            mList.add(zipcode);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        return  mList;
    }

    public List<Zipcode> getGugun(String si){
        final  List<Zipcode> mList = new ArrayList<Zipcode>();
        return mList;
    }

    public List<Zipcode> getDong(String sido , String gugun){
        final  List<Zipcode> mList = new ArrayList<Zipcode>();
        return mList;
    }
}
