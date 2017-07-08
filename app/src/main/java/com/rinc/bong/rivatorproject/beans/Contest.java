package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class Contest {
    private int contestKey;
    private int userKey;
    private String ctImage1;
    private String ctImage2;
    private String ctImage3;
    private String ctTitle;
    private String ctCategory;
    private int ctPriseNum;
    private String ctDescription;
    private String ctFieldEntity;
    private String ctCriteria;
    private String ctAward;
    private Date ctDateStart;
    private Date ctDateEnd;

    public Contest(String ctImage1, String ctImage2, String ctImage3, String ctTitle, String ctCategory, int ctPriseNum, String ctDescription, String ctFieldEntity, String ctCriteria, String ctAward, Date ctDateStart, Date ctDateEnd) {
        this.ctImage1 = ctImage1;
        this.ctImage2 = ctImage2;
        this.ctImage3 = ctImage3;
        this.ctTitle = ctTitle;
        this.ctCategory = ctCategory;
        this.ctPriseNum = ctPriseNum;
        this.ctDescription = ctDescription;
        this.ctFieldEntity = ctFieldEntity;
        this.ctCriteria = ctCriteria;
        this.ctAward = ctAward;
        this.ctDateStart = ctDateStart;
        this.ctDateEnd = ctDateEnd;
    }

    public int getContestKey() {
        return contestKey;
    }

    public void setContestKey(int contestKey) {
        this.contestKey = contestKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getCtImage1() {
        return ctImage1;
    }

    public void setCtImage1(String ctImage1) {
        this.ctImage1 = ctImage1;
    }

    public String getCtImage2() {
        return ctImage2;
    }

    public void setCtImage2(String ctImage2) {
        this.ctImage2 = ctImage2;
    }

    public String getCtImage3() {
        return ctImage3;
    }

    public void setCtImage3(String ctImage3) {
        this.ctImage3 = ctImage3;
    }

    public String getCtTitle() {
        return ctTitle;
    }

    public void setCtTitle(String ctTitle) {
        this.ctTitle = ctTitle;
    }

    public String getCtCategory() {
        return ctCategory;
    }

    public void setCtCategory(String ctCategory) {
        this.ctCategory = ctCategory;
    }

    public int getCtPriseNum() {
        return ctPriseNum;
    }

    public void setCtPriseNum(int ctPriseNum) {
        this.ctPriseNum = ctPriseNum;
    }

    public String getCtDescription() {
        return ctDescription;
    }

    public void setCtDescription(String ctDescription) {
        this.ctDescription = ctDescription;
    }

    public String getCtFieldEntity() {
        return ctFieldEntity;
    }

    public void setCtFieldEntity(String ctFieldEntity) {
        this.ctFieldEntity = ctFieldEntity;
    }

    public String getCtCriteria() {
        return ctCriteria;
    }

    public void setCtCriteria(String ctCriteria) {
        this.ctCriteria = ctCriteria;
    }

    public String getCtAward() {
        return ctAward;
    }

    public void setCtAward(String ctAward) {
        this.ctAward = ctAward;
    }

    public Date getCtDateStart() {
        return ctDateStart;
    }

    public void setCtDateStart(Date ctDateStart) {
        this.ctDateStart = ctDateStart;
    }

    public Date getCtDateEnd() {
        return ctDateEnd;
    }

    public void setCtDateEnd(Date ctDateEnd) {
        this.ctDateEnd = ctDateEnd;
    }
}
