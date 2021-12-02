package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class P15FloatIngButtonShowArrayList extends AppCompatActivity {
ListView listView1;
FloatingActionButton showData;
ArrayAdapter <String>arrayAdapter;
String[] arr={"Sanjay","Anil","Vikash","Subhash","abc","xyz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p15_float_ing_button_show_array_list);
        listView1=findViewById(R.id.list1);
        showData=findViewById(R.id.showDetail);
        listView1.setVisibility(View.INVISIBLE);

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                listView1.setVisibility(View.VISIBLE);
//                arrayAdapter
//                        = new ArrayAdapter<String>(
//                        getApplicationContext(),
//                        R.layout.support_simple_spinner_dropdown_item,
//                        arr);
//                listView1.setAdapter(arrayAdapter);
                PopupMenu popupMenu=new PopupMenu(getApplicationContext(),showData);
                popupMenu.getMenuInflater().inflate(R.menu.p15_show_data_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.m1:
                                Toast.makeText(getApplicationContext(), "Home Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m2:
                                Toast.makeText(getApplicationContext(), "share Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m3:
                                Toast.makeText(getApplicationContext(), "Login Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m4:
                                Toast.makeText(getApplicationContext(), "Log out Clicked", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return true;
                    }
                });
                popupMenu.show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.p15_show_data_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}