package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 24..
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @SerializedName("title")
    private String title;
    @SerializedName("category")
    private String category;
    @SerializedName("teamName")
    private String teamName;
    @SerializedName("date")
    private String date;
    @SerializedName("memberNum")
    private int memberNum;
    @SerializedName("description")
    private String description;

}
