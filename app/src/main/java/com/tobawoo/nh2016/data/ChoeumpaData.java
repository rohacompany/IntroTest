package com.tobawoo.nh2016.data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by tommy on 2016-06-07.
 */
public class ChoeumpaData implements CommonInter,Serializable{
    private CommonData commonData = null;
    private HashMap<String,String> paramMap;

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    public HashMap<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(HashMap<String, String> paramMap) {
        this.paramMap = paramMap;
    }
}
