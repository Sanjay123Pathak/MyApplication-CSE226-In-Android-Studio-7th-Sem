package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.P20RoomDB.P20Database;
import com.example.myapplication.P20RoomDB.P20userRoomDb;

public class P20NewCourse extends AppCompatActivity {
EditText e1,e2,e3;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p20_new_course);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);saveBtn=findViewById(R.id.saveCourse);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewCourseDetails(e1.getText().toString(),e2.getText().toString(),
                        e3.getText().toString());

            }
        });


    }
    private  void saveNewCourseDetails(String CourseNm,String CourseDesc,
                                       String CourseDur){
        P20Database database=P20Database.getDbInstance(this);
        P20userRoomDb p20userRoomDb= new P20userRoomDb();
        p20userRoomDb.CourseName=CourseNm;//it is getting the CourseName from P20userroom db
        p20userRoomDb.CourseDescription=CourseDesc;
        p20userRoomDb.CourseDuration=CourseDur;
        database.userDao().insertDetails();
        finish();


    }
}