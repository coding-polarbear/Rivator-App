package com.rinc.bong.rivatorproject.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 8. 31..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
    private String message;
    private boolean success;
}
