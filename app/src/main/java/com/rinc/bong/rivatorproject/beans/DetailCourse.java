package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Review;
import com.rinc.bong.rivatorproject.beans.User;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailCourse {
    @SerializedName("courseKey")
    private int courseKey;
    @SerializedName("title")
    private String title;
    @SerializedName("userId")
    private String userId;
    @SerializedName("category")
    private String category;
    @SerializedName("unit")
    private int unit;
    @SerializedName("price")
    private int price;
    @SerializedName("score")
    private double score;
    @SerializedName("isOpen")
    private boolean isOpen;
    @SerializedName("curriculum")
    private String curriculum;
    @SerializedName("numOfStudnets")
    private int numOfStudents;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;

}
