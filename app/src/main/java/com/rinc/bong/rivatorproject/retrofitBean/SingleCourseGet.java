package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.DetailCourse;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 22..
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SingleCourseGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("course")
    private DetailCourse detailCourse;

}
