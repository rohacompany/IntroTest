package com.tobawoo.nh2016.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.OnEventClickListener;
import com.tobawoo.nh2016.ui.fragment.old.SettingsFrag;
import com.tobawoo.nh2016.ui.fragment.old.WriteNongaMainFrag;

/**
 * Created by tommy on 2016-01-15.
 */
public class PopupActivity extends BaseActivity implements View.OnClickListener{

    public static String _FRAGMENT_SETTING = "setting";
    public static String _FRAGMENT_WRITE_NONGGA = "write_nongga";

    AQuery aq;

    Fragment fragment = null;

    OnEventClickListener onEventClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_main);

         aq = new AQuery(this);

        aq.id(R.id.setting_sub_layout).clicked(this , "finishActivity");
        aq.id(R.id.btn_back).clicked(this, "finishActivity");
        aq.id(R.id.btn_save).clicked(this);


        showFragment();

        aq.id(R.id.popup_save_container).clicked(this, "saveDone");
    }

    public void setAppbarTitle(String title){
        aq.id(R.id.tv_titlebar).text(title);
    }

    public void showFragment(){

        String flag = getIntent().getStringExtra("flag");

        if(flag.equals(_FRAGMENT_SETTING)){
            fragment = new SettingsFrag();
        }else if(flag.equals(_FRAGMENT_WRITE_NONGGA)){
            aq.id(R.id.popup_save_container).visible();
            fragment = new WriteNongaMainFrag();
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.setting_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }

    public void finishActivity(){
        finish();
    }


    public void saveDone(){

    }

    @Override
    public void onClick(View v) {
        if(fragment!=null){
            ((WriteNongaMainFrag) fragment).saveDone();
        }
    }
}
