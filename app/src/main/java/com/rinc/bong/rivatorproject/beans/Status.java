package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 9. 9..
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Status {
    @SerializedName("status")
    Result result;
}
