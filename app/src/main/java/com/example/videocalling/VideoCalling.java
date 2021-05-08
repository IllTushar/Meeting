package com.example.videocalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoCalling extends AppCompatActivity {
    Button btnjoin,btnabout;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_calling);
        text = (EditText) findViewById(R.id.code);
        btnabout = (Button)findViewById(R.id.about);
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoCalling.this,About.class);
                startActivity(i);
            }
        });
         btnjoin = (Button) findViewById(R.id.join);
        URL serverurl;
        try {
            serverurl = new URL("https://meet.jit.si");

            JitsiMeetConferenceOptions defaultOption = new JitsiMeetConferenceOptions.Builder().setServerURL(serverurl)
                    .setWelcomePageEnabled(false).build();
            JitsiMeet.setDefaultConferenceOptions(defaultOption);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = text.getText().toString();
                if(TextUtils.isEmpty(id)){
                    Toast.makeText(VideoCalling.this,"please enter your id !!",Toast.LENGTH_SHORT).show();
                }
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(text.getText().toString())
                        .setWelcomePageEnabled(false)
                        .build();
                JitsiMeetActivity.launch(VideoCalling.this,options);
            }
        });
    }
}