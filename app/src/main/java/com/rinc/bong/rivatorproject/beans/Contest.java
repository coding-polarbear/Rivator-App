package com.rinc.bong.rivatorproject.beans;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 26..
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contest {
    @SerializedName("title")
    private String title;
    @SerializedName("category")
    private String category;
    @SerializedName("priseNum")
    private int prizeNum;
    @SerializedName("description")
    private String description;
    @SerializedName("fieldEntry")
    private String filedEntry;
    @SerializedName("criteria")
    private String criteria;
    @SerializedName("award")
    private String award;
    @SerializedName("dateStart")
    private String dateStart;
    @SerializedName("dateEnd")
    private String dateEnd;
}
