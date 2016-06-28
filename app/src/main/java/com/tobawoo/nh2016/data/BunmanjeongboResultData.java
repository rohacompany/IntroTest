package com.tobawoo.nh2016.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-06-07.
 */
public class BunmanjeongboResultData implements CommonInter,Serializable{
    /*
    idx: "763",
breed_dt: "31/12/2011",
input_dt: "31/12/2011",
sido: "전북",
area1: "고창군",
area2: "흥덕면",
house_name: "(69175-1)김강산",
breed_house_name: "김강산(김강산)",
birth: "601112",
account_no: "521079-56-001869",
farm_addr: "송암리670-4",
farm_phone: "063-562-4913",
farm_mobile: "",
barcode: "KOR-002-064090525",
kind: "한우",
succeeding: "1",
entity_reg_no: "71409017897",
reg_gubun: "혈통",
sancha_chasu: "[2-1]",
kpn_no: "KPN757",
crossbreed_dt: "05/03/2011",
breed_status: "분만확인",
breed_gubun: "정상분만",
fertilization_charge: "강경원",
fertilization_method: "인공수정",
contract_dt: "",
contract_no: "",
participation_dt1: "",
participation_dt2: "",
calf_reg_gubun: "미등록우",
calf_barcode: "KOR-002-073439921",
calf_entity_reg_no: "",
calf_sex: "수",
calf_weight: "25",
etc01: "없음",
etc02: "황색",
etc03: "없음",
etc04: "없음",
etc05: "없음",
etc06: "없음",
etc07: "없음",
status: "출하",
live_month: "",
calf_birth: "",
chukhyup_name: ""
     */
    private int idx;
    private String breed_dt; //분만일자
    private String input_dt; //입력일자
    private String sido; //시도
    private String area1; //시군구명
    private String area2; //읍면동명
    private String house_code; //농가번호
    private String house_name; //농가(목장)
    private String breed_house_name; //분만농가
    private String birth;//생년월일
    private String account_no; //계좌번호
    private String farm_addr; //목장주소
    private String farm_phone; //목장전화번호
    private String farm_mobile; //핸드폰번호
    private String barcode; //어미귀표번호
    private String kind; //품종
    private String succeeding;//계대
    private String entity_reg_no; //개체관리번호
    private String reg_gubun; //분만시 등록구분
    private String sancha_chasu; //산차_차수
    private String kpn_no; //씨수소
    private String crossbreed_dt; //교배일자
    private String breed_status; //분만상태
    private String breed_gubun;//분만구분
    private String fertilization_charge;//수정사
    private String fertilization_method;//수정방법
    private String contract_dt; //송아지생산(계약일자)
    private String contract_no; //송아지생산(계약번호)
    private String participation_dt1; //한우개량(참여일자)
    private String participation_dt2; //한우경영(참여일자)
    private String calf_reg_gubun; //송아지 정보(등록구분)
    private String calf_barcode; //송아지정보(귀표번호)
    private String calf_entity_reg_no; //송아지정보(개체관리NO)
    private String calf_sex; //송아지정보(성별)
    private String calf_weight; //송아지정보(생시체중)
    private String etc01; //송아지정보(이상형질)
    private String etc02; //송아지정보(모색)
    private String etc03; //송아지정보(배선)
    private String etc04; //송아지정보(면선)
    private String etc05; //송아지정보(비경색)
    private String etc06; //송아지정보(미선)
    private String etc07; //송아지정보(이모색)
    private String status; //송아지정보(상태)

    private String live_month; //
    private String calf_birth;

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public String getLive_month() {
        return live_month;
    }

    public void setLive_month(String live_month) {
        this.live_month = live_month;
    }

    public String getCalf_birth() {
        return calf_birth;
    }

    public void setCalf_birth(String calf_birth) {
        this.calf_birth = calf_birth;
    }

    private String chukhyup_name;


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getBreed_dt() {
        return breed_dt;
    }

    public void setBreed_dt(String breed_dt) {
        this.breed_dt = breed_dt;
    }

    public String getInput_dt() {
        return input_dt;
    }

