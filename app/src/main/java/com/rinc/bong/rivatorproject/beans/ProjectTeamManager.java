package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class ProjectTeamManager {
    private  int projectKey;
    private int userKey;
    private String tmPart;

    public ProjectTeamManager(String tmPart) {
        this.tmPart = tmPart;
    }

    public int getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(int projectKey) {
        this.projectKey = projectKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getTmPart() {
        return tmPart;
    }

    public void setTmPart(String tmPart) {
        this.tmPart = tmPart;
    }
}
