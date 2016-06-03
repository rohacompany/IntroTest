package com.kth.tobawoo.data;

/**
 * Created by tommy on 2016-06-02.
 */
public class GaechSearchResultData implements CommonInter{

    private int idx;



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

    public String getHouse_code() {
        return house_code;
    }

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFarm_addr() {
        return farm_addr;
    }

    public void setFarm_addr(String farm_addr) {
        this.farm_addr = farm_addr;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getMother_barcode() {
        return mother_barcode;
    }

    public void setMother_barcode(String mother_barcode) {
        this.mother_barcode = mother_barcode;
    }

    public String getMother_gubun() {
        return mother_gubun;
    }

    public void setMother_gubun(String mother_gubun) {
        this.mother_gubun = mother_gubun;
    }

    public String getImpotent_barcode() {
        return impotent_barcode;
    }

    public void setImpotent_barcode(String impotent_barcode) {
        this.impotent_barcode = impotent_barcode;
    }

    public String getKpn_no() {
        return kpn_no;
    }

    public void setKpn_no(String kpn_no) {
        this.kpn_no = kpn_no;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEntity_reg_no() {
        return entity_reg_no;
    }

    public void setEntity_reg_no(String entity_reg_no) {
        this.entity_reg_no = entity_reg_no;
    }

    public String getEntity_gubun() {
        return entity_gubun;
    }

    public void setEntity_gubun(String entity_gubun) {
        this.entity_gubun = entity_gubun;
    }

    public String getEntity_status() {
        return entity_status;
    }

    public void setEntity_status(String entity_status) {
        this.entity_status = entity_status;
    }

    public String getRegister_gubun() {
        return register_gubun;
    }

    public void setRegister_gubun(String register_gubun) {
        this.register_gubun = register_gubun;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getReg_amt() {
        return reg_amt;
    }

    public void setReg_amt(String reg_amt) {
        this.reg_amt = reg_amt;
    }

    public String getCow_birth() {
        return cow_birth;
    }

    public void setCow_birth(String cow_birth) {
        this.cow_birth = cow_birth;
    }

    public String getCow_sex() {
        return cow_sex;
    }

    public void setCow_sex(String cow_sex) {
        this.cow_sex = cow_sex;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSucceeding() {
        return succeeding;
    }

    public void setSucceeding(String succeeding) {
        this.succeeding = succeeding;
    }

    public String getLast_jongbu_dt() {
        return last_jongbu_dt;
    }

    public void setLast_jongbu_dt(String last_jongbu_dt) {
        this.last_jongbu_dt = last_jongbu_dt;
    }

    public String getLast_breed_dt() {
        return last_breed_dt;
    }

    public void setLast_breed_dt(String last_breed_dt) {
        this.last_breed_dt = last_breed_dt;
    }

    public String getLast_breed_count() {
        return last_breed_count;
    }

    public void setLast_breed_count(String last_breed_count) {
        this.last_breed_count = last_breed_count;
    }

    public String getBuy_amt() {
        return buy_amt;
    }

    public void setBuy_amt(String buy_amt) {
        this.buy_amt = buy_amt;
    }

    public String getFarm_no() {
        return farm_no;
    }

    public void setFarm_no(String farm_no) {
        this.farm_no = farm_no;
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

    public String getCouverture_pay() {
        return couverture_pay;
    }

    public void setCouverture_pay(String couverture_pay) {
        this.couverture_pay = couverture_pay;
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

    public String getBrand_yn() {
        return brand_yn;
    }

    public void setBrand_yn(String brand_yn) {
        this.brand_yn = brand_yn;
    }

    public String getGrandfather_kpn_no() {
        return grandfather_kpn_no;
    }

    public void setGrandfather_kpn_no(String grandfather_kpn_no) {
        this.grandfather_kpn_no = grandfather_kpn_no;
    }

    public String getGreat_grandfather_kpn_no() {
        return great_grandfather_kpn_no;
    }

    public void setGreat_grandfather_kpn_no(String great_grandfather_kpn_no) {
        this.great_grandfather_kpn_no = great_grandfather_kpn_no;
    }

    public String getConference_birth() {
        return conference_birth;
    }

    public void setConference_birth(String conference_birth) {
        this.conference_birth = conference_birth;
    }

    public String getConference_addr() {
        return conference_addr;
    }

    public void setConference_addr(String conference_addr) {
        this.conference_addr = conference_addr;
    }

    public String getConference_breed() {
        return conference_breed;
    }

    public void setConference_breed(String conference_breed) {
        this.conference_breed = conference_breed;
    }

    public String getConference_entity_gubun() {
        return conference_entity_gubun;
    }

    public void setConference_entity_gubun(String conference_entity_gubun) {
        this.conference_entity_gubun = conference_entity_gubun;
    }

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    @Override
    public String toString() {
        return "GaechSearchResultData{" +
                "idx=" + idx +
                ", sido='" + sido + '\'' +
                ", area1='" + area1 + '\'' +
                ", area2='" + area2 + '\'' +
                ", house_code='" + house_code + '\'' +
                ", house_name='" + house_name + '\'' +
                ", birth='" + birth + '\'' +
                ", farm_addr='" + farm_addr + '\'' +
                ", barcode='" + barcode + '\'' +
                ", mother_barcode='" + mother_barcode + '\'' +
                ", mother_gubun='" + mother_gubun + '\'' +
                ", impotent_barcode='" + impotent_barcode + '\'' +
                ", kpn_no='" + kpn_no + '\'' +
                ", kind='" + kind + '\'' +
                ", entity_reg_no='" + entity_reg_no + '\'' +
                ", entity_gubun='" + entity_gubun + '\'' +
                ", entity_status='" + entity_status + '\'' +
                ", register_gubun='" + register_gubun + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", reg_dt='" + reg_dt + '\'' +
                ", reg_amt='" + reg_amt + '\'' +
                ", cow_birth='" + cow_birth + '\'' +
                ", cow_sex='" + cow_sex + '\'' +
                ", month='" + month + '\'' +
                ", succeeding='" + succeeding + '\'' +
                ", last_jongbu_dt='" + last_jongbu_dt + '\'' +
                ", last_breed_dt='" + last_breed_dt + '\'' +
                ", last_breed_count='" + last_breed_count + '\'' +
                ", buy_amt='" + buy_amt + '\'' +
                ", farm_no='" + farm_no + '\'' +
                ", contract_dt='" + contract_dt + '\'' +
                ", contract_no='" + contract_no + '\'' +
                ", couverture_pay='" + couverture_pay + '\'' +
                ", participation_dt1='" + participation_dt1 + '\'' +
                ", participation_dt2='" + participation_dt2 + '\'' +
                ", brand_yn='" + brand_yn + '\'' +
                ", grandfather_kpn_no='" + grandfather_kpn_no + '\'' +
                ", great_grandfather_kpn_no='" + great_grandfather_kpn_no + '\'' +
                ", conference_birth='" + conference_birth + '\'' +
                ", conference_addr='" + conference_addr + '\'' +
                ", conference_breed='" + conference_breed + '\'' +
                ", conference_entity_gubun='" + conference_entity_gubun + '\'' +
                '}';
    }
}
