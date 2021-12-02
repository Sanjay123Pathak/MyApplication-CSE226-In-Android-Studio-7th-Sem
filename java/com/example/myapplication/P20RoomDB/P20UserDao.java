package com.example.myapplication.P20RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface P20UserDao {
    @Query("Select * from P20userRoomDb")
    List<P20userRoomDb> getAllDetails();
    @Insert
    void insertDetails(P20userRoomDb... p20userRoomDbs);
    @Delete
    void  deleteDetails(P20userRoomDb p20userRoomDb);
}
