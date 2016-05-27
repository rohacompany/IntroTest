package com.kth.tobawoo.ui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import com.androidquery.AQuery;
import com.astuetz.PagerSlidingTabStrip;
import com.kth.tobawoo.BuildConfig;
import com.kth.tobawoo.R;
import com.kth.tobawoo.ui.adapter.MainViewPagerAdapter;
import com.kth.tobawoo.ui.fragment.MainFrag;
import com.kth.tobawoo.ui.fragment.NewMainFrag;
import com.kth.tobawoo.ui.fragment.main.OnFragmentClickedListener;
import com.kth.tobawoo.utils.Logger;

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

        setPageStrip();
    }

    public void setPageStrip(){

        tabs = (PagerSlidingTabStrip) aq.id(R.id.tabs).getView();
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
        aq.find(R.id.tv_gaeche_jeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_geoseejeongbo).clicked(this, "clickNavMenus");

        //캘린더 관리
        aq.find(R.id.uimain_calendar_container).clicked(this , "clickNavMenus");

        aq.find(R.id.tv_gaeche_bunmanjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_biyukjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_iryeokjeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_yebangjeobjongjeongbo).clicked(this, "clickNavMenus");

        aq.find(R.id.tv_gaeche_chulhajeongbo).clicked(this, "clickNavMenus");
        aq.find(R.id.tv_gaeche_dochukjeongbo).clicked(this, "clickNavMenus");

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
            super.onBackPressed();
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
            case R.id.tv_nongga_bangyeokgwanri:
                intent = new Intent(this , NongaBangyokMainActivity.class);
                break;
            case R.id.tv_gaeche_jeongbo:
                intent = new Intent(this , GaechejeongboMainActivity.class);
                intent.putExtra("flag" , GaechejeongboMainActivity._FRAG_GAECHEJEONGBO_MAIN);
                break;
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
                intent = new Intent(this , NoticeMainActivity.class);
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

            }
        }
    }

    @Override
    public void onClicked(View view) {
        if(view.getId() == R.id.btn_search_nonga) {
            Intent intent = new Intent(this, NongaSearchActivity.class);
            startActivity(intent);
        }else{
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage("서버와 로딩중입니다..잠시만 기다려주세요");
            pd.show();
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pd.dismiss();
                    String test = null;
                    test.toString();
                }
            } , 5000);

//            Intent intent = new Intent(this , GaecheSearchActivity.class);
//            startActivity(intent);
        }
    }


}
