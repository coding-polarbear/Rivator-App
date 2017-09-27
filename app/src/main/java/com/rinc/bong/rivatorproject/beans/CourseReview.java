package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 23..
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseReview {
    @SerializedName("reviewKey")
    private int reviewKey;
    @SerializedName("userId")
    private String userId;
    @SerializedName("courseKey")
    private int couseKey;
    @SerializedName("score")
    private double score;
    @SerializedName("content")
    private String content;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;
    @SerializedName("Course")
    private Course course;
}