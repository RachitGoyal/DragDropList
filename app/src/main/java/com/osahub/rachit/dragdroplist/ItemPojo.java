package com.osahub.rachit.dragdroplist;

import android.graphics.Bitmap;

/**
 * Created by Rachit on 21-07-2015.
 */
public class ItemPojo {
    String title;
    int num;
    Bitmap image;

    public ItemPojo() {
    }

    public ItemPojo(String title, int num, Bitmap bp) {
        this.title = title;
        this.num = num;
        this.image = bp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
