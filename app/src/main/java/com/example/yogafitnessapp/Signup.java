package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    ImageView iv_close;
    TextView tv_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        iv_close=findViewById(R.id.iv_close);
        iv_close.setImageResource(R.drawable.ic_close);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setVisibility(View.GONE);

    }
}
