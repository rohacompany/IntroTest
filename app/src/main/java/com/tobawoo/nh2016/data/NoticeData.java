package com.tobawoo.nh2016.data;

import java.io.Serializable;

/**
 * Created by tommy on 2016-02-16.
 */
public class NoticeData implements Serializable{
    private int idx;
    private String title;
    private String content;
    private String regdate;
    private String reg_user_id;

    public String getReg_user_id() {
        return reg_user_id;
    }

    public void setReg_user_id(String reg_user_id) {
        this.reg_user_id = reg_user_id;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

}
