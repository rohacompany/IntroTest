package com.tobawoo.nh2016.data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by tommy on 2016-06-02.
 */
public class GaecheData implements CommonInter,Serializable {


    private String house_code;//농가코드
    private String cow_sex_start,cow_sex_end;

    private HashMap<String,String> paramMap;
    private CommonData commonData;

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    public String getHouse_code() {
        return house_code;
    }

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public HashMap<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(HashMap<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public String getCow_sex_start() {
        return cow_sex_start;
    }

    public void setCow_sex_start(String cow_sex_start) {
        this.cow_sex_start = cow_sex_start;
    }

    public String getCow_sex_end() {
        return cow_sex_end;
    }

    public void setCow_sex_end(String cow_sex_end) {
        this.cow_sex_end = cow_sex_end;
    }
}
