package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Createacount extends AppCompatActivity {

    TextView tv_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacount);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setVisibility(View.GONE);

    }
}
