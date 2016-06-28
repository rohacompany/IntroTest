package com.tobawoo.nh2016.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.astuetz.PagerSlidingTabStrip;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.google.gson.Gson;
import com.tobawoo.nh2016.BuildConfig;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.ImageUtils;
import com.tobawoo.nh2016.data.BunmanSummaryData;
import com.tobawoo.nh2016.data.BunmanjeongboData;
import com.tobawoo.nh2016.data.ChoeumpaData;
import com.tobawoo.nh2016.data.ChulhaSummaryData;
import com.tobawoo.nh2016.data.ChulhajeongboData;
import com.tobawoo.nh2016.data.CommonInter;
import com.tobawoo.nh2016.data.GaecheData;
import com.tobawoo.nh2016.data.GyobaeSummaryData;
import com.tobawoo.nh2016.data.GyobaejeongboData;
import com.tobawoo.nh2016.data.NongaSummaryData;
import com.tobawoo.nh2016.data.NonggaData;
import com.tobawoo.nh2016.ui.adapter.MainViewPagerAdapter;
import com.tobawoo.nh2016.common.URLManager;
import com.tobawoo.nh2016.ui.fragment.main.BunmanjeongboMainFrag;
import com.tobawoo.nh2016.ui.fragment.main.ChoeumpaMainFrag;
import com.tobawoo.nh2016.ui.fragment.main.ChulhajeongboFrag;
import com.tobawoo.nh2016.ui.fragment.main.GaecheMainFrag;
import com.tobawoo.nh2016.ui.fragment.main.GyobaejeongboMainFrag;
import com.tobawoo.nh2016.ui.fragment.main.NonggaMainFrag;
import com.tobawoo.nh2016.ui.fragment.main.OnFragmentClickedListener;
import com.tobawoo.nh2016.ui.summary.BunmanJeongboSummaryActivity;
import com.tobawoo.nh2016.ui.summary.ChulhaJeongboSummaryActivity;
import com.tobawoo.nh2016.ui.summary.GyobaeJeongboSummaryActivity;
import com.tobawoo.nh2016.ui.summary.NongaSummaryActivity;
import com.tobawoo.nh2016.common.CommonUtils;
import com.tobawoo.nh2016.common.Logger;

import junit.framework.Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UIMainActivity extends SubBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnFragmentClickedListener {
    AQuery aq;
    DrawerLayout drawer;
    Handler mHandler = new Handler();

    private static int _OPEN_NAV_DARWER = 100;

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MainViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uimain);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        closeDrawer();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //네비게이션 이벤트 설정
        setNavigationEvent();

//        NewMainFrag nmf = new NewMainFrag();
//        addFragment2(nmf);

        aq.find(R.id.app_version).text("버전 " + BuildConfig.VERSION_NAME);
        aq.id(R.id.tv_user_id).text("사용자 ID : " + userInfo.getUser_id());
        aq.id(R.id.ibtn_logout).clicked(this , "logoutPro");
        aq.id(R.id.btn_profile).clicked(this , "setProfile").image(URLManager._HOST + userInfo.getProfile(),true,true,200,R.drawable.ic_profile_edit,null,AQuery.FADE_IN);
        setPageStrip();

