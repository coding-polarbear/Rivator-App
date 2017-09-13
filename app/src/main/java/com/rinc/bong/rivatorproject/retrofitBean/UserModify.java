package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import retrofit2.http.Multipart;

/**
 * Created by baehy on 2017. 9. 13..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModify {
    @SerializedName("userName")
    private String name;
    @SerializedName("phone")
    private String phoneNumber;
    @SerializedName("localCity")
    private String city;
    @SerializedName("localDistrict")
    private String district;
    @SerializedName("localTown")
    private String town;
    @SerializedName("subject")
    private String subject;
}
