package com.kth.tobawoo.ui;

import android.content.Intent;
import android.os.Bundle;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.kth.tobawoo.R;
import com.kth.tobawoo.data.UserInfo;
import com.kth.tobawoo.utils.CommonUtils;
import com.kth.tobawoo.utils.DBHelper;
import com.kth.tobawoo.utils.Logger;
import com.kth.tobawoo.ui.common.URLManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by tommy on 2016-01-04.
 */
public class LoginActivity extends SubBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        DBHelper dbHelper = new DBHelper(this);
        dbHelper.open();
        dbHelper.close();

        setUp();

        aq.find(R.id.login_btn).clicked(this, "loginPro");
    }

    public void loginPro(){

        HashMap<String,String> param = new HashMap<String,String>();
        param.put("user_id" , aq.id(R.id.et_user_id).getText().toString());
        param.put("password" , aq.id(R.id.et_user_password).getText().toString());
        aq.progress(getProgressDialog()).ajax(URLManager._LOGIN_PRO , param , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){
                    try {
                        Logger.log(object.toString());
                        JSONArray array = object.getJSONArray("results");
                        if(array.length()>0){
                            JSONObject item = array.getJSONObject(0);
                            Gson gson =new Gson();
                            UserInfo userInfo = gson.fromJson(item.toString() , UserInfo.class);
                            Logger.log(userInfo.toString());
                            CommonUtils.savePreferences(LoginActivity.this , "m_tokken" , userInfo.getM_tokken());
                            CommonUtils.savePreferences(LoginActivity.this , "member" , item.toString());

                            Intent intent = new Intent(LoginActivity.this , UIMainActivity.class);
                            startActivity(intent);
                        }else{
                            showAlertDialog("아이디 또는 비밀번호가 일치하지 않습니다.");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        showAlertDialog("아이디 또는 비밀번호가 잘못되었습니다.");
                    }
                }
            }
        });





//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("로그인중입니다...");
//        pd.show();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                pd.hide();
//                Toast.makeText(LoginActivity.this , getString(R.string.error_connectting_w_login) , Toast.LENGTH_SHORT).show();
//            }
//        }, 10000);
    }



}
