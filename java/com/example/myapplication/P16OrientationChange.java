package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class P16OrientationChange extends AppCompatActivity {
TextView showValue;
Button incBtn ,decBtn;
//LinearLayout layout;
int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p16_orientation_change);
        showValue=findViewById(R.id.TextValue);
        incBtn=findViewById(R.id.incText);
        decBtn=findViewById(R.id.decText);
//        layout=findViewById(R.id.MyLl);
        incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                showValue.setText(""+count);
            }
        });
        decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                showValue.setText(""+count);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MyCount", count);//returns an integer
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showValue.setText(""+savedInstanceState.getInt("MyCount"));// char+integer

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.p15_show_data_menu,menu);
//        LayoutInflater layoutInflater=getLayoutInflater();
        getMenuInflater().inflate(R.menu.p16_theme,menu);
//       AppCompatDelegate means giving right to someone else
        int   nightMode= AppCompatDelegate.getDefaultNightMode();
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.darkMode).setTitle("Night mode");

        }
        else{
            menu.findItem(R.id.darkMode).setTitle("Dark mode");
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.darkMode:
                Toast.makeText(this, "Dark mode Clicked", Toast.LENGTH_SHORT).show();
//                layout.setBackgroundColor(Color.BLACK);
                int night_mode=AppCompatDelegate.getDefaultNightMode();
                if (night_mode==AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                }
                break;
        }

        return true;
    }
}