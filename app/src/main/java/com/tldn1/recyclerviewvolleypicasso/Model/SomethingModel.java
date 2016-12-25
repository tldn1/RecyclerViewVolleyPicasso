package com.tldn1.recyclerviewvolleypicasso.Model;

/**
 * Created by X on 12/25/2016.
 */

public class SomethingModel {
    private String picture;
    private String title;

    public SomethingModel(String picture, String title) {
        this.setPicture(picture);
        this.setTitle(title);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
