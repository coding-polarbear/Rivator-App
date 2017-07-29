package com.rinc.bong.rivatorproject.beans;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class Review {
    private int score;
    private String content;
    private Date date;

    public Review(int score, String content, Date date) {
        this.score = score;
        this.content = content;
        this.date = date;
    }
}
