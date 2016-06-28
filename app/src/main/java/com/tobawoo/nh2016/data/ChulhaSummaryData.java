package com.tobawoo.nh2016.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tommy on 2016-06-12.
 */
public class ChulhaSummaryData implements Parcelable{
    private String chukhyup_name; //축협이름
    private int sex_f_cnt;
    private int sex_m_cnt;
    private int sex_n_cnt;
    private int sex_cnt;

    private int birth_weight;
    private float weight;
    private double etc02;
    private double etc01;
    private double etc03;
    private double etc10;
    private double etc08;

    private int one_p_p_cnt;
    private int one_p_cnt;
    private int one_cnt;
    private int one_total_cnt;
    private int two_cnt;
    private int three_cnt;

    private int etc11;
    private int a_cnt;
    private int b_cnt;
    private int c_cnt;
    private int d_cnt;
    private double etc12;

    private float sex_f_per,
            sex_m_per,
            sex_n_per,
            sex_per,
            one_p_p_per,
            one_p_per,
            one_per,
            one_total_per,
            two_per,
            three_per,
            etc11_per,
            a_per,
            b_per,
            c_per,
            d_per,
            etc12_per;


    protected ChulhaSummaryData(Parcel in) {
        chukhyup_name = in.readString();
        sex_f_cnt = in.readInt();
        sex_m_cnt = in.readInt();
        sex_n_cnt = in.readInt();
        sex_cnt = in.readInt();
        birth_weight = in.readInt();
        weight = in.readFloat();
        etc02 = in.readDouble();
        etc01 = in.readDouble();
        etc03 = in.readDouble();
        etc10 = in.readDouble();
        etc08 = in.readDouble();
        one_p_p_cnt = in.readInt();
        one_p_cnt = in.readInt();
        one_cnt = in.readInt();
        one_total_cnt = in.readInt();
        two_cnt = in.readInt();
        three_cnt = in.readInt();
        etc11 = in.readInt();
        a_cnt = in.readInt();
        b_cnt = in.readInt();
        c_cnt = in.readInt();
        d_cnt = in.readInt();
        etc12 = in.readDouble();
        sex_f_per = in.readFloat();
        sex_m_per = in.readFloat();
        sex_n_per = in.readFloat();
        sex_per = in.readFloat();
        one_p_p_per = in.readFloat();
        one_p_per = in.readFloat();
        one_per = in.readFloat();
        one_total_per = in.readFloat();
        two_per = in.readFloat();
        three_per = in.readFloat();
        etc11_per = in.readFloat();
        a_per = in.readFloat();
        b_per = in.readFloat();
        c_per = in.readFloat();
        d_per = in.readFloat();
        etc12_per = in.readFloat();
    }

    public static final Creator<ChulhaSummaryData> CREATOR = new Creator<ChulhaSummaryData>() {
        @Override
        public ChulhaSummaryData createFromParcel(Parcel in) {
            return new ChulhaSummaryData(in);
        }

        @Override
        public ChulhaSummaryData[] newArray(int size) {
            return new ChulhaSummaryData[size];
        }
    };

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public int getSex_f_cnt() {
        return sex_f_cnt;
    }

    public void setSex_f_cnt(int sex_f_cnt) {
        this.sex_f_cnt = sex_f_cnt;
    }

    public int getSex_m_cnt() {
        return sex_m_cnt;
    }

    public void setSex_m_cnt(int sex_m_cnt) {
        this.sex_m_cnt = sex_m_cnt;
    }

    public int getSex_n_cnt() {
        return sex_n_cnt;
    }

    public void setSex_n_cnt(int sex_n_cnt) {
        this.sex_n_cnt = sex_n_cnt;
    }

    public int getSex_cnt() {
        return sex_cnt;
    }

    public void setSex_cnt(int sex_cnt) {
        this.sex_cnt = sex_cnt;
    }

    public int getBirth_weight() {
        return birth_weight;
    }

