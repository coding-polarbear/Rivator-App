package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.ContestManager;
import com.rinc.bong.rivatorproject.beans.Result;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 26..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContestManagerListGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("contestManagers")
    private List<ContestManager> contestManagerList;
}
