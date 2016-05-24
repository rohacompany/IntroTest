package com.kth.tobawoo.data;

import java.io.Serializable;

/**
 * Created by tommy on 2015-03-17.
 */
public class UserInfo implements Serializable {
    private int no;
    private int member_type;
    private String user_id;
	private String user_pwd;
	private String user_phone_number;
	private String user_email;
	private String regDate;
	private String user_name;
	private String user_address;

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getMember_type() {
        return member_type;
    }

    public void setMember_type(int member_type) {
        this.member_type = member_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

	@Override
	public String toString() {
		return "UserInfo{" +
				"no=" + no +
				", member_type=" + member_type +
				", user_id='" + user_id + '\'' +
				", user_pwd='" + user_pwd + '\'' +
				", user_phone_number='" + user_phone_number + '\'' +
				", user_email='" + user_email + '\'' +
				", regDate='" + regDate + '\'' +
				", user_name='" + user_name + '\'' +
				", user_address='" + user_address + '\'' +
				'}';
	}
}
