package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;

public class CategoriesDetailSub2 extends AppCompatActivity {

    private SubCategoryAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1};

    String[] tv_name={"DAY 01","DAY 02","DAY 03"
            ,"DAY 04","DAY 05","DAY 06"};

    String[] tv_city={"Easy Yoga for Strength","Easy Yoga for Body Stretches","Easy Yoga for Neck & Back"
            ,"Easy Yoga for Strength","Easy Yoga for Body Stretches","Easy Yoga for Neck & Back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_detail_sub2);

        recyclerView = findViewById(R.id.rv_schedule);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoriesDetailSub2.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {
            ProfileModel view1 = new ProfileModel(iv_profile[i],tv_name[i],tv_city[i]);
            profileModelArrayList.add(view1);
        }
        profileAdapter = new SubCategoryAdapter(CategoriesDetailSub2.this,profileModelArrayList);
        recyclerView.setAdapter(profileAdapter);
    }
}
