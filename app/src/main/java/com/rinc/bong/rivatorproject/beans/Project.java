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
    @SerializedName("projectKey")
    private int projectKey;
    @SerializedName("userId")
    private String userId;
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
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;

}
