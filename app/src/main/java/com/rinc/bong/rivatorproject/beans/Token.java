package com.rinc.bong.rivatorproject.beans;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehy on 2017. 9. 12..
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Token extends SugarRecord {
    private String token;
}
