package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

@Getter
@Setter
public class LectureItem {
    private String imageURL;
    private String title;
    private String teacherName;
    private int unitTime;

    public LectureItem(String title, String teacherName, int unitTime) {
        this.title = title;
        this.teacherName = teacherName;
        this.unitTime = unitTime;
    }
}
