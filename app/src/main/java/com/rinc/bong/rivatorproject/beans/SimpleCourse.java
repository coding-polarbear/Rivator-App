package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class SimpleCourse {
    private String title;
    private String teacherName;
    private String unitTime;

    public SimpleCourse(String title, String teacherName, String unitTime) {
        this.title = title;
        this.teacherName = teacherName;
        this.unitTime = unitTime;
    }
}