    public void setInput_dt(String input_dt) {
        this.input_dt = input_dt;
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

    public String getBreed_house_name() {
        return breed_house_name;
    }

    public void setBreed_house_name(String breed_house_name) {
        this.breed_house_name = breed_house_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
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

    public String getSucceeding() {
        return succeeding;
    }

    public void setSucceeding(String succeeding) {
        this.succeeding = succeeding;
    }

    public String getEntity_reg_no() {
        return entity_reg_no;
    }

    public void setEntity_reg_no(String entity_reg_no) {
        this.entity_reg_no = entity_reg_no;
    }

    public String getReg_gubun() {
        return reg_gubun;
    }

    public void setReg_gubun(String reg_gubun) {
        this.reg_gubun = reg_gubun;
    }

    public String getSancha_chasu() {
        return sancha_chasu;
    }

    public void setSancha_chasu(String sancha_chasu) {
        this.sancha_chasu = sancha_chasu;
    }

    public String getKpn_no() {
        return kpn_no;
    }

    public void setKpn_no(String kpn_no) {
        this.kpn_no = kpn_no;
    }

    public String getCrossbreed_dt() {
        return crossbreed_dt;
    }

    public void setCrossbreed_dt(String crossbreed_dt) {
        this.crossbreed_dt = crossbreed_dt;
    }

    public String getBreed_status() {
        return breed_status;
    }

    public void setBreed_status(String breed_status) {
        this.breed_status = breed_status;
    }

    public String getBreed_gubun() {
        return breed_gubun;
    }

    public void setBreed_gubun(String breed_gubun) {
        this.breed_gubun = breed_gubun;
    }

    public String getFertilization_charge() {
        return fertilization_charge;
    }

    public void setFertilization_charge(String fertilization_charge) {
        this.fertilization_charge = fertilization_charge;
    }

    public String getFertilization_method() {
        return fertilization_method;
    }

    public void setFertilization_method(String fertilization_method) {
        this.fertilization_method = fertilization_method;
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

    public String getCalf_reg_gubun() {
        return calf_reg_gubun;
    }

    public void setCalf_reg_gubun(String calf_reg_gubun) {
        this.calf_reg_gubun = calf_reg_gubun;
    }

    public String getCalf_barcode() {
        return calf_barcode;
    }

    public void setCalf_barcode(String calf_barcode) {
        this.calf_barcode = calf_barcode;
    }

    public String getCalf_entity_reg_no() {
        return calf_entity_reg_no;
    }

    public void setCalf_entity_reg_no(String calf_entity_reg_no) {
        this.calf_entity_reg_no = calf_entity_reg_no;
    }

    public String getCalf_sex() {
        return calf_sex;
    }

    public void setCalf_sex(String calf_sex) {
        this.calf_sex = calf_sex;
    }

    public String getCalf_weight() {
        return calf_weight;
    }

    public void setCalf_weight(String calf_weight) {
        this.calf_weight = calf_weight;
    }

    public String getEtc01() {
        return etc01;
    }

    public void setEtc01(String etc01) {
        this.etc01 = etc01;
    }

    public String getEtc02() {
        return etc02;
    }

    public void setEtc02(String etc02) {
        this.etc02 = etc02;
    }

    public String getEtc03() {
        return etc03;
    }

    public void setEtc03(String etc03) {
        this.etc03 = etc03;
    }

    public String getEtc04() {
        return etc04;
    }

    public void setEtc04(String etc04) {
        this.etc04 = etc04;
    }

    public String getEtc05() {
        return etc05;
    }

    public void setEtc05(String etc05) {
        this.etc05 = etc05;
    }

    public String getEtc06() {
        return etc06;
    }

    public void setEtc06(String etc06) {
        this.etc06 = etc06;
    }

    public String getEtc07() {
        return etc07;
    }

    public void setEtc07(String etc07) {
        this.etc07 = etc07;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BunmanjeongboResultData{" +
                "idx=" + idx +
                ", breed_dt='" + breed_dt + '\'' +
                ", input_dt='" + input_dt + '\'' +
                ", sido='" + sido + '\'' +
                ", area1='" + area1 + '\'' +
                ", area2='" + area2 + '\'' +
                ", house_name='" + house_name + '\'' +
                ", breed_house_name='" + breed_house_name + '\'' +
                ", birth='" + birth + '\'' +
                ", account_no='" + account_no + '\'' +
                ", farm_addr='" + farm_addr + '\'' +
                ", farm_phone='" + farm_phone + '\'' +
                ", farm_mobile='" + farm_mobile + '\'' +
                ", barcode='" + barcode + '\'' +
                ", kind='" + kind + '\'' +
                ", succeeding='" + succeeding + '\'' +
                ", entity_reg_no='" + entity_reg_no + '\'' +
                ", reg_gubun='" + reg_gubun + '\'' +
                ", sancha_chasu='" + sancha_chasu + '\'' +
                ", kpn_no='" + kpn_no + '\'' +
                ", crossbreed_dt='" + crossbreed_dt + '\'' +
                ", breed_status='" + breed_status + '\'' +
                ", breed_gubun='" + breed_gubun + '\'' +
                ", fertilization_charge='" + fertilization_charge + '\'' +
                ", fertilization_method='" + fertilization_method + '\'' +
                ", contract_dt='" + contract_dt + '\'' +
                ", contract_no='" + contract_no + '\'' +
                ", participation_dt1='" + participation_dt1 + '\'' +
                ", participation_dt2='" + participation_dt2 + '\'' +
                ", calf_reg_gubun='" + calf_reg_gubun + '\'' +
                ", calf_barcode='" + calf_barcode + '\'' +
                ", calf_entity_reg_no='" + calf_entity_reg_no + '\'' +
                ", calf_sex='" + calf_sex + '\'' +
                ", calf_weight='" + calf_weight + '\'' +
                ", etc01='" + etc01 + '\'' +
                ", etc02='" + etc02 + '\'' +
                ", etc03='" + etc03 + '\'' +
                ", etc04='" + etc04 + '\'' +
                ", etc05='" + etc05 + '\'' +
                ", etc06='" + etc06 + '\'' +
                ", etc07='" + etc07 + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
