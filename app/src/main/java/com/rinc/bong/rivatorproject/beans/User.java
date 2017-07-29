package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 6. 17..
 */
@Getter
@Setter
public class User {
    private String userID;
    private String userPW;
    private String userName;
    private String profileURL;
    private String phoneNumber;
    private String localCity;
    private String localTown;
    private String localArea;
    private String subject;
    private int userStatus;

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



}
