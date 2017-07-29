package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class DetailContest {
    private String image;
    private String description;
    private String category;
    private String register;
    private String criteria;
    private String award;

    public DetailContest(String image, String description, String category, String register, String criteria, String award) {
        this.image = image;
        this.description = description;
        this.category = category;
        this.register = register;
        this.criteria = criteria;
        this.award = award;
    }
}
