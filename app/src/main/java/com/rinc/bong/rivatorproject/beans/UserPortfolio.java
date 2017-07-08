package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class UserPortfolio {
    private int userKey;
    private String pfImage;
    private String pfCategory;
    private String pfDescription;

    public UserPortfolio(String pfImage, String pfCategory, String pfDescription) {
        this.pfImage = pfImage;
        this.pfCategory = pfCategory;
        this.pfDescription = pfDescription;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getPfImage() {
        return pfImage;
    }

    public void setPfImage(String pfImage) {
        this.pfImage = pfImage;
    }

    public String getPfCategory() {
        return pfCategory;
    }

    public void setPfCategory(String pfCategory) {
        this.pfCategory = pfCategory;
    }

    public String getPfDescription() {
        return pfDescription;
    }

    public void setPfDescription(String pfDescription) {
        this.pfDescription = pfDescription;
    }
}
