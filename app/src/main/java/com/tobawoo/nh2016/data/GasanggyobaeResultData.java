package com.tobawoo.nh2016.data;

public class GasanggyobaeResultData implements CommonInter{
    private String mengho;
    private String kpn_no;
    private String geungyogyesu;
    private String geungyogyesu_level;
    private String do_weight;
    private String deungsimdanmyeonjeok;
    private String deungjibangdukke;
    private String geunnaejibangdo;
    private String sunbaljisu;
    private String rank;

    public String getMengho() {
        return mengho;
    }

    public void setMengho(String mengho) {
        this.mengho = mengho;
    }

    public String getKpn_no() {
        return kpn_no;
    }

    public void setKpn_no(String kpn_no) {
        this.kpn_no = kpn_no;
    }

    public String getGeungyogyesu() {
        return geungyogyesu;
    }

    public void setGeungyogyesu(String geungyogyesu) {
        this.geungyogyesu = geungyogyesu;
    }

    public String getGeungyogyesu_level() {
        return geungyogyesu_level;
    }

    public void setGeungyogyesu_level(String geungyogyesu_level) {
        this.geungyogyesu_level = geungyogyesu_level;
    }

    public String getDo_weight() {
        return do_weight;
    }

    public void setDo_weight(String do_weight) {
        this.do_weight = do_weight;
    }

    public String getDeungsimdanmyeonjeok() {
        return deungsimdanmyeonjeok;
    }

    public void setDeungsimdanmyeonjeok(String deungsimdanmyeonjeok) {
        this.deungsimdanmyeonjeok = deungsimdanmyeonjeok;
    }

    public String getDeungjibangdukke() {
        return deungjibangdukke;
    }

    public void setDeungjibangdukke(String deungjibangdukke) {
        this.deungjibangdukke = deungjibangdukke;
    }

    public String getGeunnaejibangdo() {
        return geunnaejibangdo;
    }

    public void setGeunnaejibangdo(String geunnaejibangdo) {
        this.geunnaejibangdo = geunnaejibangdo;
    }

    public String getSunbaljisu() {
        return sunbaljisu;
    }

    public void setSunbaljisu(String sunbaljisu) {
        this.sunbaljisu = sunbaljisu;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "GasanggyobaeResultData{" +
                "mengho='" + mengho + '\'' +
                ", kpn_no='" + kpn_no + '\'' +
                ", geungyogyesu='" + geungyogyesu + '\'' +
                ", geungyogyesu_level='" + geungyogyesu_level + '\'' +
                ", do_weight='" + do_weight + '\'' +
                ", deungsimdanmyeonjeok='" + deungsimdanmyeonjeok + '\'' +
                ", deungjibangdukke='" + deungjibangdukke + '\'' +
                ", geunnaejibangdo='" + geunnaejibangdo + '\'' +
                ", sunbaljisu='" + sunbaljisu + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
