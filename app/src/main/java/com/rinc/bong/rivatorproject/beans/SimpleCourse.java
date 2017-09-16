package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
@AllArgsConstructor
public class SimpleCourse {
    @SerializedName("title")
    private String title;
    @SerializedName("User")
    private User user;
    @SerializedName("category")
    private String category;
    @SerializedName("unit")
    private int unitTime;
    @SerializedName("courseKey")
    private int courseKey;

    public SimpleCourse(String title) {
        this.title = title;
    }
}
