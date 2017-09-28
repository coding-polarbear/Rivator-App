package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 28..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("user")
    private User user;
}
