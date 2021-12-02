package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class P11batteryLevelBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
     int bLevel=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
//        int bLevel=Integer.parseInt(levelBattery);
        if (bLevel<=20 | bLevel<30){
            Toast.makeText(context, "Battery level is above 20 and between 30 %", Toast.LENGTH_SHORT).show();
        }
        else if (bLevel<=50 | bLevel<80){
            Toast.makeText(context, "Battery level is above 60 % and between 80", Toast.LENGTH_SHORT).show();
        }
       else {
            Toast.makeText(context, "Battery level 100 %", Toast.LENGTH_SHORT).show();

        }
//        switch (levelBattery){
//            case Intent.ACTION_BATTERY_LOW:
//                Toast.makeText(context, "Battery less than 20 %", Toast.LENGTH_SHORT).show();
//                break;
//            case Intent.ACTION_BATTERY_OKAY:
//                Toast.makeText(context, "battery is ok now", Toast.LENGTH_SHORT).show();
//            default:
//        }
    }
}
