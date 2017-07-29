package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class SimpleContest {
    private String title;
    private String organizer;
    private String kind;
    private Date startTime;
    private Date endTime;

    public SimpleContest(String title, String organizer, String kind, Date startTime, Date endTime) {
        this.title = title;
        this.organizer = organizer;
        this.kind = kind;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
