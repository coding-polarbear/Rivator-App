package com.rinc.bong.rivatorproject.beans;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */

public class Item {
    private String image;
    private String title;
    public Item(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public Item(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