//        setFabSetting(); //Fab 액션값 지정
    }

    public void setPageStrip(){

        tabs = (PagerSlidingTabStrip) aq.id(R.id.tabs).getView();
        tabs.setTextColor(getResources().getColor(R.color.White));
        tabs.setIndicatorColor(getResources().getColor(R.color.colorAccent));
//        tabs.setDividerColor(getResources().getColor(R.color.White));
        pager = (ViewPager) aq.id(R.id.pager).getView();
        adapter = new MainViewPagerAdapter(getSupportFragmentManager() , getResources().getStringArray(R.array.main_tabs_arrays));

        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);

    }

    public void setNavigationEvent(){
        aq.find(R.id.ibtn_close).clicked(this, "closeDrawer");

//        aq.find(R.id.tv_nongga_gwalli).clicked(this , "clickNavMenus"); //옆메뉴 농가관리

        aq.find(R.id.tv_nongga_bangyeokgwanri).clicked(this, "clickNavMenus");

        //개체 정보
//        aq.find(R.id.tv_gaeche_jeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_geoseejeongbo).clicked(this, "clickNavMenus");

        //캘린더 관리
        aq.find(R.id.uimain_calendar_container).clicked(this , "clickNavMenus");

        aq.find(R.id.tv_gaeche_bunmanjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_biyukjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_iryeokjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_yebangjeobjongjeongbo).clicked(this, "clickNavMenus");

        aq.find(R.id.tv_gaeche_chulhajeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_dochukjeongbo).clicked(this, "clickNavMenus");

        aq.find(R.id.tv_menu_gasang_gyobae).clicked(this, "clickNavMenus");

        aq.find(R.id.btn_setting).clicked(this , "clickNavMenus");

        aq.find(R.id.container_notice).clicked(this , "clickNavMenus");

        aq.find(R.id.ibtn_logout).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(UIMainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },500);
            }
        });


    }


    public void closeDrawer(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.closeDrawer(GravityCompat.START);
            }
        }, 100);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finishApp();
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.uimain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickNavMenus(View view){
        Fragment fragment = null;
        String tag = null;
        Intent intent = null;
        switch (view.getId()){
//            case R.id.tv_nongga_gwalli:
//                intent = new Intent(this , NongaMainActivity.class);
//                break;
            case R.id.tv_menu_gasang_gyobae:
                intent = new Intent(this , GasangGyobaePlanMainActivity.class);
                break;
            case R.id.tv_nongga_bangyeokgwanri:
                intent = new Intent(this , NongaBangyokMainActivity.class);
                break;
//            case R.id.tv_gaeche_jeongbo:
//                intent = new Intent(this , GaechejeongboMainActivity.class);
//                intent.putExtra("flag" , GaechejeongboMainActivity._FRAG_GAECHEJEONGBO_MAIN);
//                break;
//            case R.id.tv_gaeche_geoseejeongbo:
//                intent = new Intent(this , GaechejeongboMainActivity.class);
//                intent.putExtra("flag" , GaechejeongboMainActivity._FRAG_GAECHEJEONGBO_GEOSE);
//                break;
            case R.id.btn_setting:
                intent = new Intent(this , PopupActivity.class);
                intent.putExtra("flag"  , PopupActivity._FRAGMENT_SETTING);
                break;
            case R.id.uimain_calendar_container:
                intent = new Intent(this , CalendarMainActivity.class);
                break;
            case R.id.container_notice:
                intent = new Intent(this , NoticeItemListActivity.class);
                break;
            default:
                intent = new Intent(this , GaechejeongboMainActivity.class);
                intent.putExtra("flag" , GaechejeongboMainActivity._FRAG_GAECHEJEONGBO_MAIN);
                break;
        }

        closeDrawer();
        startActivityForResult(intent , _OPEN_NAV_DARWER);


//        if(fragment!=null)
//            addFragment(fragment);

    }

    public void showNotWorking(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("수정중입니다.");
        builder.setPositiveButton("닫기"  , new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.log("onActivityResult -> resultCode -> " + resultCode + ", requestCode -> " + requestCode );
        if(resultCode == RESULT_OK){
            if(requestCode == _OPEN_NAV_DARWER) {
                Logger.log("open Nav bar!!");
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawer.openDrawer(Gravity.LEFT);
                    }
                },300);
            }else if (requestCode == REQ_CAMERA) {

                Bitmap selPhoto = null;
                try {

                    AssetFileDescriptor afd = getContentResolver().openAssetFileDescriptor(mImageCaptureUri, "r");
                    BitmapFactory.Options opt = new BitmapFactory.Options();
                    opt.inSampleSize = 4;

                    setImageFromCamera();
                } catch (OutOfMemoryError e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if(requestCode == REQ_GALLERY){
                //Uri에서 이미지 이름을 얻어온다.
                String name_str = CommonUtils.getImageNameToUri(this, data.getData());
                Logger.log("img -> " + name_str);
                setImageFromGallery(name_str);
            }
        }
    }


    @Override
    public void onClicked(CommonInter commonInter , String frag_name , View view) {
        Intent intent = null;
        if(view.getId() == R.id.btn_search_result_summary){
            workSummary(frag_name , commonInter);
        }else{
            if(frag_name.equalsIgnoreCase(NonggaMainFrag.class.getName())){
                Bundle bundle = new Bundle();
                bundle.putSerializable("data" , (NonggaData)commonInter);
                intent = new Intent(this, NongaSearchActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }else if(frag_name.equalsIgnoreCase(GaecheMainFrag.class.getName())){
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("data" , (GaecheData)commonInter);
                intent = new Intent(this, GaecheSearchActivity.class);
                intent.putExtras(bundle2);
                startActivity(intent);
            }else if(frag_name.equalsIgnoreCase(GyobaejeongboMainFrag.class.getName())){
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("data" , (GyobaejeongboData)commonInter);
                intent = new Intent(this, GyobaejeongboSearchActivity.class);
                intent.putExtras(bundle3);
                startActivity(intent);
            }else if(frag_name.equalsIgnoreCase(BunmanjeongboMainFrag.class.getName())){
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("data" , (BunmanjeongboData)commonInter);
                intent = new Intent(this, BunmanjeongboSearchActivity.class);
                intent.putExtras(bundle4);
                startActivity(intent);
            }else if(frag_name.equalsIgnoreCase(ChoeumpaMainFrag.class.getName())){
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("data" , (ChoeumpaData)commonInter);
                intent = new Intent(this, ChoeumpaJeongboSearchActivity.class);
                intent.putExtras(bundle5);
                startActivity(intent);
            }else if(frag_name.equalsIgnoreCase(ChulhajeongboFrag.class.getName())){
                Bundle bundle6 = new Bundle();
                bundle6.putSerializable("data" , (ChulhajeongboData)commonInter);
                intent = new Intent(this, ChulhajeongboSearchActivity.class);
                intent.putExtras(bundle6);
                startActivity(intent);
            }
        }
    }


    public void workSummary(String frag_name , CommonInter commonInter){
        if(frag_name.equalsIgnoreCase(NonggaMainFrag.class.getName()) || frag_name.equalsIgnoreCase(GaecheMainFrag.class.getName())){
            setNongaSummaryDatas(commonInter);
        }else if(frag_name.equalsIgnoreCase(GyobaejeongboMainFrag.class.getName())){
            setGyobaeSummaryDatas(commonInter);
        }else if(frag_name.equalsIgnoreCase(BunmanjeongboMainFrag.class.getName())){
            setBunmanSummaryDatas(commonInter);
        }else if(frag_name.equalsIgnoreCase(ChulhajeongboFrag.class.getName())){
            setChulhaSummaryDatas(commonInter);
        }
    }

    private void setNongaSummaryDatas(CommonInter commonInter){

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_NONGA_SUMMARY_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null) {
                    ArrayList<NongaSummaryData> list = new ArrayList<NongaSummaryData>();
                    Bundle bundle = new Bundle();

                    try {
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();

                        for(int i=0;i<results.length();i++){
                            NongaSummaryData nsd = gson.fromJson(results.getJSONObject(i).toString() , NongaSummaryData.class);
                            Logger.log(i + "번째 Data : " + nsd.toString());
                            list.add(nsd);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        bundle.putParcelableArrayList("datas" , list);

                        Intent intent = new Intent(UIMainActivity.this, NongaSummaryActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                }
            }
        });
    }

    private void setGyobaeSummaryDatas(CommonInter commonInter){

        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_GYOBAE_SUMMARY_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null) {
                    ArrayList<GyobaeSummaryData> list = new ArrayList<GyobaeSummaryData>();
                    Bundle bundle = new Bundle();

                    try {
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();

                        for(int i=0;i<results.length();i++){
                            GyobaeSummaryData nsd = gson.fromJson(results.getJSONObject(i).toString() , GyobaeSummaryData.class);
                            list.add(nsd);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        bundle.putParcelableArrayList("datas" , list);

                        Intent intent = new Intent(UIMainActivity.this, GyobaeJeongboSummaryActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                }
            }
        });
    }

    /**
         * 분만정보 싱크
         */
    private void setBunmanSummaryDatas(CommonInter commonInter){
        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_BUNMAN_SUMMARY_LIST , JSONObject.class , new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null) {
                    ArrayList<BunmanSummaryData> list = new ArrayList<BunmanSummaryData>();
                    Bundle bundle = new Bundle();

                    try {
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();

                        for(int i=0;i<results.length();i++){
                            BunmanSummaryData nsd = gson.fromJson(results.getJSONObject(i).toString() , BunmanSummaryData.class);
                            list.add(nsd);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        bundle.putParcelableArrayList("datas" , list);

                        Intent intent = new Intent(UIMainActivity.this, BunmanJeongboSummaryActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                }
            }
        });
    }

    /**
     * 출하정보 싱크
     */
    private void setChulhaSummaryDatas(CommonInter commonInter){
        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._GET_CHULHA_SUMMARY_LIST, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if (object != null) {
                    ArrayList<ChulhaSummaryData> list = new ArrayList<ChulhaSummaryData>();
                    Bundle bundle = new Bundle();

                    try {
                        JSONArray results = object.getJSONArray("results");
                        Gson gson = new Gson();

                        for (int i = 0; i < results.length(); i++) {
                            ChulhaSummaryData nsd = gson.fromJson(results.getJSONObject(i).toString(), ChulhaSummaryData.class);
                            list.add(nsd);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        bundle.putParcelableArrayList("datas", list);

                        Intent intent = new Intent(UIMainActivity.this, ChulhaJeongboSummaryActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                }
            }
        });
    }
    FloatingActionButton fab;
    FloatingActionButton fab1;
    FloatingActionButton fab2;
