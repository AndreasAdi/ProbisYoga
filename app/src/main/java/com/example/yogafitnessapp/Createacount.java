package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Createacount extends AppCompatActivity {

    TextView tv_friend;
    TextView btn_login,btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacount);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setVisibility(View.GONE);
        btn_login=findViewById(R.id.email);
        btn_reg=findViewById(R.id.fb);
    }

    public void onLoginClick(View v){
        Intent i;
        i= new Intent(this,Login.class);
        startActivity(i);
    }
    public void onRegisterClick(View v){
        Intent i;
        i= new Intent(this,Signup.class);
        startActivity(i);
    }
}
