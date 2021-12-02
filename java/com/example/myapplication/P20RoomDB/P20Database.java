package com.example.myapplication.P20RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {P20userRoomDb.class},version = 1)
public abstract class P20Database extends RoomDatabase {
    public  abstract  P20UserDao userDao();
    private  static  P20Database INSTANCE;
    public  static  P20Database getDbInstance(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),P20Database.class,"CourseDetails").allowMainThreadQueries().build();
        }
        return  INSTANCE;
    }
}
