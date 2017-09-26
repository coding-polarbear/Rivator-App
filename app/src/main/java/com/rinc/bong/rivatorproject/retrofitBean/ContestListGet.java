package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Result;

import java.util.List;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContestListGet {
    @SerializedName("status")
    private Result result;

    @SerializedName("contests")
    private List<Contest> contestList;
}
