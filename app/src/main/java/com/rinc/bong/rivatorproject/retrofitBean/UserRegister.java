package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.Result;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

@Getter
@Setter

public class UserRegister {
    @SerializedName("status")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
