package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class P10BroadcastReceiverDynamically extends AppCompatActivity {
private BroadcastReceiver myBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_broadcast_receiver_dynamically);
//        myBroadcast=new P10ChargerConnected();
        myBroadcast=new P11batteryLevelBroadcast();
    }

    @Override
    protected void onStart() {
//        registerReceiver(myBroadcast,new IntentFilter(Intent.ACTION_POWER_CONNECTED));
//        registerReceiver(myBroadcast,new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        registerReceiver(myBroadcast,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {

        System.out.println("Charger get disconnected ");
        super.onStop();
    }
}