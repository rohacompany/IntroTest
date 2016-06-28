package com.tobawoo.nh2016.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.data.NonggaSearchResultData;

public class NongaDetailActivity extends AppCompatActivity {

    NonggaSearchResultData nonggaSearchResultData;

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_detail);

        aq = new AQuery(this);

        nonggaSearchResultData = (NonggaSearchResultData) getIntent().getExtras().getSerializable("data");

        Logger.log("Detail info -> " + nonggaSearchResultData.toString());

        setTitle("농가관리 상세보기");

//        DisplayMetrics metrics = getResources().getDisplayMetrics();
//        int screenWidth = (int) (metrics.widthPixels * 0.80);
//        int screenHeight = (int) (metrics.heightPixels * 0.9);  //Display 사이즈의 90%
//
////        getWindow().setLayout(screenWidth, LinearLaout.LayoutParams.MATCH_PARENT); //set below the setContentview
//        getWindow().getAttributes().width = screenWidth;
//        getWindow().getAttributes().height = screenHeight;

        setData();
    }

    private void setData(){
        aq.id(R.id.et_chukhyup_name).text(nonggaSearchResultData.getChukhyup_name());
        aq.id(R.id.et_sido).text(nonggaSearchResultData.getSido());
        aq.id(R.id.et_area1).text(nonggaSearchResultData.getArea1());
        aq.id(R.id.et_area2).text(nonggaSearchResultData.getArea2());

        aq.id(R.id.et_house_code).text(nonggaSearchResultData.getHouse_code());
        aq.id(R.id.et_house_gubun).text(nonggaSearchResultData.getHouse_gubun());
        aq.id(R.id.et_house_name).text(nonggaSearchResultData.getHouse_name());
        aq.id(R.id.et_birth).text(nonggaSearchResultData.getBirth());
        aq.id(R.id.et_sex).text(nonggaSearchResultData.getSex());
        aq.id(R.id.et_zipcode).text(nonggaSearchResultData.getZipcode());
        aq.id(R.id.et_house_addr1).text(nonggaSearchResultData.getHouse_addr1());
        aq.id(R.id.et_house_addr2).text(nonggaSearchResultData.getHouse_addr2());
        aq.id(R.id.et_house_addr3).text(nonggaSearchResultData.getHouse_addr3());
        aq.id(R.id.et_phone).text(nonggaSearchResultData.getPhone());
        aq.id(R.id.et_fax).text(nonggaSearchResultData.getFax());
        aq.id(R.id.et_mobile).text(nonggaSearchResultData.getMobile());
        aq.id(R.id.et_farm_name).text(nonggaSearchResultData.getFarm_name());
        aq.id(R.id.et_account_no).text(nonggaSearchResultData.getAccount_no());
        aq.id(R.id.et_farm_zipcode).text(nonggaSearchResultData.getFarm_zipcode());
        aq.id(R.id.et_farm_addr1).text(nonggaSearchResultData.getFarm_addr1());
        aq.id(R.id.et_farm_addr2).text(nonggaSearchResultData.getFarm_addr2());
        aq.id(R.id.et_farm_addr3).text(nonggaSearchResultData.getFarm_addr3());
        aq.id(R.id.et_farm_phone).text(nonggaSearchResultData.getFarm_phone());
        aq.id(R.id.et_reg_no).text(nonggaSearchResultData.getReg_no());
        aq.id(R.id.et_breed_type).text(nonggaSearchResultData.getBreed_type());
        aq.id(R.id.et_calf_product).text(nonggaSearchResultData.getCalf_product());
        aq.id(R.id.et_improve).text(nonggaSearchResultData.getImprove());
        aq.id(R.id.et_manage).text(nonggaSearchResultData.getManage());
        aq.id(R.id.et_mail_yn).checked(nonggaSearchResultData.getMail_yn().equalsIgnoreCase("Y")?true:false);
        aq.id(R.id.et_community_name).text(nonggaSearchResultData.getCommunity_name());
    }
}
