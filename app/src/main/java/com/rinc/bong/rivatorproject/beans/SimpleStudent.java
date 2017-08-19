package com.rinc.bong.rivatorproject.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleStudent {
    private String profileURL;
    private String name;
    private String category;

    public SimpleStudent(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
