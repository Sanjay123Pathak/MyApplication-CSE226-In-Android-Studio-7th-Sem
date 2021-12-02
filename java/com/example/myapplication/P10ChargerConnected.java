package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class P10ChargerConnected extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("On receive method");

        String intentString=intent.getAction();
        switch (intentString){
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Charger is connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Charger disconnected ", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
