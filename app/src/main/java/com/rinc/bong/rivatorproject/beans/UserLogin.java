package com.rinc.bong.rivatorproject.beans;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLogin {
    @SerializedName("status")
    private Result result;
    @SerializedName("user")
    private User user;
    @SerializedName("auth")
    private Token token;
}
