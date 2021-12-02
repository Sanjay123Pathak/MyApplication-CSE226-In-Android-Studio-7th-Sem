package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyServicesActivity extends AppCompatActivity {
Button starBtn,stopBtn;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_services);
        starBtn=findViewById(R.id.startBtn);
       stopBtn=findViewById(R.id.stopBtn);

       starBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(), "Start the music !..", Toast.LENGTH_SHORT).show();

               startService(new Intent(getApplicationContext(),P8MusicService.class));
//               mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.mymusic);
//               mediaPlayer.start();
           }
       });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Music Stopped !", Toast.LENGTH_SHORT).show();
                stopService(new Intent(getApplicationContext(),P8MusicService.class));
//                mediaPlayer.stop();
            }
        });
    }
}