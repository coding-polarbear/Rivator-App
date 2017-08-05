package com.rinc.bong.rivatorproject.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
@AllArgsConstructor
public class SimpleCourse {
    private String title;
    private String teacherName;
    private String category;
    private int unitTime;
}
