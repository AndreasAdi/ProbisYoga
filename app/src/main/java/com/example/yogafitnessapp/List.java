package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yogafitnessapp.adapter.List_RecyAdapter;
import com.example.yogafitnessapp.model.ListModel;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private List_RecyAdapter coffeeList_recyAdapter;
    private RecyclerView recyclerview;
    private ArrayList<ListModel> coffeelistModelArrayList;

    String txt[]={"Walkthrough","Welcome","Createacount", "Signup", "Home",
            "CategoriesDetail","CategorieDetailSub1","CategoriesDetailSub2","Filter",
            "Search","TopicDetailComment","TopicDetail",
            "Profile Coupon Voucher","ProfileAddFriend","Faq","Settings"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerview=findViewById(R.id.recyclerView1);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(List.this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        coffeelistModelArrayList = new ArrayList<>();

        for (int i=0;i<txt.length;i++){
            ListModel coffeelistModel = new ListModel(txt[i]);
            coffeelistModelArrayList.add(coffeelistModel);
        }
        coffeeList_recyAdapter = new List_RecyAdapter(List.this,coffeelistModelArrayList);
        recyclerview.setAdapter(coffeeList_recyAdapter);

    }

}
