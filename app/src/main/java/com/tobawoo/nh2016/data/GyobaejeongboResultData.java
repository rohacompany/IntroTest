package com.tobawoo.nh2016.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-06-02.
 */
public class GyobaejeongboResultData implements CommonInter,Serializable{
    private int idx;

    private String month; //월령
    private String chukhyup_name; //축협명
    private String sido;
    private String area1;
    private String area2;
    private String house_name; //목장명
    private String farm_no; //이력제농가번호
    private String crossbreed_house; //교배농가
    private String birth; //생년월일
    private String barcode; //귀표번호
    private String kind; //품종
    private String register_gubun; //등록구분
    private String entity_reg_no; //개체관리번호
    private String farm_addr; //목장주소
    private String farm_phone; //목장전화번호
    private String farm_mobile; //핸드폰번호
    private String farm_account_no; //목장계좌번호
    private String crossbreed_dt; //교배일자
    private String input_dt; //입력일자
    private String breed; //산차
    private String chasu; //차수
    private String fertilization_method; //인공수정사
    private String kpn_no;//씨수소
    private String fertilization_charge;



    private String fertilization_no;//수정란번호
    private String fertilization_mother_barcode; //수정란 어미귀표번호
    private String breed_schedule_dt; //분만예정일자
    private String breed_dt; //분만일자
    private String cooperative_no; //조합관리번호
    private String subsidy_yn; //인공수정보조급
    private String nonpayment_sayu;//미지급사유
    private String cooperative_regist_yn;//조합원 가입여부
    private String contract_dt; //송아지생산안정(계약일자)
    private String contract_no; //송아지생산안정(계약번호)
    private String participation_dt1; //한우개량(참여일자)
    private String participation_dt2; //한우경영(참여일자)

    private String live_month;

    public String getLive_month() {
        return live_month;
    }

