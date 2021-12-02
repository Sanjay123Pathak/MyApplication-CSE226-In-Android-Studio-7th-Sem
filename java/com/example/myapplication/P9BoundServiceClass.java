package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class P9BoundServiceClass extends Service {
 IBinder binder=new MyBinder();
 Random random;
 public P9BoundServiceClass(){

 }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    class  MyBinder extends Binder{
     P9BoundServiceClass getService1(){
         return  new P9BoundServiceClass();
     }
 }
 public  String getMsg1(){
     return "This is message 1";
 }
    public  String getMsg2(){
      random= new Random();
      int noBetween=50;

        return "My random number is "+ " "+ random.nextInt(noBetween);
    }
}
