package com.tobawoo.nh2016.data;

import android.os.Parcel;
import android.os.Parcelable;

public class GyobaeSummaryData implements CommonInter,Parcelable{

    private String chukhyup_name;
    private int breed_0_cnt;
    private int breed_1_cnt;
    private int breed_2_cnt;
    private int breed_3_cnt;
    private int breed_4_cnt;
    private int breed_5_cnt;
    private int breed_over_cnt;
    private int breed_cnt;
    private int mother1_cnt;
    private int mother2_cnt;
    private int mother3_cnt;
    private int mother4_cnt;
    private int mother_cnt;
    private int month_15_cnt;
    private int month_30_cnt;
    private int month_45_cnt;
    private int month_60_cnt;
    private int month_75_cnt;
    private int month_90_cnt;
    private int month_over_cnt;
    private int month_cnt;

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public int getBreed_0_cnt() {
        return breed_0_cnt;
    }

    public void setBreed_0_cnt(int breed_0_cnt) {
        this.breed_0_cnt = breed_0_cnt;
    }

    public int getBreed_1_cnt() {
        return breed_1_cnt;
    }

    public void setBreed_1_cnt(int breed_1_cnt) {
        this.breed_1_cnt = breed_1_cnt;
    }

    public int getBreed_2_cnt() {
        return breed_2_cnt;
    }

    public void setBreed_2_cnt(int breed_2_cnt) {
        this.breed_2_cnt = breed_2_cnt;
    }

    public int getBreed_3_cnt() {
        return breed_3_cnt;
    }

    public void setBreed_3_cnt(int breed_3_cnt) {
        this.breed_3_cnt = breed_3_cnt;
    }

    public int getBreed_4_cnt() {
        return breed_4_cnt;
    }

    public void setBreed_4_cnt(int breed_4_cnt) {
        this.breed_4_cnt = breed_4_cnt;
    }

    public int getBreed_5_cnt() {
        return breed_5_cnt;
    }

    public void setBreed_5_cnt(int breed_5_cnt) {
        this.breed_5_cnt = breed_5_cnt;
    }

    public int getBreed_over_cnt() {
        return breed_over_cnt;
    }

    public void setBreed_over_cnt(int breed_over_cnt) {
        this.breed_over_cnt = breed_over_cnt;
    }

    public int getBreed_cnt() {
        return breed_cnt;
    }

    public void setBreed_cnt(int breed_cnt) {
        this.breed_cnt = breed_cnt;
    }

    public int getMother1_cnt() {
        return mother1_cnt;
    }

    public void setMother1_cnt(int mother1_cnt) {
        this.mother1_cnt = mother1_cnt;
    }

    public int getMother2_cnt() {
        return mother2_cnt;
    }

    public void setMother2_cnt(int mother2_cnt) {
        this.mother2_cnt = mother2_cnt;
    }

    public int getMother3_cnt() {
        return mother3_cnt;
    }

    public void setMother3_cnt(int mother3_cnt) {
        this.mother3_cnt = mother3_cnt;
    }

    public int getMother4_cnt() {
        return mother4_cnt;
    }

    public void setMother4_cnt(int mother4_cnt) {
        this.mother4_cnt = mother4_cnt;
    }

    public int getMother_cnt() {
        return mother_cnt;
    }

    public void setMother_cnt(int mother_cnt) {
        this.mother_cnt = mother_cnt;
    }

    public int getMonth_15_cnt() {
        return month_15_cnt;
    }

    public void setMonth_15_cnt(int month_15_cnt) {
        this.month_15_cnt = month_15_cnt;
    }

    public int getMonth_30_cnt() {
        return month_30_cnt;
    }

    public void setMonth_30_cnt(int month_30_cnt) {
        this.month_30_cnt = month_30_cnt;
    }

    public int getMonth_45_cnt() {
        return month_45_cnt;
    }

    public void setMonth_45_cnt(int month_45_cnt) {
        this.month_45_cnt = month_45_cnt;
    }

    public int getMonth_60_cnt() {
        return month_60_cnt;
    }

    public void setMonth_60_cnt(int month_60_cnt) {
        this.month_60_cnt = month_60_cnt;
    }

    public int getMonth_75_cnt() {
        return month_75_cnt;
    }

    public void setMonth_75_cnt(int month_75_cnt) {
        this.month_75_cnt = month_75_cnt;
    }

    public int getMonth_90_cnt() {
        return month_90_cnt;
    }

    public void setMonth_90_cnt(int month_90_cnt) {
        this.month_90_cnt = month_90_cnt;
    }

    public int getMonth_over_cnt() {
        return month_over_cnt;
    }

    public void setMonth_over_cnt(int month_over_cnt) {
        this.month_over_cnt = month_over_cnt;
    }

    public int getMonth_cnt() {
        return month_cnt;
    }

    public void setMonth_cnt(int month_cnt) {
        this.month_cnt = month_cnt;
    }

    protected GyobaeSummaryData(Parcel in) {
        chukhyup_name = in.readString();
        breed_0_cnt = in.readInt();
        breed_1_cnt = in.readInt();
        breed_2_cnt = in.readInt();
        breed_3_cnt = in.readInt();
        breed_4_cnt = in.readInt();
        breed_5_cnt = in.readInt();
        breed_over_cnt = in.readInt();
        breed_cnt = in.readInt();
        mother1_cnt = in.readInt();
        mother2_cnt = in.readInt();
        mother3_cnt = in.readInt();
        mother4_cnt = in.readInt();
        mother_cnt = in.readInt();
        month_15_cnt = in.readInt();
        month_30_cnt = in.readInt();
        month_45_cnt = in.readInt();
        month_60_cnt = in.readInt();
        month_75_cnt = in.readInt();
        month_90_cnt = in.readInt();
        month_over_cnt = in.readInt();
        month_cnt = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chukhyup_name);
        dest.writeInt(breed_0_cnt);
        dest.writeInt(breed_1_cnt);
        dest.writeInt(breed_2_cnt);
        dest.writeInt(breed_3_cnt);
        dest.writeInt(breed_4_cnt);
        dest.writeInt(breed_5_cnt);
        dest.writeInt(breed_over_cnt);
        dest.writeInt(breed_cnt);
        dest.writeInt(mother1_cnt);
        dest.writeInt(mother2_cnt);
        dest.writeInt(mother3_cnt);
        dest.writeInt(mother4_cnt);
        dest.writeInt(mother_cnt);
        dest.writeInt(month_15_cnt);
        dest.writeInt(month_30_cnt);
        dest.writeInt(month_45_cnt);
        dest.writeInt(month_60_cnt);
        dest.writeInt(month_75_cnt);
        dest.writeInt(month_90_cnt);
        dest.writeInt(month_over_cnt);
        dest.writeInt(month_cnt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GyobaeSummaryData> CREATOR = new Creator<GyobaeSummaryData>() {
        @Override
        public GyobaeSummaryData createFromParcel(Parcel in) {
            return new GyobaeSummaryData(in);
        }

        @Override
        public GyobaeSummaryData[] newArray(int size) {
            return new GyobaeSummaryData[size];
        }
    };
}
