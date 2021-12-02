package com.example.myapplication;

public class P3CustomAddItems {
    String name;
    int image_resource_id;

    public P3CustomAddItems(String name, int image_resource_id){
        this.name=name;
        this.image_resource_id=image_resource_id;
    }
    String getName(){return this.name;}
    int getImage_resource_id(){return this.image_resource_id;}
}
