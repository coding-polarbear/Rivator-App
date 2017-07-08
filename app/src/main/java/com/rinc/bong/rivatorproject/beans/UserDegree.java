package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class UserDegree {
    private int userKey;
    private String dgImage;
    private String dvCategory;
    private String dgDescription;

    public UserDegree(String dgImage, String dvCategory, String dgDescription) {
        this.dgImage = dgImage;
        this.dvCategory = dvCategory;
        this.dgDescription = dgDescription;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getDgImage() {
        return dgImage;
    }

    public void setDgImage(String dgImage) {
        this.dgImage = dgImage;
    }

    public String getDvCategory() {
        return dvCategory;
    }

    public void setDvCategory(String dvCategory) {
        this.dvCategory = dvCategory;
    }

    public String getDgDescription() {
        return dgDescription;
    }

    public void setDgDescription(String dgDescription) {
        this.dgDescription = dgDescription;
    }
}
