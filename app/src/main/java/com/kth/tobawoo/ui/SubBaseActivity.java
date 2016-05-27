package com.kth.tobawoo.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.utils.Logger;
import com.kth.tobawoo.utils.MyApplication;

/**
 * Created by tommy on 2016-01-04.
 */
public class SubBaseActivity extends AppCompatActivity {

    public boolean flagAnim = true;

    MyApplication myApplication;

    protected static final String _NONGGA_GWALLI = "nongga_gwalli";
    protected static final String _NONGGA_BANGYEOKGWANRI= "nongga_bangyeokgwanri";

    public AQuery aq;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        myApplication = (MyApplication) getApplication();
    }

    public void setUp(){

        aq = new AQuery(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void finish() {
        setResult(RESULT_OK);
        super.finish();

        if(flagAnim) {

            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    String top_tag_name = "";

    public void addFragment2(android.support.v4.app.Fragment frag){

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.content_frag , frag);

        ft.commit();

    }
    public void addFragment(Fragment frag){
//        if(top_tag_name.equalsIgnoreCase(tag)){
//            Logger.log("중복 addFragment -> " + tag);
//            return;
//        }
//        Logger.log("addFragment -> " + tag);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frag, frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        ft.addToBackStack( tag );
        ft.commit();

//        top_tag_name = tag;

//        if(shouldCloseDrawer){
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    closeDrawer();
//                }
//            }, 100);
//        }
    }

    public ProgressDialog getProgressDialog(){
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("로딩중입니다...");
        return pd;
    }

    AlertDialog dialog;
    public void showAlertDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setTitle("알림");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
}
