package com.rinc.bong.rivatorproject;

/**
 * Created by baehyeonbin on 2017. 7. 16..
 */

public class MyItem {
    private String imageURL;
    private String teacherName;
    private String subject;

    public MyItem(String imageURL, String teacherName, String subject) {
        this.imageURL = imageURL;
        this.teacherName = teacherName;
        this.subject = subject;
    }

    public MyItem(String teacherName, String subject) {
        this.teacherName = teacherName;
        this.subject = subject;
    }
    public MyItem() {

    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
