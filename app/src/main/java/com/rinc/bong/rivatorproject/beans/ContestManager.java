package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class ContestManager {
    private int contestKey;
    private int userKey;
    private int ctStatus;

    public ContestManager(int ctStatus) {
        this.ctStatus = ctStatus;
    }

    public int getContestKey() {
        return contestKey;
    }

    public void setContestKey(int contestKey) {
        this.contestKey = contestKey;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public int getCtStatus() {
        return ctStatus;
    }

    public void setCtStatus(int ctStatus) {
        this.ctStatus = ctStatus;
    }
}
