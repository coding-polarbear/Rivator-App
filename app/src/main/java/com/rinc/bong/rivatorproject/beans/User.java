package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 6. 17..
 */

public class User {
    private int userKey;
    private String userID;
    private String userPW;
    private String userName;
    private String profileURL;
    private String phoneNumber;
    private String localCity;
    private String localTown;

    public User(String userID, String userPW, String userName, String profileURL, String phoneNumber, String localCity, String localTown, String localArea, String subject, int userStatus) {
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.profileURL = profileURL;
        this.phoneNumber = phoneNumber;
        this.localCity = localCity;
        this.localTown = localTown;
        this.localArea = localArea;
        this.subject = subject;
        this.userStatus = userStatus;
    }

    private String localArea;
    private String subject;
    private int userStatus;

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocalCity() {
        return localCity;
    }

    public void setLocalCity(String localCity) {
        this.localCity = localCity;
    }

    public String getLocalTown() {
        return localTown;
    }

    public void setLocalTown(String localTown) {
        this.localTown = localTown;
    }

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }




}
