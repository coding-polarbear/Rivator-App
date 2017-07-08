package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class Project {
    private int projectKey;
    private String pjImage1;
    private String pjImage2;
    private String pjImage3;
    private String pjTitle;
    private Date pjDate;
    private String pjCategory;
    private String pjMemberNum;
    private String pjDescription;

    public Project(String pjImage1, String pjImage2, String pjImage3, String pjTitle, Date pjDate, String pjCategory, String pjMemberNum, String pjDescription) {
        this.pjImage1 = pjImage1;
        this.pjImage2 = pjImage2;
        this.pjImage3 = pjImage3;
        this.pjTitle = pjTitle;
        this.pjDate = pjDate;
        this.pjCategory = pjCategory;
        this.pjMemberNum = pjMemberNum;
        this.pjDescription = pjDescription;
    }

    public int getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(int projectKey) {
        this.projectKey = projectKey;
    }

    public String getPjImage1() {
        return pjImage1;
    }

    public void setPjImage1(String pjImage1) {
        this.pjImage1 = pjImage1;
    }

    public String getPjImage2() {
        return pjImage2;
    }

    public void setPjImage2(String pjImage2) {
        this.pjImage2 = pjImage2;
    }

    public String getPjImage3() {
        return pjImage3;
    }

    public void setPjImage3(String pjImage3) {
        this.pjImage3 = pjImage3;
    }

    public String getPjTitle() {
        return pjTitle;
    }

    public void setPjTitle(String pjTitle) {
        this.pjTitle = pjTitle;
    }

    public Date getPjDate() {
        return pjDate;
    }

    public void setPjDate(Date pjDate) {
        this.pjDate = pjDate;
    }

    public String getPjCategory() {
        return pjCategory;
    }

    public void setPjCategory(String pjCategory) {
        this.pjCategory = pjCategory;
    }

    public String getPjMemberNum() {
        return pjMemberNum;
    }

    public void setPjMemberNum(String pjMemberNum) {
        this.pjMemberNum = pjMemberNum;
    }

    public String getPjDescription() {
        return pjDescription;
    }

    public void setPjDescription(String pjDescription) {
        this.pjDescription = pjDescription;
    }
}
