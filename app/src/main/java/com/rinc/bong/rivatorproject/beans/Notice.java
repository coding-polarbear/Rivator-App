package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class Notice {
    private int noticeKey;
    private int userKey;
    private String ntTitle;
    private String ntContents;
    private Date ntDate;

    public Notice(String ntTitle, String ntContents, Date ntDate) {
        this.ntTitle = ntTitle;
        this.ntContents = ntContents;
        this.ntDate = ntDate;
    }

    public int getNoticeKey() {
        return noticeKey;
    }

    public void setNoticeKey(int noticeKey) {
        this.noticeKey = noticeKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getNtTitle() {
        return ntTitle;
    }

    public void setNtTitle(String ntTitle) {
        this.ntTitle = ntTitle;
    }

    public String getNtContents() {
        return ntContents;
    }

    public void setNtContents(String ntContents) {
        this.ntContents = ntContents;
    }

    public Date getNtDate() {
        return ntDate;
    }

    public void setNtDate(Date ntDate) {
        this.ntDate = ntDate;
    }
}
