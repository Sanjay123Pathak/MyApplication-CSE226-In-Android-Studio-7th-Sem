package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class P5MainRecyclerView extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<P5RecyclerView> arrayList;
P5RecyclerViewAdapter adapter;
EditText edt1,edt2;
    Random random,random1;
//FOR SETTING BACKGROUND COLOR IN LIST
int[] color={Color.BLACK,Color.GRAY,Color.LTGRAY,Color.WHITE,Color.YELLOW,Color.CYAN,Color.RED};
Button addElement;
    String nameList[]={"sanjay","Anil","Rohan","Anup","Vikas","Rahul","Sonu","Monu","Sunil","Anup","Dilip","Vikash"};
    int imageList[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
                     R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.a6};
     int reg[]={1112,2223,3334,4445,5556,6667,7778,8889,9910,1010,1121,2312};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_main_recycler_view);

        edt1=findViewById(R.id.rEdit1);
        edt2=findViewById(R.id.rEdit2);
        addElement=findViewById(R.id.rBtn1);

        recyclerView=findViewById(R.id.recyclerView1);
        arrayList=new ArrayList<>();

        for (int count =0;count<nameList.length;count++) {

            arrayList.add(new P5RecyclerView(imageList[count],nameList[count],reg[count]));
        }
//        arrayList.add(new P5RecyclerView(R.drawable.a1,"sanjay",12));
//        arrayList.add(new P5RecyclerView(R.drawable.a1,"sanjay",12));
//        arrayList.add(new P5RecyclerView(R.drawable.a1,"sanjay",12));

        adapter= new P5RecyclerViewAdapter(getApplication(),arrayList);


        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new
                LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,true);
         recyclerView.setLayoutManager(linearLayoutManager);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
//
//        recyclerView.setLayoutManager(gridLayoutManager);


    }
    public  void  AddElement(View v){
        String name =edt1.getText().toString();
        int regNo=Integer.parseInt(edt2.getText().toString());
        random1=new Random();
        int imageSize=imageList.length;
        int abc=random1.nextInt(imageSize);

        P5RecyclerView p5RecyclerView= new P5RecyclerView(imageList[abc],name,regNo);

        arrayList.add(p5RecyclerView);
        Toast.makeText(this,"Item added Successfully",Toast.LENGTH_LONG).show();
        edt2.setText("");
        edt1.setText("");
        adapter.notifyDataSetChanged();

        int colorLength=color.length;
        random=new Random();
        int randomNum=random.nextInt(colorLength);
        recyclerView.setBackgroundColor(color[randomNum]);
        Toast.makeText(getApplicationContext(), "Hi ", Toast.LENGTH_SHORT).show();

    }
}