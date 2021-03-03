package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yogafitnessapp.adapter.CategorydetailAdapter;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.ProfileModel;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class CategorieDetailSub1 extends AppCompatActivity {

    private SubCategoryAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1};

    String[] tv_name={"DAY 01","DAY 02","DAY 03"
            ,"DAY 04","DAY 05","DAY 06"};

    String[] tv_city={"11 mins","10 mins","15 mins"
            ,"15 mins","18 mins","15 mins"};

    ImageView back, back1, share, share1, like;
    TextView tv_puma, txtheading;
    Toolbar toolbar;
    LinearLayout linear2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_detail_sub1);

        back = (ImageView) findViewById(R.id.back);
        back1 = (ImageView) findViewById(R.id.back1);
        tv_puma = (TextView) findViewById(R.id.title);
        txtheading = (TextView) findViewById(R.id.txtheading);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        back = (ImageView) findViewById(R.id.back);
        back1 = (ImageView) findViewById(R.id.back1);
        like = (ImageView) findViewById(R.id.like);
        tv_puma = (TextView) findViewById(R.id.title);
        txtheading = (TextView) findViewById(R.id.txtheading);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //collapsing toolbar:
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.mainappbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {

                    //is collapsed
                    //   logo.setVisibility(View.GONE);
                    txtheading.setVisibility(View.VISIBLE);
                    txtheading.setTextColor(Color.parseColor("#000000"));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.white));
                    back1.setVisibility(View.VISIBLE);
                    back.setVisibility(View.GONE);
                    tv_puma.setVisibility(View.GONE);
                    isShow = true;

                } else if (isShow) {
                    isShow = false;

                    //is not collapsed
                    //  logo.setVisibility(View.VISIBLE);
                    txtheading.setVisibility(View.GONE);
                    tv_puma.setVisibility(View.VISIBLE);
                    toolbar.setBackgroundColor(getResources().getColor(R.color.transperent));
                }
            }
        });

        recyclerView = findViewById(R.id.rv_schedule);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategorieDetailSub1.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {
            ProfileModel view1 = new ProfileModel(iv_profile[i],tv_name[i],tv_city[i]);
            profileModelArrayList.add(view1);
        }
        profileAdapter = new SubCategoryAdapter(CategorieDetailSub1.this,profileModelArrayList);
        recyclerView.setAdapter(profileAdapter);

    }
}

