package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 16..
 */

@Getter
@Setter
public class SimpleTeacher {
    private String imageURL;
    private String teacherName;
    private String subject;
    private String category;
    private int unitTime;

    public SimpleTeacher(String teacherName, String subject) {
        this.teacherName = teacherName;
        this.subject = subject;
    }

    public SimpleTeacher(String teacherName, String subject, String category, int unitTime) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.category = category;
        this.unitTime = unitTime;
    }
}
