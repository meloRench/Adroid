package com.rc.cardnews;

import java.io.Serializable;

/**
 * Created by root on 15-12-12.
 */
public class News implements Serializable {
    private String title;
    private String desc;
    private int photoId;

    public News(String name,String age,int photoId){
        this.title=name;
        this.desc=age;
        this.photoId=photoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}