    public void setBirth_weight(int birth_weight) {
        this.birth_weight = birth_weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getEtc02() {
        return etc02;
    }

    public void setEtc02(double etc02) {
        this.etc02 = etc02;
    }

    public double getEtc01() {
        return etc01;
    }

    public void setEtc01(double etc01) {
        this.etc01 = etc01;
    }

    public double getEtc03() {
        return etc03;
    }

    public void setEtc03(double etc03) {
        this.etc03 = etc03;
    }

    public double getEtc10() {
        return etc10;
    }

    public void setEtc10(double etc10) {
        this.etc10 = etc10;
    }

    public double getEtc08() {
        return etc08;
    }

    public void setEtc08(double etc08) {
        this.etc08 = etc08;
    }

    public void setEtc12(double etc12) {
        this.etc12 = etc12;
    }

    public void setEtc08(int etc08) {
        this.etc08 = etc08;
    }

    public int getOne_p_p_cnt() {
        return one_p_p_cnt;
    }

    public void setOne_p_p_cnt(int one_p_p_cnt) {
        this.one_p_p_cnt = one_p_p_cnt;
    }

    public int getOne_p_cnt() {
        return one_p_cnt;
    }

    public void setOne_p_cnt(int one_p_cnt) {
        this.one_p_cnt = one_p_cnt;
    }

    public int getOne_cnt() {
        return one_cnt;
    }

    public void setOne_cnt(int one_cnt) {
        this.one_cnt = one_cnt;
    }

    public int getOne_total_cnt() {
        return one_total_cnt;
    }

    public void setOne_total_cnt(int one_total_cnt) {
        this.one_total_cnt = one_total_cnt;
    }

    public int getTwo_cnt() {
        return two_cnt;
    }

    public void setTwo_cnt(int two_cnt) {
        this.two_cnt = two_cnt;
    }

    public int getThree_cnt() {
        return three_cnt;
    }

    public void setThree_cnt(int three_cnt) {
        this.three_cnt = three_cnt;
    }

    public int getEtc11() {
        return etc11;
    }

    public void setEtc11(int etc11) {
        this.etc11 = etc11;
    }

    public int getA_cnt() {
        return a_cnt;
    }

    public void setA_cnt(int a_cnt) {
        this.a_cnt = a_cnt;
    }

    public int getB_cnt() {
        return b_cnt;
    }

    public void setB_cnt(int b_cnt) {
        this.b_cnt = b_cnt;
    }

    public int getC_cnt() {
        return c_cnt;
    }

    public void setC_cnt(int c_cnt) {
        this.c_cnt = c_cnt;
    }

    public int getD_cnt() {
        return d_cnt;
    }

    public void setD_cnt(int d_cnt) {
        this.d_cnt = d_cnt;
    }

    public double getEtc12() {
        return etc12;
    }

    public float getSex_f_per() {
        return sex_f_per;
    }

    public void setSex_f_per(float sex_f_per) {
        this.sex_f_per = sex_f_per;
    }

    public float getSex_m_per() {
        return sex_m_per;
    }

    public void setSex_m_per(float sex_m_per) {
        this.sex_m_per = sex_m_per;
    }

    public float getSex_n_per() {
        return sex_n_per;
    }

    public void setSex_n_per(float sex_n_per) {
        this.sex_n_per = sex_n_per;
    }

    public float getSex_per() {
        return sex_per;
    }

    public void setSex_per(float sex_per) {
        this.sex_per = sex_per;
    }

    public float getOne_p_p_per() {
        return one_p_p_per;
    }

    public void setOne_p_p_per(float one_p_p_per) {
        this.one_p_p_per = one_p_p_per;
    }

    public float getOne_p_per() {
        return one_p_per;
    }

    public void setOne_p_per(float one_p_per) {
        this.one_p_per = one_p_per;
    }

    public float getOne_per() {
        return one_per;
    }

    public void setOne_per(float one_per) {
        this.one_per = one_per;
    }

    public float getOne_total_per() {
        return one_total_per;
    }

    public void setOne_total_per(float one_total_per) {
        this.one_total_per = one_total_per;
    }

    public float getTwo_per() {
        return two_per;
    }

    public void setTwo_per(float two_per) {
        this.two_per = two_per;
    }

    public float getThree_per() {
        return three_per;
    }

    public void setThree_per(float three_per) {
        this.three_per = three_per;
    }

    public float getEtc11_per() {
        return etc11_per;
    }

    public void setEtc11_per(float etc11_per) {
        this.etc11_per = etc11_per;
    }

    public float getA_per() {
        return a_per;
    }

    public void setA_per(float a_per) {
        this.a_per = a_per;
    }

    public float getB_per() {
        return b_per;
    }

    public void setB_per(float b_per) {
        this.b_per = b_per;
    }

    public float getC_per() {
        return c_per;
    }

    public void setC_per(float c_per) {
        this.c_per = c_per;
    }

    public float getD_per() {
        return d_per;
    }

    public void setD_per(float d_per) {
        this.d_per = d_per;
    }

    public float getEtc12_per() {
        return etc12_per;
    }

    public void setEtc12_per(float etc12_per) {
        this.etc12_per = etc12_per;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chukhyup_name);
        dest.writeInt(sex_f_cnt);
        dest.writeInt(sex_m_cnt);
        dest.writeInt(sex_n_cnt);
        dest.writeInt(sex_cnt);
        dest.writeInt(birth_weight);
        dest.writeFloat(weight);
        dest.writeDouble(etc02);
        dest.writeDouble(etc01);
        dest.writeDouble(etc03);
        dest.writeDouble(etc10);
        dest.writeDouble(etc08);
        dest.writeInt(one_p_p_cnt);
        dest.writeInt(one_p_cnt);
        dest.writeInt(one_cnt);
        dest.writeInt(one_total_cnt);
        dest.writeInt(two_cnt);
        dest.writeInt(three_cnt);
        dest.writeInt(etc11);
        dest.writeInt(a_cnt);
        dest.writeInt(b_cnt);
        dest.writeInt(c_cnt);
        dest.writeInt(d_cnt);
        dest.writeDouble(etc12);
        dest.writeFloat(sex_f_per);
        dest.writeFloat(sex_m_per);
        dest.writeFloat(sex_n_per);
        dest.writeFloat(sex_per);
        dest.writeFloat(one_p_p_per);
        dest.writeFloat(one_p_per);
        dest.writeFloat(one_per);
        dest.writeFloat(one_total_per);
        dest.writeFloat(two_per);
        dest.writeFloat(three_per);
        dest.writeFloat(etc11_per);
        dest.writeFloat(a_per);
        dest.writeFloat(b_per);
        dest.writeFloat(c_per);
        dest.writeFloat(d_per);
        dest.writeFloat(etc12_per);
    }

