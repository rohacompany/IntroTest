package com.tobawoo.nh2016.data;

/**
 * Created by tommy on 2016-05-27.
 */
public class Zipcode {
    private String sido;
    private String gugun;
    private String dong;
    private String bunji;
    private String zipcode;

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getBunji() {
        return bunji;
    }

    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Zipcode{" +
                "sido='" + sido + '\'' +
                ", gugun='" + gugun + '\'' +
                ", dong='" + dong + '\'' +
                ", bunji='" + bunji + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
