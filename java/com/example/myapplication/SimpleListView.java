package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleListView extends AppCompatActivity {

LinearLayout ll1;
ListView listView;
String nameList[]={"sanjay","Anil","Rohan","Anup","Vikas","Rahul"};
int imageList[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll1=findViewById(R.id.LL1);

        setContentView(R.layout.activity_simple_list_view);
        listView=findViewById(R.id.MyListview);
//        for (int i=1;i <= imageList.length;i++){
//            al.add(new CustomArrayList(imageList[i],nameList[i]));
//        }

// for setting background color  dynamically  of linearLayout

      CustomAdapter customAdapter= new CustomAdapter(getApplicationContext(),imageList,nameList);
      listView.setAdapter(customAdapter);
//      click listener on list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListView.this, "items clicked"+(position+1) , Toast.LENGTH_LONG).show();
            }
        });

    }
}