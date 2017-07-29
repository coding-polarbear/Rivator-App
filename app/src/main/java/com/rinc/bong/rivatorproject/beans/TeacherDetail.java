package com.rinc.bong.rivatorproject.beans;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class TeacherDetail {
    private ArrayList<SimpleCourse> courseList;
    private ArrayList<SimpleContest> contestList;
    private ArrayList<SimpleProject> projectList;

    public TeacherDetail(ArrayList<SimpleCourse> courseList, ArrayList<SimpleContest> contestList, ArrayList<SimpleProject> projectList) {
        this.courseList = courseList;
        this.contestList = contestList;
        this.projectList = projectList;
    }
}
