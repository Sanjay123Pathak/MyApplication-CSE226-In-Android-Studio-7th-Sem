package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class P14FloatingActionBar extends AppCompatActivity {
FloatingActionButton f1,f2,fMAin3;
boolean  isFBOpen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p14_floating_action_bar);
        f1=findViewById(R.id.fb1);
        f2=findViewById(R.id.fb2);
        fMAin3=findViewById(R.id.fb_main);



        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "F1 is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        fMAin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFBOpen){
                    showButtonFunction();
                }
                else {
                    closeFABMenu();
                }
            }
        });


    }
   private   void  showButtonFunction(){
        isFBOpen=true;
       f1.setVisibility(View.VISIBLE);
       f2.setVisibility(View.VISIBLE);

       Toast.makeText(getApplicationContext(), "Btn 1 is clicked", Toast.LENGTH_SHORT).show();
    }

    private void closeFABMenu() {
        isFBOpen = false;
        f1.setVisibility(View.INVISIBLE);
        f2.setVisibility(View.INVISIBLE);

        // fab1.animate().translationY(0);
        //fab2.animate().translationY(0);
        //fab3.animate().translationY(0);
    }
}