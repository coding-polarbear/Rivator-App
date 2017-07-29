package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */

@Getter
@Setter
public class SimpleStudent {
    private String profileURL;
    private String name;
    private String category;

    public SimpleStudent(String profileURL, String name, String category) {
        this.profileURL = profileURL;
        this.name = name;
        this.category = category;
    }
}
