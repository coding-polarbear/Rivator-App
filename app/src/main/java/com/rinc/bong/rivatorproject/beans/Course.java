package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class Course {
    private int courseKey;
    private int userKey;
    private String courseTitle;
    private String couseCategory;
    private int courseUnit;
    private float courseScore;
    private int coursePrice;

    public Course( String courseTitle, String couseCategory, int courseUnit, float courseScore, int coursePrice, String courseCurriculum) {

        this.courseTitle = courseTitle;
        this.couseCategory = couseCategory;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
        this.coursePrice = coursePrice;
        this.courseCurriculum = courseCurriculum;
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

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCouseCategory() {
        return couseCategory;
    }

    public void setCouseCategory(String couseCategory) {
        this.couseCategory = couseCategory;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    public float getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(float courseScore) {
        this.courseScore = courseScore;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseCurriculum() {
        return courseCurriculum;
    }

    public void setCourseCurriculum(String courseCurriculum) {
        this.courseCurriculum = courseCurriculum;
    }

    private String courseCurriculum;
}
