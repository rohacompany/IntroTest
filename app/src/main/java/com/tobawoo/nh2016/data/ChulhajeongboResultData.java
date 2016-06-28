package com.tobawoo.nh2016.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-06-07.
 */
public class ChulhajeongboResultData implements CommonInter,Serializable{
    private int idx;
    private String sido;
    private String area1;
    private String area2;
    private String chukhyup_name; //축협이름
    private String owner; //농가명
    private String barcode; //귀표번호
    private String reg_gubun; //등록구분
    private String reg_no; //등록번호
    private String father_kpn_no; //
    private String mother_barcode;
    private String birth;
    private String birth_weight;
    private String butchery_dt;
    private String butchery_month;
    private String butchery_name;
    private String kind;
    private String sex;
    private String weight;
    private String etc01,etc02,etc03,etc04,etc05,etc06,etc07,etc08,etc09,etc10,etc11,etc12,etc13;

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

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getReg_gubun() {
        return reg_gubun;
    }

    public void setReg_gubun(String reg_gubun) {
        this.reg_gubun = reg_gubun;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getFather_kpn_no() {
        return father_kpn_no;
    }

    public void setFather_kpn_no(String father_kpn_no) {
        this.father_kpn_no = father_kpn_no;
    }

    public String getMother_barcode() {
        return mother_barcode;
    }

    public void setMother_barcode(String mother_barcode) {
        this.mother_barcode = mother_barcode;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth_weight() {
        return birth_weight;
    }

    public void setBirth_weight(String birth_weight) {
        this.birth_weight = birth_weight;
    }

    public String getButchery_dt() {
        return butchery_dt;
    }

    public void setButchery_dt(String butchery_dt) {
        this.butchery_dt = butchery_dt;
    }

    public String getButchery_month() {
        return butchery_month;
    }

    public void setButchery_month(String butchery_month) {
        this.butchery_month = butchery_month;
    }

    public String getButchery_name() {
        return butchery_name;
    }

    public void setButchery_name(String butchery_name) {
        this.butchery_name = butchery_name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getEtc08() {
        return etc08;
    }

    public void setEtc08(String etc08) {
        this.etc08 = etc08;
    }

    public String getEtc09() {
        return etc09;
    }

    public void setEtc09(String etc09) {
        this.etc09 = etc09;
    }

    public String getEtc10() {
        return etc10;
    }

    public void setEtc10(String etc10) {
        this.etc10 = etc10;
    }

    public String getEtc11() {
        return etc11;
    }

    public void setEtc11(String etc11) {
        this.etc11 = etc11;
    }

    public String getEtc12() {
        return etc12;
    }

    public void setEtc12(String etc12) {
        this.etc12 = etc12;
    }

    public String getEtc13() {
        return etc13;
    }

    public void setEtc13(String etc13) {
        this.etc13 = etc13;
    }

    @Override
    public String toString() {
        return "ChulhajeongboResultData{" +
                "idx=" + idx +
                ", sido='" + sido + '\'' +
                ", area1='" + area1 + '\'' +
                ", area2='" + area2 + '\'' +
                ", chukhyup_name='" + chukhyup_name + '\'' +
                ", owner='" + owner + '\'' +
                ", barcode='" + barcode + '\'' +
                ", reg_gubun='" + reg_gubun + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", father_kpn_no='" + father_kpn_no + '\'' +
                ", mother_barcode='" + mother_barcode + '\'' +
                ", birth='" + birth + '\'' +
                ", birth_weight='" + birth_weight + '\'' +
                ", butchery_dt='" + butchery_dt + '\'' +
                ", butchery_month='" + butchery_month + '\'' +
                ", butchery_name='" + butchery_name + '\'' +
                ", kind='" + kind + '\'' +
                ", sex='" + sex + '\'' +
                ", weight='" + weight + '\'' +
                ", etc01='" + etc01 + '\'' +
                ", etc02='" + etc02 + '\'' +
                ", etc03='" + etc03 + '\'' +
                ", etc04='" + etc04 + '\'' +
                ", etc05='" + etc05 + '\'' +
                ", etc06='" + etc06 + '\'' +
                ", etc07='" + etc07 + '\'' +
                ", etc08='" + etc08 + '\'' +
                ", etc09='" + etc09 + '\'' +
                ", etc10='" + etc10 + '\'' +
                ", etc11='" + etc11 + '\'' +
                ", etc12='" + etc12 + '\'' +
                ", etc13='" + etc13 + '\'' +
                '}';
    }
}
