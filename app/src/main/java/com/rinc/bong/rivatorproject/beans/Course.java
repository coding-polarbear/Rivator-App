package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class Course {
    private int courseKey;
    private String userName;
    private String image1;
    private String image2;
    private String image3;
    private String courseTitle;
    private String couseCategory;
    private int courseUnit;
    private float courseScore;
    private int coursePrice;

    public Course(int courseKey, String userName, String image1, String image2, String image3, String courseTitle, String couseCategory, int courseUnit, float courseScore, int coursePrice, String courseCurriculum) {
        this.courseKey = courseKey;
        this.userName = userName;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.courseTitle = courseTitle;
        this.couseCategory = couseCategory;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
        this.coursePrice = coursePrice;
        this.courseCurriculum = courseCurriculum;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public int getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(int courseKey) {
        this.courseKey = courseKey;
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
