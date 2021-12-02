package com.example.myapplication;

public class CustomGridViewClass {
    private int image_id;
    private  String name_id;

    public CustomGridViewClass(int image_id,String name_id) {
        this.image_id = image_id;
        this.name_id=name_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
