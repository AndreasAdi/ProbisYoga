package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yogafitnessapp.adapter.FaqAdapter;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.model.ProfileModel;
import com.example.yogafitnessapp.model.SearchModel;

import java.util.ArrayList;

public class Faq extends AppCompatActivity {

    TextView tv_friend;


    private FaqAdapter faqAdapter;
    private ArrayList<SearchModel> searchModelArrayList;
    private RecyclerView recyclerView;

    String[] tv_question={"What is pro (Sliver and Gold)?"
            ,"How to cancel the Pro subscription/free trial?",
            "What is pro (Sliver and Gold)?"
            ,"Why I can’t load/open the videos/ audios successfully?"};

    private RecyclerView recyclerView1;
    String[] tv_question1={"App Support"
            ,"Account & Profile settings",
            "Subsciptions & Billing and refunds"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setText("FAQ");

        recyclerView = findViewById(R.id.rv_faq);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Faq.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_question.length; i++) {
            SearchModel view1 = new SearchModel(tv_question[i]);
            searchModelArrayList.add(view1);
        }

        faqAdapter = new FaqAdapter(Faq.this,searchModelArrayList);
        recyclerView.setAdapter(faqAdapter);


        recyclerView1 = findViewById(R.id.rv_faq1);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Faq.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_question1.length; i++) {
            SearchModel view1 = new SearchModel(tv_question1[i]);
            searchModelArrayList.add(view1);
        }

        faqAdapter = new FaqAdapter(Faq.this,searchModelArrayList);
        recyclerView1.setAdapter(faqAdapter);

    }
}
