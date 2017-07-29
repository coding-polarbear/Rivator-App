package com.rinc.bong.rivatorproject.beans;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class DetailCourse {
    private int score;
    private int price;
    private String description;
    private ArrayList<Review> reviewList;

    public DetailCourse(int score, int price, String description, ArrayList<Review> reviewList) {
        this.score = score;
        this.price = price;
        this.description = description;
        this.reviewList = reviewList;
    }
}
