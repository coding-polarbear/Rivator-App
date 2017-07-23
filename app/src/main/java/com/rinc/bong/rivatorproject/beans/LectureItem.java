package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(int unitTime) {
        this.unitTime = unitTime;
    }
}
