package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */
@Getter
@Setter
public class CourseItem {
    private String image;
    private String title;
    public CourseItem(String title) {
        this.title = title;
    }
}
