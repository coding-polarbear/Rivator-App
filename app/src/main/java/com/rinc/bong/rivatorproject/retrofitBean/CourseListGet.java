package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.Status;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 17..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseListGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("courses")
    private List<SimpleCourse> simpleCourseList;
}
