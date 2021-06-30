package com.example.gallery;

public class ModelClass {
    private int imageview;

    ModelClass(){}

    ModelClass(int imageview){
        this.imageview=imageview;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }
}
