package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class quiz_selesai extends AppCompatActivity {

    TextView tv_poin,tv_score;
    ImageView iv_finish;
    Button btn_finish;

    int score =0;
    int poin =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selesai);

        iv_finish = findViewById(R.id.iv_finish);
        btn_finish = findViewById(R.id.btn_finish);
        tv_poin = findViewById(R.id.tv_poin);
        tv_score=findViewById(R.id.tv_score);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            poin = bundle.getInt("poin");
            score = bundle.getInt("score");
        }

        tv_score.setText("Score : "+ score);
        tv_poin.setText("+"+poin +" Poin");

        Glide.with(quiz_selesai.this).load(getResources().getString(R.string.ip)+"finish.png").into(iv_finish);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}