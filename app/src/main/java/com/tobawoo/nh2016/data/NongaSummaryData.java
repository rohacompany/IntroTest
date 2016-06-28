package com.tobawoo.nh2016.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tommy on 2016-06-11.
 */
public class NongaSummaryData implements CommonInter,Parcelable{


    private int house_member_cnt;
    private int house_nomember_cnt;
    private int house_cnt;
    private int huss_sex_m_cnt;
    private int huss_sex_f_cnt;
    private int huss_sex_n_cnt;
    private int huss_sex_cnt;
    private int huss_gubun1_cnt;
    private int huss_gubun2_cnt;
    private int huss_gubun3_cnt;
    private int huss_gubun4_cnt;
    private int shipment_sex_m_cnt;
    private int shipment_sex_f_cnt;
    private int shipment_sex_n_cnt;
    private int shipment_sex_cnt;
    private String chukhyup_name;


    public NongaSummaryData(Parcel in) {
        house_member_cnt = in.readInt();
        house_nomember_cnt = in.readInt();
        house_cnt = in.readInt();
        huss_sex_m_cnt = in.readInt();
        huss_sex_f_cnt = in.readInt();
        huss_sex_n_cnt = in.readInt();
        huss_sex_cnt = in.readInt();
        huss_gubun1_cnt = in.readInt();
        huss_gubun2_cnt = in.readInt();
        huss_gubun3_cnt = in.readInt();
        huss_gubun4_cnt = in.readInt();
        shipment_sex_m_cnt = in.readInt();
        shipment_sex_f_cnt = in.readInt();
        shipment_sex_n_cnt = in.readInt();
        shipment_sex_cnt = in.readInt();
        chukhyup_name = in.readString();
    }


    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public int getHuss_sex_cnt() {
        return huss_sex_cnt;
    }

    public void setHuss_sex_cnt(int huss_sex_cnt) {
        this.huss_sex_cnt = huss_sex_cnt;
    }

    public int getHuss_sex_n_cnt() {
        return huss_sex_n_cnt;
    }

    public void setHuss_sex_n_cnt(int huss_sex_n_cnt) {
        this.huss_sex_n_cnt = huss_sex_n_cnt;
    }

    public int getHouse_member_cnt() {
        return house_member_cnt;
    }

    public void setHouse_member_cnt(int house_member_cnt) {
        this.house_member_cnt = house_member_cnt;
    }

    public int getHouse_nomember_cnt() {
        return house_nomember_cnt;
    }

    public void setHouse_nomember_cnt(int house_nomember_cnt) {
        this.house_nomember_cnt = house_nomember_cnt;
    }

    public int getHouse_cnt() {
        return house_cnt;
    }

    public void setHouse_cnt(int house_cnt) {
        this.house_cnt = house_cnt;
    }

    public int getHuss_sex_m_cnt() {
        return huss_sex_m_cnt;
    }

    public void setHuss_sex_m_cnt(int huss_sex_m_cnt) {
        this.huss_sex_m_cnt = huss_sex_m_cnt;
    }

    public int getHuss_sex_f_cnt() {
        return huss_sex_f_cnt;
    }

    public void setHuss_sex_f_cnt(int huss_sex_f_cnt) {
        this.huss_sex_f_cnt = huss_sex_f_cnt;
    }

    public int getHuss_gubun1_cnt() {
        return huss_gubun1_cnt;
    }

    public void setHuss_gubun1_cnt(int huss_gubun1_cnt) {
        this.huss_gubun1_cnt = huss_gubun1_cnt;
    }

    public int getHuss_gubun2_cnt() {
        return huss_gubun2_cnt;
    }

    public void setHuss_gubun2_cnt(int huss_gubun2_cnt) {
        this.huss_gubun2_cnt = huss_gubun2_cnt;
    }

    public int getHuss_gubun3_cnt() {
        return huss_gubun3_cnt;
    }

    public void setHuss_gubun3_cnt(int huss_gubun3_cnt) {
        this.huss_gubun3_cnt = huss_gubun3_cnt;
    }

    public int getHuss_gubun4_cnt() {
        return huss_gubun4_cnt;
    }

    public void setHuss_gubun4_cnt(int huss_gubun4_cnt) {
        this.huss_gubun4_cnt = huss_gubun4_cnt;
    }

    public int getShipment_sex_m_cnt() {
        return shipment_sex_m_cnt;
    }

    public void setShipment_sex_m_cnt(int shipment_sex_m_cnt) {
        this.shipment_sex_m_cnt = shipment_sex_m_cnt;
    }

    public int getShipment_sex_f_cnt() {
        return shipment_sex_f_cnt;
    }

    public void setShipment_sex_f_cnt(int shipment_sex_f_cnt) {
        this.shipment_sex_f_cnt = shipment_sex_f_cnt;
    }

    public int getShipment_sex_n_cnt() {
        return shipment_sex_n_cnt;
    }

    public void setShipment_sex_n_cnt(int shipment_sex_n_cnt) {
        this.shipment_sex_n_cnt = shipment_sex_n_cnt;
    }

    public int getShipment_sex_cnt() {
        return shipment_sex_cnt;
    }

    public void setShipment_sex_cnt(int shipment_sex_cnt) {
        this.shipment_sex_cnt = shipment_sex_cnt;
    }

    @Override
    public String toString() {
        return "NongaSummaryData{" +
                "chukhyup_name='" + chukhyup_name + '\'' +
                ", house_member_cnt=" + house_member_cnt +
                ", house_nomember_cnt=" + house_nomember_cnt +
                ", house_cnt=" + house_cnt +
                ", huss_sex_m_cnt=" + huss_sex_m_cnt +
                ", huss_sex_f_cnt=" + huss_sex_f_cnt +
                ", huss_sex_n_cnt=" + huss_sex_n_cnt +
                ", huss_sex_cnt=" + huss_sex_cnt +
                ", huss_gubun1_cnt=" + huss_gubun1_cnt +
                ", huss_gubun2_cnt=" + huss_gubun2_cnt +
                ", huss_gubun3_cnt=" + huss_gubun3_cnt +
                ", huss_gubun4_cnt=" + huss_gubun4_cnt +
                ", shipment_sex_m_cnt=" + shipment_sex_m_cnt +
                ", shipment_sex_f_cnt=" + shipment_sex_f_cnt +
                ", shipment_sex_n_cnt=" + shipment_sex_n_cnt +
                ", shipment_sex_cnt=" + shipment_sex_cnt +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(house_member_cnt);
        dest.writeInt(house_nomember_cnt);
        dest.writeInt(house_cnt);
        dest.writeInt(huss_sex_m_cnt);
        dest.writeInt(huss_sex_f_cnt);
        dest.writeInt(huss_sex_n_cnt);
        dest.writeInt(huss_sex_cnt);
        dest.writeInt(huss_gubun1_cnt);
        dest.writeInt(huss_gubun2_cnt);
        dest.writeInt(huss_gubun3_cnt);
        dest.writeInt(huss_gubun4_cnt);
        dest.writeInt(shipment_sex_m_cnt);
        dest.writeInt(shipment_sex_f_cnt);
        dest.writeInt(shipment_sex_n_cnt);
        dest.writeInt(shipment_sex_cnt);
        dest.writeString(chukhyup_name);
    }

    public static final Creator<NongaSummaryData> CREATOR = new Creator<NongaSummaryData>() {
        @Override
        public NongaSummaryData createFromParcel(Parcel in) {
            return new NongaSummaryData(in);
        }

        @Override
        public NongaSummaryData[] newArray(int size) {
            return new NongaSummaryData[size];
        }
    };
}
