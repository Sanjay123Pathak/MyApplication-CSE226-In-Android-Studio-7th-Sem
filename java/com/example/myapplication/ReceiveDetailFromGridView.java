package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiveDetailFromGridView extends AppCompatActivity {
ImageView imageView;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_detial_from_grid_view);
        imageView=findViewById(R.id.receiveImage);
        textView=findViewById(R.id.receiveText);

         imageView.setImageResource(getIntent().getIntExtra("image_id",0));// used for getting int value
         textView.setText(getIntent().getStringExtra("name_id"));//getStringExtra used for string getting

    }

    public void goBack(View view) {
        Intent intent= new Intent(this,CustomGridViewWithImage.class);
        startActivity(intent);
    }
}