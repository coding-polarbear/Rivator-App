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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectManager {
    @SerializedName("managerkey")
    private int mangerkey;
    @SerializedName("projectKey")
    private int projectkey;
    @SerializedName("userId")
    private String userId;
    @SerializedName("teamPart")
    private String teamPart;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;
    @SerializedName("Project")
    private Project project;
}
