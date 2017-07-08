package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class CourseReview {
    private int courseKey;
    private int userKey;
    private float csScore;
    private String csContents;
    private Date csDate;

    public CourseReview(float csScore, String csContents, Date csDate) {
        this.csScore = csScore;
        this.csContents = csContents;
        this.csDate = csDate;
    }

    public int getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(int courseKey) {
        this.courseKey = courseKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public float getCsScore() {
        return csScore;
    }

    public void setCsScore(float csScore) {
        this.csScore = csScore;
    }

    public String getCsContents() {
        return csContents;
    }

    public void setCsContents(String csContents) {
        this.csContents = csContents;
    }

    public Date getCsDate() {
        return csDate;
    }

    public void setCsDate(Date csDate) {
        this.csDate = csDate;
    }
}
