package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 12..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdatePw {
    @SerializedName("userPw")
    String password;
}
