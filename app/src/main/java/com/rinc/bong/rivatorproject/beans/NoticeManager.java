package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 9..
 */

public class NoticeManager {
    private int NoticeKey;
    private boolean isRead;

    public NoticeManager(int noticeKey, boolean isRead) {
        NoticeKey = noticeKey;
        this.isRead = isRead;
    }

    public int getNoticeKey() {
        return NoticeKey;
    }

    public void setNoticeKey(int noticeKey) {
        NoticeKey = noticeKey;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
