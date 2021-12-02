package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class P13UserDefinedMessage extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("API12333",""+intent.getAction());
        if (intent.getAction().equals("com.example.myapplication.SOME_ACTION")){
            Toast.makeText(context, "Some action is received", Toast.LENGTH_LONG).show();
        }
    }
}
