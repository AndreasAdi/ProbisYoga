package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yogafitnessapp.adapter.CategorydetailAdapter;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;

public class CategoriesDetail extends AppCompatActivity {

    TextView tv_friend;

    private CategorydetailAdapter categorydetailAdapter;
    private ArrayList<CategoryModel> categoryModelArrayList;
    private RecyclerView recyclerView;

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
        setContentView(R.layout.activity_categories_detail);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setText("Essentials For Beginners");

        recyclerView = findViewById(R.id.rv_categorydetail);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoriesDetail.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        categoryModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_week.length; i++) {
            CategoryModel view1 = new CategoryModel(tv_week[i],tv_trial[i],tv_yoga[i],tv_level[i],iv_yoga[i]);
            categoryModelArrayList.add(view1);
        }
        categorydetailAdapter = new CategorydetailAdapter(CategoriesDetail.this,categoryModelArrayList);
        recyclerView.setAdapter(categorydetailAdapter);
    }
}
