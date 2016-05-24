package com.kth.tobawoo.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-02-16.
 */
public class NonggaSearchResultData implements Serializable{
    private int no;
    private String nongga_id; //농가아이디
    private String chukju_name;//축주명
    private String nongga_code; //농가코드
    private String nongga_member_code;//회원농가
    private String nongga_address;//농가주소
    private String nongga_phone_number; //휴대폰
    private String nongga_home_number; //집번호

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNongga_id() {
        return nongga_id;
    }

    public void setNongga_id(String nongga_id) {
        this.nongga_id = nongga_id;
    }

    public String getChukju_name() {
        return chukju_name;
    }

    public void setChukju_name(String chukju_name) {
        this.chukju_name = chukju_name;
    }

    public String getNongga_code() {
        return nongga_code;
    }

    public void setNongga_code(String nongga_code) {
        this.nongga_code = nongga_code;
    }

    public String getNongga_member_code() {
        return nongga_member_code;
    }

    public void setNongga_member_code(String nongga_member_code) {
        this.nongga_member_code = nongga_member_code;
    }

    public String getNongga_address() {
        return nongga_address;
    }

    public void setNongga_address(String nongga_address) {
        this.nongga_address = nongga_address;
    }

    public String getNongga_phone_number() {
        return nongga_phone_number;
    }

    public void setNongga_phone_number(String nongga_phone_number) {
        this.nongga_phone_number = nongga_phone_number;
    }

    public String getNongga_home_number() {
        return nongga_home_number;
    }

    public void setNongga_home_number(String nongga_home_number) {
        this.nongga_home_number = nongga_home_number;
    }

    @Override
    public String toString() {
        return "NonggaSearchResultData{" +
                "no=" + no +
                ", nongga_id='" + nongga_id + '\'' +
                ", chukju_name='" + chukju_name + '\'' +
                ", nongga_code='" + nongga_code + '\'' +
                ", nongga_member_code='" + nongga_member_code + '\'' +
                ", nongga_address='" + nongga_address + '\'' +
                ", nongga_phone_number='" + nongga_phone_number + '\'' +
                ", nongga_home_number='" + nongga_home_number + '\'' +
                '}';
    }
}
