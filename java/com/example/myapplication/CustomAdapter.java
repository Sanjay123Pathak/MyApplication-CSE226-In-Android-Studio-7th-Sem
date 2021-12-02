package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter  extends BaseAdapter {

    Context context;
    String[] nameList;
    int[] imageList;

    public CustomAdapter(Context context, int[] imageList,String[] nameList) {
        this.context = context;
        this.nameList = nameList;
        this.imageList = imageList;

        layoutInflater=LayoutInflater.from(context);
    }

    LayoutInflater layoutInflater;
    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.custom_listview,null);
        TextView nameText=convertView.findViewById(R.id.myText);
        ImageView image=convertView.findViewById(R.id.myImage);

        // this is for setting the image and text on the layout  i.e custom_list
        image.setImageResource(imageList[position]);
        nameText.setText(nameList[position]);


        return convertView;
    }
}