    public void setLive_month(String live_month) {
        this.live_month = live_month;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getFarm_no() {
        return farm_no;
    }

    public void setFarm_no(String farm_no) {
        this.farm_no = farm_no;
    }

    public String getCrossbreed_house() {
        return crossbreed_house;
    }

    public void setCrossbreed_house(String crossbreed_house) {
        this.crossbreed_house = crossbreed_house;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRegister_gubun() {
        return register_gubun;
    }

    public void setRegister_gubun(String register_gubun) {
        this.register_gubun = register_gubun;
    }

    public String getEntity_reg_no() {
        return entity_reg_no;
    }

    public void setEntity_reg_no(String entity_reg_no) {
        this.entity_reg_no = entity_reg_no;
    }

    public String getFarm_addr() {
        return farm_addr;
    }

    public void setFarm_addr(String farm_addr) {
        this.farm_addr = farm_addr;
    }

    public String getFarm_phone() {
        return farm_phone;
    }

    public void setFarm_phone(String farm_phone) {
        this.farm_phone = farm_phone;
    }

    public String getFarm_mobile() {
        return farm_mobile;
    }

    public void setFarm_mobile(String farm_mobile) {
        this.farm_mobile = farm_mobile;
    }

    public String getFarm_account_no() {
        return farm_account_no;
    }

    public void setFarm_account_no(String farm_account_no) {
        this.farm_account_no = farm_account_no;
    }

    public String getCrossbreed_dt() {
        return crossbreed_dt;
    }

    public void setCrossbreed_dt(String crossbreed_dt) {
        this.crossbreed_dt = crossbreed_dt;
    }

    public String getInput_dt() {
        return input_dt;
    }

    public void setInput_dt(String input_dt) {
        this.input_dt = input_dt;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getChasu() {
        return chasu;
    }

    public void setChasu(String chasu) {
        this.chasu = chasu;
    }

    public String getFertilization_method() {
        return fertilization_method;
    }

    public void setFertilization_method(String fertilization_method) {
        this.fertilization_method = fertilization_method;
    }

    public String getFertilization_no() {
        return fertilization_no;
    }

    public void setFertilization_no(String fertilization_no) {
        this.fertilization_no = fertilization_no;
    }

    public String getFertilization_mother_barcode() {
        return fertilization_mother_barcode;
    }

    public void setFertilization_mother_barcode(String fertilization_mother_barcode) {
        this.fertilization_mother_barcode = fertilization_mother_barcode;
    }

    public String getBreed_schedule_dt() {
        return breed_schedule_dt;
    }

    public void setBreed_schedule_dt(String breed_schedule_dt) {
        this.breed_schedule_dt = breed_schedule_dt;
    }

    public String getBreed_dt() {
        return breed_dt;
    }

    public void setBreed_dt(String breed_dt) {
        this.breed_dt = breed_dt;
    }

    public String getCooperative_no() {
        return cooperative_no;
    }

    public void setCooperative_no(String cooperative_no) {
        this.cooperative_no = cooperative_no;
    }

    public String getSubsidy_yn() {
        return subsidy_yn;
    }

    public void setSubsidy_yn(String subsidy_yn) {
        this.subsidy_yn = subsidy_yn;
    }

    public String getNonpayment_sayu() {
        return nonpayment_sayu;
    }

    public void setNonpayment_sayu(String nonpayment_sayu) {
        this.nonpayment_sayu = nonpayment_sayu;
    }

    public String getCooperative_regist_yn() {
        return cooperative_regist_yn;
    }

    public void setCooperative_regist_yn(String cooperative_regist_yn) {
        this.cooperative_regist_yn = cooperative_regist_yn;
    }

    public String getContract_dt() {
        return contract_dt;
    }

    public void setContract_dt(String contract_dt) {
        this.contract_dt = contract_dt;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public String getParticipation_dt1() {
        return participation_dt1;
    }

    public void setParticipation_dt1(String participation_dt1) {
        this.participation_dt1 = participation_dt1;
    }

    public String getParticipation_dt2() {
        return participation_dt2;
    }

    public void setParticipation_dt2(String participation_dt2) {
        this.participation_dt2 = participation_dt2;
    }


    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }



    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public String getKpn_no() {
        return kpn_no;
    }

    public void setKpn_no(String kpn_no) {
        this.kpn_no = kpn_no;
    }

    public String getFertilization_charge() {
        return fertilization_charge;
    }

    public void setFertilization_charge(String fertilization_charge) {
        this.fertilization_charge = fertilization_charge;
    }

    @Override
    public String toString() {
        return "GyobaejeongboResultData{" +
                "idx=" + idx +
                ", chukhyup_name='" + chukhyup_name + '\'' +
                ", sido='" + sido + '\'' +
                ", area1='" + area1 + '\'' +
                ", area2='" + area2 + '\'' +
                ", house_name='" + house_name + '\'' +
                ", farm_no='" + farm_no + '\'' +
                ", crossbreed_house='" + crossbreed_house + '\'' +
                ", birth='" + birth + '\'' +
                ", barcode='" + barcode + '\'' +
                ", kind='" + kind + '\'' +
                ", register_gubun='" + register_gubun + '\'' +
                ", entity_reg_no='" + entity_reg_no + '\'' +
                ", farm_addr='" + farm_addr + '\'' +
                ", farm_phone='" + farm_phone + '\'' +
                ", farm_mobile='" + farm_mobile + '\'' +
                ", farm_account_no='" + farm_account_no + '\'' +
                ", crossbreed_dt='" + crossbreed_dt + '\'' +
                ", input_dt='" + input_dt + '\'' +
                ", breed='" + breed + '\'' +
                ", chasu='" + chasu + '\'' +
                ", fertilization_method='" + fertilization_method + '\'' +
                ", fertilization_no='" + fertilization_no + '\'' +
                ", fertilization_mother_barcode='" + fertilization_mother_barcode + '\'' +
                ", breed_schedule_dt='" + breed_schedule_dt + '\'' +
                ", breed_dt='" + breed_dt + '\'' +
                ", cooperative_no='" + cooperative_no + '\'' +
                ", subsidy_yn='" + subsidy_yn + '\'' +
                ", nonpayment_sayu='" + nonpayment_sayu + '\'' +
                ", cooperative_regist_yn='" + cooperative_regist_yn + '\'' +
                ", contract_dt='" + contract_dt + '\'' +
                ", contract_no='" + contract_no + '\'' +
                ", participation_dt1='" + participation_dt1 + '\'' +
                ", participation_dt2='" + participation_dt2 + '\'' +
                '}';
    }
}
