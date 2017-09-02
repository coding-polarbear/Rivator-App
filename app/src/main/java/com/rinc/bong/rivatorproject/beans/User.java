package com.rinc.bong.rivatorproject.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 6. 17..
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}
