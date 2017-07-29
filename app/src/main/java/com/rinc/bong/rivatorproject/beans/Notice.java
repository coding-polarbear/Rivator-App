package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

@Getter
@Setter
public class Notice {
    private int noticeKey;
    private int userKey;
    private String ntTitle;
    private String ntContents;
    private Date ntDate;

    public Notice(String ntTitle, String ntContents, Date ntDate) {
        this.ntTitle = ntTitle;
        this.ntContents = ntContents;
        this.ntDate = ntDate;
    }

}
