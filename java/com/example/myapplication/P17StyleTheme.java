package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class P17StyleTheme extends AppCompatActivity {
ImageButton pBtn,mBtn,p1Btn,m1Btn;
TextView t1,t2,t3;
    int b=0,b1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p17_style_theme);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        pBtn=findViewById(R.id.inTv);
        mBtn=findViewById(R.id.decTv);
        p1Btn=findViewById(R.id.inTv1);
        m1Btn=findViewById(R.id.decTv1);

//        String a=t1.getText().toString();
//        b=Integer.parseInt(a);
        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+1;

                t1.setText(""+b);

            }
        });
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b-1;

                t1.setText(""+b);

            }
        });
        p1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1=b1+1;

                t2.setText(""+b1);

            }
        });
        m1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1=b1-1;

                t2.setText(""+b1);

            }
        });


        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b>b1){
                    Toast.makeText(getApplicationContext(), "B is greater than B1" +b, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "B1 is greater than B" +b1, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}