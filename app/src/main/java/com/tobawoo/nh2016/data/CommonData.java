package com.tobawoo.nh2016.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tommy on 2016-06-01.
 */
public class CommonData implements Serializable{
    private String sido;
    @SerializedName("area1") private String gubun;
    @SerializedName("area2") private String dong;
    private String chukhyup_name; //축협명
    private String house_name; //농가이름
    private String pumjong;  //품종
    private String sex; //성별
    private String breed_type; //사육형태
    private String deungrokgubun; //등록구분
    private String gwipyobeonho; //귀표번호
    private String mom_gwipyobeonho;  //어미 귀표번호
    private String abissisusobeonho; //아비씨 수소번호
    private String wolryeong_start; //월령 시작
    private String wolryeong_end; //월령 끝
    private String sancha_start; //산차 시작
    private String sancha_end; //산차 끝


    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getPumjong() {
        return pumjong;
    }

    public void setPumjong(String pumjong) {
        this.pumjong = pumjong;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed_type() {
        return breed_type;
    }

    public void setBreed_type(String breed_type) {
        this.breed_type = breed_type;
    }

    public String getDeungrokgubun() {
        return deungrokgubun;
    }

    public void setDeungrokgubun(String deungrokgubun) {
        this.deungrokgubun = deungrokgubun;
    }

    public String getGwipyobeonho() {
        return gwipyobeonho;
    }

    public void setGwipyobeonho(String gwipyobeonho) {
        this.gwipyobeonho = gwipyobeonho;
    }

    public String getMom_gwipyobeonho() {
        return mom_gwipyobeonho;
    }

    public void setMom_gwipyobeonho(String mom_gwipyobeonho) {
        this.mom_gwipyobeonho = mom_gwipyobeonho;
    }

    public String getAbissisusobeonho() {
        return abissisusobeonho;
    }

    public void setAbissisusobeonho(String abissisusobeonho) {
        this.abissisusobeonho = abissisusobeonho;
    }

    public String getWolryeong_start() {
        return wolryeong_start;
    }

    public void setWolryeong_start(String wolryeong_start) {
        this.wolryeong_start = wolryeong_start;
    }

    public String getWolryeong_end() {
        return wolryeong_end;
    }

    public void setWolryeong_end(String wolryeong_end) {
        this.wolryeong_end = wolryeong_end;
    }

    public String getSancha_start() {
        return sancha_start;
    }

    public void setSancha_start(String sancha_start) {
        this.sancha_start = sancha_start;
    }

    public String getSancha_end() {
        return sancha_end;
    }

    public void setSancha_end(String sancha_end) {
        this.sancha_end = sancha_end;
    }

    @Override
    public String toString() {
        return "CommonData{" +
                "sido='" + sido + '\'' +
                ", gubun='" + gubun + '\'' +
                ", dong='" + dong + '\'' +
                ", chukhyup_name='" + chukhyup_name + '\'' +
                ", house_name='" + house_name + '\'' +
                ", pumjong='" + pumjong + '\'' +
                ", sex='" + sex + '\'' +
                ", breed_type='" + breed_type + '\'' +
                ", deungrokgubun='" + deungrokgubun + '\'' +
                ", gwipyobeonho='" + gwipyobeonho + '\'' +
                ", mom_gwipyobeonho='" + mom_gwipyobeonho + '\'' +
                ", abissisusobeonho='" + abissisusobeonho + '\'' +
                ", wolryeong_start='" + wolryeong_start + '\'' +
                ", wolryeong_end='" + wolryeong_end + '\'' +
                ", sancha_start='" + sancha_start + '\'' +
                ", sancha_end='" + sancha_end + '\'' +
                '}';
    }
}
