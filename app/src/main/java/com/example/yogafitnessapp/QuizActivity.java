package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class QuizActivity extends AppCompatActivity {
    Button btn_a,btn_b,btn_c,btn_d,btn_next;
    TextView tv_pertanyaan;
    ImageView iv_gambar_quiz;
    ProgressBar progressBar;
    String kunci_jawaban;
    int index =0;
    int score= 0;
    ArrayList<quiz> list_quiz = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btn_a = findViewById(R.id.btn_a);
        btn_b = findViewById(R.id.btn_b);
        btn_c = findViewById(R.id.btn_c);
        btn_d = findViewById(R.id.btn_d);
        btn_next = findViewById(R.id.btn_next_question);
        tv_pertanyaan = findViewById(R.id.tv_pertanyaan);
        iv_gambar_quiz =findViewById(R.id.iv_gambar_quiz);
        progressBar=findViewById(R.id.progressBar);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (kunci_jawaban.equals("a")){
                 btn_a.setBackgroundResource(R.drawable.jawaban_benar);
             }
             else btn_a.setBackgroundResource(R.drawable.jawaban_salah);
            }
        });

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_jawaban(btn_a,kunci_jawaban,"a");
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_jawaban(btn_b,kunci_jawaban,"b");
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_jawaban(btn_c,kunci_jawaban,"c");
            }
        });
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_jawaban(btn_d,kunci_jawaban,"d");
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setProgress((index+1)*20);
                index++;
                if (index<list_quiz.size()){
                    load_soal();
                    reset_button();
                }

                if (index>4){
                    tambah_poin();
                    Intent i = new Intent(QuizActivity.this,quiz_selesai.class);
                    i.putExtra("score",score);
                    i.putExtra("poin",score/2);
                    startActivity(i);
                    finish();
                }



            }
        });

        load_quiz();

    }

    private void cek_jawaban(Button button,String kunci_jawaban,String pilihan){
        if (kunci_jawaban.equals(pilihan)){
            button.setBackgroundResource(R.drawable.jawaban_benar);
            score+=20;
        }
        else{
            button.setBackgroundResource(R.drawable.jawaban_salah);
        }

        btn_a.setEnabled(false);
        btn_b.setEnabled(false);
        btn_c.setEnabled(false);
        btn_d.setEnabled(false);

        btn_a.setTextColor(Color.BLACK);
        btn_b.setTextColor(Color.BLACK);
        btn_c.setTextColor(Color.BLACK);
        btn_d.setTextColor(Color.BLACK);

        button.setTextColor(Color.WHITE);
        btn_next.setEnabled(true);
        btn_next.setVisibility(View.VISIBLE);



    }

    private void load_soal(){
        tv_pertanyaan.setText(list_quiz.get(index).getPertanyaan());
        btn_a.setText(list_quiz.get(index).getPilihan_a());
        btn_b.setText(list_quiz.get(index).getPilihan_b());
        btn_c.setText(list_quiz.get(index).getPilihan_c());
        btn_d.setText(list_quiz.get(index).getPilihan_d());
        kunci_jawaban = list_quiz.get(index).getJawaban();

        Glide.with(QuizActivity.this).
                load(getResources().getString(R.string.ip)+list_quiz.get(index).gambar).
                placeholder(R.drawable.yoga1).
                into(iv_gambar_quiz);


    }

    private void reset_button(){
        btn_next.setEnabled(false);
        btn_next.setVisibility(View.INVISIBLE);

        btn_a.setEnabled(true);
        btn_b.setEnabled(true);
        btn_c.setEnabled(true);
        btn_d.setEnabled(true);

        btn_a.setTextColor(Color.BLACK);
        btn_b.setTextColor(Color.BLACK);
        btn_c.setTextColor(Color.BLACK);
        btn_d.setTextColor(Color.BLACK);

        btn_a.setBackgroundResource(R.drawable.rect_pink_border);
        btn_b.setBackgroundResource(R.drawable.rect_pink_border);
        btn_c.setBackgroundResource(R.drawable.rect_pink_border);
        btn_d.setBackgroundResource(R.drawable.rect_pink_border);
    }

    private void load_quiz(){
        StringRequest strReq= new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),//ini masih pakai IP ku
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");
                            JSONArray pertanyaan = jsonObject.getJSONArray("pertanyaan");
                            JSONArray gambar = jsonObject.getJSONArray("gambar");
                            JSONArray jawaban = jsonObject.getJSONArray("jawaban");
                            JSONArray pilihan_a = jsonObject.getJSONArray("pilihan_a");
                            JSONArray pilihan_b = jsonObject.getJSONArray("pilihan_b");
                            JSONArray pilihan_c = jsonObject.getJSONArray("pilihan_c");
                            JSONArray pilihan_d = jsonObject.getJSONArray("pilihan_d");
                            String message=jsonObject.getString("message");

                            if(code==1){
                                for (int i = 0; i <pertanyaan.length(); i++) {
                                    list_quiz.add(new quiz(
                                            pertanyaan.getString(i),
                                            gambar.getString(i),
                                            jawaban.getString(i),
                                            pilihan_a.getString(i),
                                            pilihan_b.getString(i),
                                            pilihan_c.getString(i),
                                            pilihan_d.getString(i)
                                    ));
                                }
                                System.out.println("tidak ada error");
                                Collections.shuffle(list_quiz);
                                load_soal();

                            }
                            else{
                                System.out.println("Ada error");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("function","load_quiz");
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(QuizActivity.this);
        requestQueue.add(strReq);


    }

    private void tambah_poin(){
        StringRequest strReq= new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),//ini masih pakai IP ku
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");

                            if(code==1){
                                System.out.println("Tidak Ada error");
                            }
                            else{
                                System.out.println("Ada error");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("function","tambah_poin");
                params.put("id_user",Home.id_user);
                params.put("poin",String.valueOf(score/2));
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(QuizActivity.this);
        requestQueue.add(strReq);
    }
}