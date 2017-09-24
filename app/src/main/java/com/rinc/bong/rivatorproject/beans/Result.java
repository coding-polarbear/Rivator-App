package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 8. 31..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private String success;
}
