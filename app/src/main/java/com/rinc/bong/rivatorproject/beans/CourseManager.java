package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 27..
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseManager {
    @SerializedName("managerKey")
    private int managerKey;
    @SerializedName("userId")
    private String userId;
    @SerializedName("courseKey")
    private int courseKey;
    @SerializedName("status")
    private int status;
    @SerializedName("created_at")
    private String createAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;
    @SerializedName("Course")
    private Course course;
}
