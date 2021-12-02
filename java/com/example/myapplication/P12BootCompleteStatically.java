package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class P12BootCompleteStatically extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action!=null){
            if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
                Intent i=new Intent(context,P5MainRecyclerView.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        }
    }
}
