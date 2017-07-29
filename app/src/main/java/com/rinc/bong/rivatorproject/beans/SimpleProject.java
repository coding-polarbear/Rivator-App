package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class SimpleProject {
    private String title;
    private String teamName;
    private String category;
    private int unitTime;
    private boolean isProceeding;
    private String teacherName;

    public SimpleProject(String title, String teamName, String category, int unitTime, boolean isProceeding, String teacherName) {
        this.title = title;
        this.teamName = teamName;
        this.category = category;
        this.unitTime = unitTime;
        this.isProceeding = isProceeding;
        this.teacherName = teacherName;
    }
}
