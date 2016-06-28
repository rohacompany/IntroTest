package com.tobawoo.nh2016.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.common.Logger;
import com.tobawoo.nh2016.data.GaechSearchResultData;
import com.tobawoo.nh2016.data.NonggaSearchResultData;

public class GaecheDetailActivity extends AppCompatActivity {

    GaechSearchResultData gaechSearchResultData;

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaeche_detail);

        aq = new AQuery(this);

        gaechSearchResultData = (GaechSearchResultData) getIntent().getExtras().getSerializable("data");

        Logger.log("Detail info -> " + gaechSearchResultData.toString());

        setTitle("개체관리 상세보기");

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

        aq.id(R.id.et_chukhyup_name).text(gaechSearchResultData.getChukhyup_name());
        aq.id(R.id.et_sido).text(gaechSearchResultData.getSido());
        aq.id(R.id.et_area1).text(gaechSearchResultData.getArea1());
        aq.id(R.id.et_area2).text(gaechSearchResultData.getArea2());
        aq.id(R.id.et_house_code).text(gaechSearchResultData.getHouse_code());
        aq.id(R.id.et_house_name).text(gaechSearchResultData.getHouse_name());
        aq.id(R.id.et_birth).text(gaechSearchResultData.getBirth());
        aq.id(R.id.et_farm_addr).text(gaechSearchResultData.getFarm_addr());
        aq.id(R.id.et_barcode).text(gaechSearchResultData.getBarcode());
        aq.id(R.id.et_mother_barcode).text(gaechSearchResultData.getMother_barcode());
        aq.id(R.id.et_mother_gubun).text(gaechSearchResultData.getMother_gubun());
        aq.id(R.id.et_impotent_barcode).text(gaechSearchResultData.getImpotent_barcode());
        aq.id(R.id.et_kpn_no).text(gaechSearchResultData.getKpn_no());
        aq.id(R.id.et_kind).text(gaechSearchResultData.getKind());
        aq.id(R.id.et_entity_reg_no).text(gaechSearchResultData.getEntity_reg_no());
        aq.id(R.id.et_entity_gubun).text(gaechSearchResultData.getEntity_gubun());
        aq.id(R.id.et_register_gubun).text(gaechSearchResultData.getRegister_gubun());
        aq.id(R.id.et_reg_no).text(gaechSearchResultData.getReg_no());
        aq.id(R.id.et_reg_dt).text(gaechSearchResultData.getReg_dt());
        aq.id(R.id.et_reg_amt).text(gaechSearchResultData.getReg_amt());
        aq.id(R.id.et_cow_birth).text(gaechSearchResultData.getCow_birth());
        aq.id(R.id.et_cow_sex).text(gaechSearchResultData.getCow_sex());
        aq.id(R.id.et_live_month).text(gaechSearchResultData.getLive_month());
        aq.id(R.id.et_succeeding).text(gaechSearchResultData.getSucceeding());
        aq.id(R.id.et_last_jongbu_dt).text(gaechSearchResultData.getLast_jongbu_dt());
        aq.id(R.id.et_last_breed_dt).text(gaechSearchResultData.getLast_breed_dt());
        aq.id(R.id.et_last_breed_count).text(gaechSearchResultData.getLast_breed_count());
        aq.id(R.id.et_buy_amt).text(gaechSearchResultData.getBuy_amt());
        aq.id(R.id.et_farm_no).text(gaechSearchResultData.getFarm_no());
        aq.id(R.id.et_contract_dt).text(gaechSearchResultData.getContract_dt());
        aq.id(R.id.et_contract_no).text(gaechSearchResultData.getContract_no());
        aq.id(R.id.et_couverture_pay).text(gaechSearchResultData.getCouverture_pay());
        aq.id(R.id.et_participation_dt1).text(gaechSearchResultData.getParticipation_dt1());
        aq.id(R.id.et_participation_dt2).text(gaechSearchResultData.getParticipation_dt2());
        aq.id(R.id.et_brand_yn).text(gaechSearchResultData.getBrand_yn());
        aq.id(R.id.et_grandfather_kpn_no).text(gaechSearchResultData.getGrandfather_kpn_no());
        aq.id(R.id.et_great_grandfather_kpn_no).text(gaechSearchResultData.getGreat_grandfather_kpn_no());
        aq.id(R.id.et_conference_birth).text(gaechSearchResultData.getConference_birth());
        aq.id(R.id.et_conference_addr).text(gaechSearchResultData.getConference_addr());
        aq.id(R.id.et_conference_chuju).text(gaechSearchResultData.getConference_chuju());
        aq.id(R.id.et_conference_breed).text(gaechSearchResultData.getConference_breed());
        aq.id(R.id.et_conference_entity_gubun).text(gaechSearchResultData.getConference_entity_gubun());

    }
    /**
     * private int idx;
     private String chukhyup_name; //축협명
     private String sido;
     private String area1;
     private String area2;
     private String house_code; //농가코드
     private String house_name; //농가명
     private String birth;//생년월일
     private String farm_addr;//목장주소
     private String barcode; //귀표번호
     private String mother_barcode; //어미 귀표번호
     private String mother_gubun; //어미등록구분
     private String impotent_barcode; //공란우귀표번호
     private String kpn_no; //종모우
     private String kind; //품종
     private String entity_reg_no; //개체관리번호
     private String entity_gubun; //개체구분
     private String entity_status; //개체상태
     private String register_gubun; //등록구분
     private String reg_no; //등록번호
     private String reg_dt; //등록일자
     private String reg_amt; //등록비
     private String cow_birth; //생년월일
     private String cow_sex; //성별
     private String month; //월령
     private String succeeding; //축방
     private String last_jongbu_dt; //마지막종부일
     private String last_breed_dt; //마지막분만일
     private String last_breed_count; //마지막산차
     private String buy_amt; //매입금액
     private String farm_no; //이력제 농장번호
     private String contract_dt; //송아지생산(계약일자)
     private String contract_no; //송아지생산(계약번호)
     private String couverture_pay; //송아지생산(보전금지급)
     private String participation_dt1; //한우개량(참여일자)
     private String participation_dt2; //한우경영(참여일자)
     private String brand_yn; //브랜드참여여부
     private String grandfather_kpn_no; //외조부kpn
     private String great_grandfather_kpn_no; //외증조부kpn
     private String conference_birth; //경진대회(생년월일)
     private String conference_addr; //경진대회(축주)
     private String conference_breed; //경진대회(산차)
     private String conference_entity_gubun; //경진대회(개체구분)

     private String live_month;//월령
     */
}
