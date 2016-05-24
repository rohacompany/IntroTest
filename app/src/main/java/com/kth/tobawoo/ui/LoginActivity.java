package com.kth.tobawoo.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.kth.tobawoo.R;

/**
 * Created by tommy on 2016-01-04.
 */
public class LoginActivity extends SubBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        aq.find(R.id.login_btn).clicked(this, "loginPro");

        getSupportActionBar().hide();
    }

    public void loginPro(){

        Intent intent = new Intent(this , UIMainActivity.class);
        startActivity(intent);

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
