package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.ProjectManager;
import com.rinc.bong.rivatorproject.beans.Result;

import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectManagerListGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("projectManagers")
    private List<ProjectManager> projectManagerList;
}
