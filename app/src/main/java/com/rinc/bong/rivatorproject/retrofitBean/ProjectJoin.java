package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 25..
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectJoin {
    @SerializedName("teamPart")
    private String teamPart;
}
