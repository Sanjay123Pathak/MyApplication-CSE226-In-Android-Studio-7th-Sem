package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.P20RoomDB.P20CourseListAdapter;
import com.example.myapplication.P20RoomDB.P20Database;
import com.example.myapplication.P20RoomDB.P20userRoomDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class P20RoomDatabase extends AppCompatActivity {
FloatingActionButton fab1;
P20CourseListAdapter p20CourseListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p20_room_database);
        fab1=findViewById(R.id.fBtn);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),P20NewCourse.class),100);
            }
        });
        initRecyclerView();
        loadCourseDetails();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView= findViewById(R.id.recRoomdb);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        p20CourseListAdapter= new P20CourseListAdapter(this);
        recyclerView.setAdapter(p20CourseListAdapter);
    }
    private  void loadCourseDetails(){
        P20Database db=P20Database.getDbInstance(this.getApplicationContext());
        List<P20userRoomDb> coursesList=db.userDao().getAllDetails();
        p20CourseListAdapter.setCourseList(coursesList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==100){
            loadCourseDetails();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}