package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class P9OnBoundServiceSendMessage extends AppCompatActivity {
   P9BoundServiceClass p9BoundService;
   boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_onbound_service_send_message);


        Intent intent= new Intent(this,P9BoundServiceClass.class);

//        start service with binding
        bindService(intent,serVice_connection, Context.BIND_AUTO_CREATE);



    }
    // button click method
    public  void sendMessage(View view){
        Toast.makeText(P9OnBoundServiceSendMessage.this,p9BoundService.getMsg2(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flag){
            unbindService(serVice_connection);
            flag=false;
        }
    }
    ServiceConnection serVice_connection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service_binder) {
            P9BoundServiceClass.MyBinder myBinder=
                    (P9BoundServiceClass.MyBinder) service_binder;
            p9BoundService=myBinder.getService1();
            flag=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
              flag=false;
        }
    };

}