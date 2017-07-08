package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 6. 17..
 */

public class User {
    private String userID;
    private String userPW;
    private String phoneNumber;
    private String localCity;
    private String localTown;
    private String localArea;
    private String subject;
    private boolean isStudent;

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

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }



    public User(String userID, String userPW, String phoneNumber, String localCity, String localTown, String localArea, String subject, boolean isStudent) {
        this.userID = userID;
        this.userPW = userPW;
        this.phoneNumber = phoneNumber;
        this.localCity = localCity;
        this.localTown = localTown;
        this.localArea = localArea;
        this.subject = subject;
        this.isStudent = isStudent;
    }


}
