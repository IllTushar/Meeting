package com.example.videocalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = (TextView)findViewById(R.id.txt);
      Thread  mythread = new Thread(new Runnable() {
          @Override
          public void run() {
             try {
                 sleep(5000);
                 Intent i = new Intent(MainActivity.this,VideoCalling.class);
                 startActivity(i);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
          }
      });
      mythread.start();
    }

}