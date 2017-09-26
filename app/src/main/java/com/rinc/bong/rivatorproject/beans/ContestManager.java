package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 26..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContestManager {
    @SerializedName("managerKey")
    private int managerKey;
    @SerializedName("userId")
    private String userId;
    @SerializedName("contestKey")
    private int contestKey;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("User")
    private User user;
    @SerializedName("Contest")
    private Contest contest;
}