    @Override
    public String toString() {
        return "ChulhaSummaryData{" +
                "chukhyup_name='" + chukhyup_name + '\'' +
                ", sex_f_cnt=" + sex_f_cnt +
                ", sex_m_cnt=" + sex_m_cnt +
                ", sex_n_cnt=" + sex_n_cnt +
                ", sex_cnt=" + sex_cnt +
                ", birth_weight=" + birth_weight +
                ", weight=" + weight +
                ", etc02=" + etc02 +
                ", etc01=" + etc01 +
                ", etc03=" + etc03 +
                ", etc10=" + etc10 +
                ", etc08=" + etc08 +
                ", one_p_p_cnt=" + one_p_p_cnt +
                ", one_p_cnt=" + one_p_cnt +
                ", one_cnt=" + one_cnt +
                ", one_total_cnt=" + one_total_cnt +
                ", two_cnt=" + two_cnt +
                ", three_cnt=" + three_cnt +
                ", etc11=" + etc11 +
                ", a_cnt=" + a_cnt +
                ", b_cnt=" + b_cnt +
                ", c_cnt=" + c_cnt +
                ", d_cnt=" + d_cnt +
                ", etc12=" + etc12 +
                ", sex_f_per=" + sex_f_per +
                ", sex_m_per=" + sex_m_per +
                ", sex_n_per=" + sex_n_per +
                ", sex_per=" + sex_per +
                ", one_p_p_per=" + one_p_p_per +
                ", one_p_per=" + one_p_per +
                ", one_per=" + one_per +
                ", one_total_per=" + one_total_per +
                ", two_per=" + two_per +
                ", three_per=" + three_per +
                ", etc11_per=" + etc11_per +
                ", a_per=" + a_per +
                ", b_per=" + b_per +
                ", c_per=" + c_per +
                ", d_per=" + d_per +
                ", etc12_per=" + etc12_per +
                '}';
    }
}
