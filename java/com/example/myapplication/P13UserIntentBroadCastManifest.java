package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P13UserIntentBroadCastManifest extends AppCompatActivity {
IntentFilter intentFilter;
P13UserDefinedMessage p13UserdefinedMessage;
Button send_Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p13_user_intent_broad_cast_manifest);
        send_Message=findViewById(R.id.sendMessage);
        p13UserdefinedMessage=new P13UserDefinedMessage();
        intentFilter= new IntentFilter("com.example.myapplication.SOME_ACTION");
        send_Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.example.myapplication.SOME_ACTION");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(p13UserdefinedMessage,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerReceiver(p13UserdefinedMessage,intentFilter);
    }
}