package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class P2MainCustomListViewWithArrayListUsingArrayAdapter<onListItemClick> extends AppCompatActivity {
ListView p2listView;
ArrayList<P2CustomArrayList> image_and_name= new ArrayList<>();
    String nameList[]={"sanjay","Anil","Rohan","Anup","Vikas","Rahul","Sonu","Monu","Sunil","Anup","Dilip"};
    int imageList[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
                     R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_custom_list_view_with_array_listusing_array_adapter);
        p2listView=findViewById(R.id.p2listView);

        for (int count =0;count<nameList.length;count++){
            image_and_name.add(new P2CustomArrayList(imageList[count],nameList[count]));


        }

              P2CustomArrayListAdapter p2CustomArrayListAdapter= new
              P2CustomArrayListAdapter(getApplicationContext(),
              R.layout.p2listviewcustom,image_and_name);
              p2listView.setAdapter(p2CustomArrayListAdapter);


//        p2listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(getApplicationContext(), " Clicked Items is : "+(position+1), Toast.LENGTH_LONG).show();
//
//            }
//        });



    }

}