//    FloatingActionButton fab3;

    //Save the FAB's active status
    //false -> fab = close
    //true -> fab = open
    private boolean FAB_Status = false;

    //Animations
    Animation show_fab_1;
    Animation hide_fab_1;
    Animation show_fab_2;
    Animation hide_fab_2;
//    Animation show_fab_3;
//    Animation hide_fab_3;

    private void setFabSetting(){
        //Floating Action Buttons
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
//        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);

        //Animations
        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
//        show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
//        hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (FAB_Status == false) {
                    //Display FAB menu
                    expandFAB();
                    FAB_Status = true;
                } else {
                    //Close FAB menu
                    hideFAB();
                    FAB_Status = false;
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Floating Action Button 1", Toast.LENGTH_SHORT).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Floating Action Button 2", Toast.LENGTH_SHORT).show();
            }
        });

//        fab3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplication(), "Floating Action Button 3", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void expandFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams.rightMargin += (int) (fab1.getWidth() * 1.5);
        layoutParams.bottomMargin += (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin += (int) (fab2.getWidth() * 0.25);
        layoutParams2.bottomMargin += (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(show_fab_2);
        fab2.setClickable(true);

//        //Floating Action Button 3
//        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
//        layoutParams3.rightMargin += (int) (fab3.getWidth() * 0.25);
//        layoutParams3.bottomMargin += (int) (fab3.getHeight() * 1.7);
//        fab3.setLayoutParams(layoutParams3);
//        fab3.startAnimation(show_fab_3);
//        fab3.setClickable(true);
    }


    private void hideFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams.rightMargin -= (int) (fab1.getWidth() * 1.5);
        layoutParams.bottomMargin -= (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (fab2.getWidth() * 0.25);
        layoutParams2.bottomMargin -= (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(hide_fab_2);
        fab2.setClickable(false);

//        //Floating Action Button 3
//        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
//        layoutParams3.rightMargin -= (int) (fab3.getWidth() * 0.25);
//        layoutParams3.bottomMargin -= (int) (fab3.getHeight() * 1.7);
//        fab3.setLayoutParams(layoutParams3);
//        fab3.startAnimation(hide_fab_3);
//        fab3.setClickable(false);
    }

    Uri mImageCaptureUri;
    public final static int REQ_CAMERA = 1000;
    public final static int REQ_GALLERY = 2000;

    public void setProfile(){
        new AlertDialog.Builder(this)
                .setSingleChoiceItems(new String[]{"갤러리에서 가져오기", "카메라로 촬영하기", "삭제하기"}, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                        if (item == 0) {
//갤러리 호출
                            Uri uri = Uri.parse("content://media/external/images/media");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.setAction(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, REQ_GALLERY);
                        } else if (item == 1) {
//카메라로 찍기
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            String url = "temp.jpg";
                            mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
                            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivityForResult(intent, REQ_CAMERA);
                        } else { //삭제시
//                            if(iv!=null)
                            aq.id(R.id.btn_profile).image(R.drawable.ic_profile_edit);
//                            ((BootstrapButton) view ).setText("사진\n첨부");
//                            setSelectBitmap(resId , null);
                            saveProfileImgToServer();
                        }
                    }
                })
//                .setTitle("사진을 선택해주세요.")
                .show();
    }

    public void setSelectBitmap(int resId , Bitmap bm){

    }

    Bitmap selectedBitmap = null;

    public void setImageFromGallery(String path) {
        File file = new File(path);
        Bitmap bm = ImageUtils.SafeDecodeBitmapFile(path);
//        Logger.log("bitmap size : " + bm.getWidth() + "," + bm.getHeight());
        int targetWidth = 200;

        selectedBitmap = bm;

        aq.id(R.id.btn_profile).image(bm);

        saveProfileImgToServer();
    }

    public void setImageFromCamera() {
        Logger.log("setImageFromCamera ok");
        String filePath = mImageCaptureUri.toString().replace("file://", "");
        Bitmap scaledBitmap = ImageUtils.SafeDecodeBitmapFile(filePath);

        selectedBitmap = scaledBitmap;

        Logger.log("319 camera get image path : " + mImageCaptureUri.toString());
        aq.id(R.id.btn_profile).image(scaledBitmap);

        File f = new File(mImageCaptureUri.toString());
        f.delete();

        saveProfileImgToServer();
    }

    public void saveProfileImgToServer(){
        HashMap<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("user_id" ,  userInfo.getUser_id());
        paramMap.put("password" , userInfo.getPassword());
        saveBitmap(paramMap , "img" , selectedBitmap);
        aq.progress(CommonUtils.getProgressDialog(this)).ajax(URLManager._UPDATE_PROFILE_IMAGE ,  paramMap , String.class , new AjaxCallback<String>(){
            @Override
            public void callback(String url, String object, AjaxStatus status) {
                Logger.log("이미지 업로드 결과 -> " + object);
            }
        });
    }

    private void saveBitmap(HashMap<String,Object> paramMap , String key , Bitmap bm){
        if (bm != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            paramMap.put(key, byteArray);
        }
    }

}
