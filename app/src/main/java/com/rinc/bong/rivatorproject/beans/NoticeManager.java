package com.rinc.bong.rivatorproject.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

@Getter
@Setter
public class NoticeManager {
    private int NoticeKey;
    private boolean isRead;

    public NoticeManager(int noticeKey, boolean isRead) {
        NoticeKey = noticeKey;
        this.isRead = isRead;
    }
}
