package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewWithImage extends AppCompatActivity {

    int imageList[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
            R.drawable.a6,R.drawable.a1,R.drawable.a2,
            R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
    String nameList[]={"sanjay","Anil","Rohan","Anup","Vikas","Rahul","sanjay","Anil","Rohan","Anup","Vikas","Rahul"};
    List<CustomGridViewClass> customGridViewClasses=new ArrayList<>();
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view_with_image);
        gridView=findViewById(R.id.grid_view);


        for (int count =0;count<imageList.length;count++){
            customGridViewClasses.add(new CustomGridViewClass(imageList[count],nameList[count]));
        }
        CustomGridViewAdapter customGridViewAdapter= new
                CustomGridViewAdapter(getApplicationContext(),
                R.layout.customgridview,customGridViewClasses);
        gridView.setAdapter(customGridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView i1=view.findViewById(R.id.grid_Image);
                TextView t1=view.findViewById(R.id.grid_text);
                i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(getApplicationContext(),ReceiveDetailFromGridView.class);
//                        intent.putExtra("image",(view.findViewById(R.id.grid_Image)));
                        startActivity(intent);
                    }
                });
            }
        });

    }
}