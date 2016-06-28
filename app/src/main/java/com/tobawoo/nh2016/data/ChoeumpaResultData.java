package com.tobawoo.nh2016.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-06-07.
 */
public class ChoeumpaResultData implements CommonInter,Serializable{

    private int idx;
    private String chukhyup_name; //축협이름
    private String enterprise_organization_name; //고창군한우사업단
    private String house_name; //농가명
    private String barcode;
    private String decipher_yn; //판독여부
    private String month; //월령
    private String sex; //성별
    private String weight; //체중
    private String birth; //생년월일
    private String birth_log;//이력추적 생년월일
    private String measurement_dt; //측정일자
    private String decipher_dt; //판독일자
    private String red_dt; //등록일자
    private String measurement_charge_name; // 측정자
    private String etc01; //등지방두께
    private String etc02; //등심 단면적
    private String etc03; //근내 지방도
    private String etc04; //예상 육량
    private String etc05; //예상 육질

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public String getEnterprise_organization_name() {
        return enterprise_organization_name;
    }

    public void setEnterprise_organization_name(String enterprise_organization_name) {
        this.enterprise_organization_name = enterprise_organization_name;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDecipher_yn() {
        return decipher_yn;
    }

    public void setDecipher_yn(String decipher_yn) {
        this.decipher_yn = decipher_yn;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth_log() {
        return birth_log;
    }

    public void setBirth_log(String birth_log) {
        this.birth_log = birth_log;
    }

    public String getMeasurement_dt() {
        return measurement_dt;
    }

    public void setMeasurement_dt(String measurement_dt) {
        this.measurement_dt = measurement_dt;
    }

    public String getDecipher_dt() {
        return decipher_dt;
    }

    public void setDecipher_dt(String decipher_dt) {
        this.decipher_dt = decipher_dt;
    }

    public String getRed_dt() {
        return red_dt;
    }

    public void setRed_dt(String red_dt) {
        this.red_dt = red_dt;
    }

    public String getMeasurement_charge_name() {
        return measurement_charge_name;
    }

    public void setMeasurement_charge_name(String measurement_charge_name) {
        this.measurement_charge_name = measurement_charge_name;
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

    @Override
    public String toString() {
        return "ChoeumpaResultData{" +
                "idx=" + idx +
                ", chukhyup_name='" + chukhyup_name + '\'' +
                ", enterprise_organization_name='" + enterprise_organization_name + '\'' +
                ", house_name='" + house_name + '\'' +
                ", barcode='" + barcode + '\'' +
                ", decipher_yn='" + decipher_yn + '\'' +
                ", month='" + month + '\'' +
                ", sex='" + sex + '\'' +
                ", weight='" + weight + '\'' +
                ", birth='" + birth + '\'' +
                ", birth_log='" + birth_log + '\'' +
                ", measurement_dt='" + measurement_dt + '\'' +
                ", decipher_dt='" + decipher_dt + '\'' +
                ", red_dt='" + red_dt + '\'' +
                ", measurement_charge_name='" + measurement_charge_name + '\'' +
                ", etc01='" + etc01 + '\'' +
                ", etc02='" + etc02 + '\'' +
                ", etc03='" + etc03 + '\'' +
                ", etc04='" + etc04 + '\'' +
                ", etc05='" + etc05 + '\'' +
                '}';
    }
}
