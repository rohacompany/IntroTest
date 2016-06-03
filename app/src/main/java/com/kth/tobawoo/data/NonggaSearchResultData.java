package com.kth.tobawoo.data;

/**
 * Created by tommy on 2016-02-16.
 */
public class NonggaSearchResultData implements CommonInter{
    private int idx;
    private String chukhyup_name; //축협명
    private String sido; //시도
    private String area1; //지역1
    private String area2; //지역2
    private String house_code; //농가 - 목장번호
    private String house_gubun; //농가구분
    private String house_name; //농가명
    private String sex; //성별
    private String birth; //생년월일
    private String zipcode; //우편번호
    private String house_addr1; //농가기본주소
    private String house_addr2; // 농가기본주소2
    private String house_addr3; //농가도로명주소
    private String phone; //전화번호
    private String fax; //팩스번호
    private String mobile; //휴대폰
    private String email; //이메일
    private String farm_name; //목장명
    private String account_no; //계좌번호
    private String farm_zipcode; //우편번호
    private String farm_addr1; //목장기본주소
    private String farm_addr2; //목장상세주소
    private String farm_addr3; //목장도로명주소
    private String farm_phone; //목장전화번호
    private String reg_no; //축산업 등록번호
    private String breed_type; //사육형태
    private String calf_product; //송아지생산
    private String improve; //한우개량
    private String manage; //한우경영
    private String mail_yn; //우편물수신
    private String community_name; //자연부락명
    private String member_yn; //회원여부
    private int arm_cnt,su_cnt,gese_cnt;

    public int getArm_cnt() {
        return arm_cnt;
    }

    public void setArm_cnt(int arm_cnt) {
        this.arm_cnt = arm_cnt;
    }

    public int getSu_cnt() {
        return su_cnt;
    }

    public void setSu_cnt(int su_cnt) {
        this.su_cnt = su_cnt;
    }

    public int getGese_cnt() {
        return gese_cnt;
    }

    public void setGese_cnt(int gese_cnt) {
        this.gese_cnt = gese_cnt;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getChukhyup_name() {
        return chukhyup_name;
    }

    public void setChukhyup_name(String chukhyup_name) {
        this.chukhyup_name = chukhyup_name;
    }

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public String getHouse_code() {
        return house_code;
    }

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public String getHouse_gubun() {
        return house_gubun;
    }
    public void setHouse_gubun(String house_gubun) {

        this.house_gubun = house_gubun;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHouse_addr1() {
        return house_addr1;
    }

    public void setHouse_addr1(String house_addr1) {
        this.house_addr1 = house_addr1;
    }

    public String getHouse_addr2() {
        return house_addr2;
    }

    public void setHouse_addr2(String house_addr2) {
        this.house_addr2 = house_addr2;
    }

    public String getHouse_addr3() {
        return house_addr3;
    }

    public void setHouse_addr3(String house_addr3) {
        this.house_addr3 = house_addr3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getFarm_zipcode() {
        return farm_zipcode;
    }

    public void setFarm_zipcode(String farm_zipcode) {
        this.farm_zipcode = farm_zipcode;
    }

    public String getFarm_addr1() {
        return farm_addr1;
    }

    public void setFarm_addr1(String farm_addr1) {
        this.farm_addr1 = farm_addr1;
    }

    public String getFarm_addr2() {
        return farm_addr2;
    }

    public void setFarm_addr2(String farm_addr2) {
        this.farm_addr2 = farm_addr2;
    }

    public String getFarm_addr3() {
        return farm_addr3;
    }

    public void setFarm_addr3(String farm_addr3) {
        this.farm_addr3 = farm_addr3;
    }

    public String getFarm_phone() {
        return farm_phone;
    }

    public void setFarm_phone(String farm_phone) {
        this.farm_phone = farm_phone;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getBreed_type() {
        return breed_type;
    }

    public void setBreed_type(String breed_type) {
        this.breed_type = breed_type;
    }

    public String getCalf_product() {
        return calf_product;
    }

    public void setCalf_product(String calf_product) {
        this.calf_product = calf_product;
    }

    public String getImprove() {
        return improve;
    }

    public void setImprove(String improve) {
        this.improve = improve;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public String getMail_yn() {
        return mail_yn;
    }

    public void setMail_yn(String mail_yn) {
        this.mail_yn = mail_yn;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public String getMember_yn() {
        return member_yn;
    }

    public void setMember_yn(String member_yn) {
        this.member_yn = member_yn;
    }

    @Override
    public String toString() {
        return "NonggaSearchResultData{" +
                "idx=" + idx +
                ", chukhyup_name='" + chukhyup_name + '\'' +
                ", sido='" + sido + '\'' +
                ", area1='" + area1 + '\'' +
                ", area2='" + area2 + '\'' +
                ", house_code='" + house_code + '\'' +
                ", house_gubun='" + house_gubun + '\'' +
                ", house_name='" + house_name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", house_addr1='" + house_addr1 + '\'' +
                ", house_addr2='" + house_addr2 + '\'' +
                ", house_addr3='" + house_addr3 + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", farm_name='" + farm_name + '\'' +
                ", account_no='" + account_no + '\'' +
                ", farm_zipcode='" + farm_zipcode + '\'' +
                ", farm_addr1='" + farm_addr1 + '\'' +
                ", farm_addr2='" + farm_addr2 + '\'' +
                ", farm_addr3='" + farm_addr3 + '\'' +
                ", farm_phone='" + farm_phone + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", breed_type='" + breed_type + '\'' +
                ", calf_product='" + calf_product + '\'' +
                ", improve='" + improve + '\'' +
                ", manage='" + manage + '\'' +
                ", mail_yn='" + mail_yn + '\'' +
                ", community_name='" + community_name + '\'' +
                ", member_yn='" + member_yn + '\'' +
                '}';
    }
}
