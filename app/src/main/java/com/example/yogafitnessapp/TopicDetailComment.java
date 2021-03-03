package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TopicDetailComment extends AppCompatActivity {

    TextView tv_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail_comment);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setText("Topic Details");

    }
}
