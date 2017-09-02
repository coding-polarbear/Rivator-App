package com.rinc.bong.rivatorproject.beans;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import okhttp3.MultipartBody;

/**
 * Created by baehyeonbin on 2017. 6. 17..
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends SugarRecord{
    private String userId;
    private String userPw;
    private String userName;
    private String profileURL;
    private String phone;
    private String localCity;
    private String localTown;
    private String localDistric;
    private String subject;
    private int userType;
}
