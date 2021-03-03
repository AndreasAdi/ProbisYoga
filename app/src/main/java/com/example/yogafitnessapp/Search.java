package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yogafitnessapp.adapter.CategorydetailAdapter;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SearchAdapter;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.ProfileModel;
import com.example.yogafitnessapp.model.SearchModel;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private SearchAdapter searchAdapter;
    private ArrayList<SearchModel> searchModelArrayList;
    private RecyclerView recyclerView;

    String[] tv_flexibility={"Flexibility","Back pain","Sleep","Abs","Morning","Neck",
    "For men","Health","Begin yoga"};


    private CategorydetailAdapter categorydetailAdapter;
    private ArrayList<CategoryModel> categoryModelArrayList;
    private RecyclerView recyclerView1;

    String[] tv_week={"1 WEEK","2 WEEKS","2 WEEKS","2 WEEKS"};
    String[] tv_trial={"TRIAL","PRO","PRO","PRO"};
    String[] tv_yoga={"Easy Yoga For Complete Beginners","Yoga Basics for Beginners","12 Must-Know Yoga Poses for Beginners",
            "12 Must-Know Yoga Poses for Beginners"};
    String[] tv_level={"Level 1","Level 2","Level 2","Level 2"};
    Integer[] iv_yoga={R.drawable.group1,
            R.drawable.group1
            ,R.drawable.group1,
            R.drawable.group1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.rv_searches);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Search.this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_flexibility.length; i++) {
            SearchModel view1 = new SearchModel(tv_flexibility[i]);
            searchModelArrayList.add(view1);
        }
        searchAdapter = new SearchAdapter(Search.this,searchModelArrayList);
        recyclerView.setAdapter(searchAdapter);


        recyclerView1 = findViewById(R.id.rv_categorydetail);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Search.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        categoryModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_week.length; i++) {
            CategoryModel view1 = new CategoryModel(tv_week[i],tv_trial[i],tv_yoga[i],tv_level[i],iv_yoga[i]);
            categoryModelArrayList.add(view1);
        }
        categorydetailAdapter = new CategorydetailAdapter(Search.this,categoryModelArrayList);
        recyclerView1.setAdapter(categorydetailAdapter);


    }
}
