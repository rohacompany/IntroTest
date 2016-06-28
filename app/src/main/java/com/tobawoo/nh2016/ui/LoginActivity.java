package com.tobawoo.nh2016.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.UserInfo;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.DBHelper;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.common.URLManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
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

        checkAppUpdate();

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
//                            Logger.log(userInfo.toString());
                            CommonUtils.savePreferences(LoginActivity.this , "m_tokken" , userInfo.getM_tokken());
                            CommonUtils.savePreferences(LoginActivity.this , "member" , item.toString());

                            Intent intent = new Intent(LoginActivity.this , UIMainActivity.class);
                            startActivity(intent);
                            flagAnim = false;
                            finish();
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

    }


    //�ֽŹ��� ������Ʈ üũ (step1)
    private void checkAppUpdate(){
        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._URL_CHECK_APP_VERSION, String.class, new AjaxCallback<String>() {
            @Override
            public void callback(String url, String object, AjaxStatus status) {
                int currentAppVersionCode = CommonUtils.getCurrentAppVersionCode(LoginActivity.this);
                Logger.log("app version -> <<" + object + ">>" + "current app version -> " + currentAppVersionCode);
                if (!CommonUtils.isNull(object)) {
                    int serverAppVersionCode = Integer.parseInt(object.trim());
                    if (serverAppVersionCode > currentAppVersionCode) { //������Ʈ ����
                        fileDownload();
//						showDialog(0);
                    } else {
                        //startApp();
                    }
                }
            }
        });
    }


    //�ֽŹ��� ������Ʈ üũ (step2)
    private void fileDownload(){

        File ext = Environment.getExternalStorageDirectory();
        final File target = new File(ext, "tobawoo.apk");

        aq.progress(CommonUtils.getBarProgressDialog(this)).
                download(URLManager._URL_APK_DONWLOAD, target, new AjaxCallback<File>() {

                    public void callback(String url, File file, AjaxStatus status) {

                        if (file != null) {
                            Logger.log("File:" + file.length() + ":" + file + ",status=" + status.getCode());
                            installApp(target);
                        } else {
                            Logger.log("Failed" + ",status=" + status);
                        }
                    }

                });
    }

    //�ֽŹ��� ������Ʈ üũ (step3)
    private void installApp(File file){
//        String path = Environment.getExternalStorageDirectory() + "/girl_talk_app.apk";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
        finish();
        //file.delete();
    }



}
