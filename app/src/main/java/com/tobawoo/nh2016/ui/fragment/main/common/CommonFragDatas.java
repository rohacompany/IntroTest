package com.tobawoo.nh2016.ui.fragment.main.common;

import android.view.Gravity;

import com.tobawoo.nh2016.data.CommonTableData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016-06-23.
 */
public class CommonFragDatas {

    public static List<CommonTableData> getGaecheHeaderList(){
        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("귀표번호", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("축협",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("시군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("구군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("읍면동",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가코드",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("성별",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생년월일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("월령", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등록구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("개체상태",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("마지막종부일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("마지막분만일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("마지막산차",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("계대",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("어미귀표번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("어미혈통",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("씨수소",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("외조부",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("외증조부",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("개체구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("개체관리번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("목장주소",Gravity.CENTER_VERTICAL|Gravity.LEFT,300));
        return tabDataList;
    }

    public static List<CommonTableData> getGyobaeHeaderList(){
        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("귀표번호", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("축협",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("시군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("구군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("읍면동",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등록구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("산차",Gravity.CENTER,50));
        tabDataList.add(new CommonTableData("생년월일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("월령", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("교배일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("씨수소",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("교배일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("씨수소",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("교배일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("씨수소",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("분만예정일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("분만일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("인공수정사",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("개체관리번호",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("목장주소",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("목장전화번호",Gravity.CENTER,150));
        tabDataList.add(new CommonTableData("핸드폰번호",Gravity.CENTER,150));
        return tabDataList;
    }

    public static List<CommonTableData> getBunmanHeaderList(){
        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("귀표번호", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("축협",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("시군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("구군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("읍면동",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생년월일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("월령", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("분만일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("교배일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("분만간격",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("계대",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("분만시등록구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("산차차수",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("씨수소(종모우)",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등록구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("귀표번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("생년월일",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("성별",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생시체중",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("상태",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("모색",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("배선",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("비경색",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("미선",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("이모색",Gravity.CENTER,100));
        return  tabDataList;
    }

    public static List<CommonTableData> getChulhajeongboHeaderList(){
        List<CommonTableData> tabDataList = new ArrayList<CommonTableData>();
        tabDataList.add(new CommonTableData("귀표번호", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("농가명",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("축협",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("시군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("구군",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("성별",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등록구분",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생년월일", Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("출하일자",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("월령",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("어미귀표번호",Gravity.CENTER,200));
        tabDataList.add(new CommonTableData("아비KPN",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("생체중",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("도체중",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("육량지수",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등지방두께",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("등심단면적",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("근내지방도",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("육량등급",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("육질등급",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("경락단가",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("판매금액",Gravity.CENTER,100));
        tabDataList.add(new CommonTableData("도축번호",Gravity.CENTER,100));
        return tabDataList;
    }
}
