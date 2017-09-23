package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Result;

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
public class ProjectGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("project")
    private Project project;
}
