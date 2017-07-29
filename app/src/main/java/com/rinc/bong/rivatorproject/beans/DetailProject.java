package com.rinc.bong.rivatorproject.beans;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */
@Getter
@Setter
public class DetailProject {
    private String description;
    private ArrayList<SimpleStudent> atendeeList;
    private int memberNum;

    public DetailProject(String description, ArrayList<SimpleStudent> atendeeList, int memberNum) {
        this.description = description;
        this.atendeeList = atendeeList;
        this.memberNum = memberNum;
    }
}
