package com.example.myapplication.P20RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class P20userRoomDb {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name="Course-Name")
    public  String CourseName;
    @ColumnInfo(name="Course_Description")
    public  String CourseDescription;
    @ColumnInfo(name="Course_Duration")
    public String CourseDuration;

}
