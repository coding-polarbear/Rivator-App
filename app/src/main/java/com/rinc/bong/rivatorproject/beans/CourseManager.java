package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class CourseManager {
    private int courseKey;
    private int userKey;
    private int csStatus;

    public CourseManager(int csStatus) {
        this.csStatus = csStatus;
    }

    public int getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(int courseKey) {
        this.courseKey = courseKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public int getCsStatus() {
        return csStatus;
    }

    public void setCsStatus(int csStatus) {
        this.csStatus = csStatus;
    }
}
