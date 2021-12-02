package com.example.myapplication;

public class P5RecyclerView {
    int Image;
    String name;
    int reg_no;
    public P5RecyclerView(int image,String name, int reg_no) {
        Image = image;
        this.name = name;
        this.reg_no = reg_no;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }
}
