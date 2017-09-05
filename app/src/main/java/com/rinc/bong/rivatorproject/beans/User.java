package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("userId")
    private String userId;

    @SerializedName("userPw")
    private String userPw;

    @SerializedName("userName")
    private String userName;

    private String profileURL;

    @SerializedName("phone")
    private String phone;

    @SerializedName("localCity")
    private String localCity;

    @SerializedName("localTown")
    private String localTown;

    @SerializedName("localDistrict")
    private String localDistrict;

    @SerializedName("subject")
    private String subject;

    @SerializedName("userType")
    private String userType;

    public User(String userName, String userId, String userPw, String phone, String userType, String localCity, String localTown, String localDistrict, String subject) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.phone = phone;
        this.userType = userType;
        this.localCity = localCity;
        this.localTown = localTown;
        this.localDistrict = localDistrict;
        this.subject = subject;
    }
}
