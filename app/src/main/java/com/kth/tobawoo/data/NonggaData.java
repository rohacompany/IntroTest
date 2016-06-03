package com.kth.tobawoo.data;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by tommy on 2016-01-12.
 */
public class NonggaData implements CommonInter,Serializable{


//    private int idx; //고유번호
//    private String chukhyup_name;//축협명
//    private String sido;//시도
//    private String area1; //지역1
//    private String area2; //지역2
//    private String house_code; // 농가-목장번호
//    private String house_gubun;//농가구분
//    private String house_name;//농가명
//    private String sex;//성별
//    private String birth;//생년월일
//    private String zipcode;//우편번호
//    private String house_addr1;//농가기본주소
//    private String house_addr2;//농가도로명주소
//    private String phone;// 전화번호
//    private String fax;//팩스번호
//    private String mobile;//휴대폰
//    private String email;//이메일
//    private String farm_name;//목장명
//    private String farm_zipcode;//계좌번호
//    private String farm_addr1;//목장기본주소
//    private String farm_addr2;//목장상세주소
//    private String farm_addr3;//목장도로명주소
//    private String farm_phone;//목장전화번호
//    private String reg_no;//축산업등록번호
//    private String breed_type;//사육형태
//    private String calf_product;//송아지생산
//    private String improve;//한우개량
//    private String manage;//한우경영
//    private String mail_yn;//우편물수신
//    private String community_name;//자연부락명
//    private String member_yn;//회원여부

    private int idx;
    private String nonga_id;
    private String member_yn;
    private String breed_dosu_start;
    private String breed_dosu_end;
    private String breed_company;
    private String breed_name;

    private CommonData commonData;

    public String[] data;

    public NonggaData(){}

    public NonggaData(String...datas){
        this.data = datas;
    }


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getNonga_id() {
        return nonga_id;
    }

    public void setNonga_id(String nonga_id) {
        this.nonga_id = nonga_id;
    }

    public String getMember_yn() {
        return member_yn;
    }

    public void setMember_yn(String member_yn) {
        this.member_yn = member_yn;
    }

    public String getBreed_dosu_start() {
        return breed_dosu_start;
    }

    public void setBreed_dosu_start(String breed_dosu_start) {
        this.breed_dosu_start = breed_dosu_start;
    }

    public String getBreed_dosu_end() {
        return breed_dosu_end;
    }

    public void setBreed_dosu_end(String breed_dosu_end) {
        this.breed_dosu_end = breed_dosu_end;
    }

    public String getBreed_company() {
        return breed_company;
    }

    public void setBreed_company(String breed_company) {
        this.breed_company = breed_company;
    }

    public String getBreed_name() {
        return breed_name;
    }

    public void setBreed_name(String breed_name) {
        this.breed_name = breed_name;
    }

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    @Override
    public String toString() {
        return "NonggaData{" +
                "idx=" + idx +
                ", nonga_id='" + nonga_id + '\'' +
                ", member_yn='" + member_yn + '\'' +
                ", breed_dosu_start='" + breed_dosu_start + '\'' +
                ", breed_dosu_end='" + breed_dosu_end + '\'' +
                ", breed_company='" + breed_company + '\'' +
                ", breed_name='" + breed_name + '\'' +
                ", commonData=" + commonData +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
