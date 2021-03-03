package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yogafitnessapp.adapter.BodyPartAdapter;
import com.example.yogafitnessapp.adapter.DurationAdapter;
import com.example.yogafitnessapp.adapter.LevelAdapter;
import com.example.yogafitnessapp.adapter.SearchAdapter;
import com.example.yogafitnessapp.adapter.TypeAdapter;
import com.example.yogafitnessapp.model.SearchModel;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import java.util.ArrayList;

public class Filter extends AppCompatActivity {

    private TypeAdapter typeAdapter;
    private ArrayList<SearchModel> searchModelArrayList;
    private RecyclerView recyclerView;

    String[] tv_flexibility={"Session","Program","Workshop"};

    private LevelAdapter levelAdapter;
    private RecyclerView recyclerView1;

    String[] tv_flexibility1={"Level 1","Level 1-2","Level 2","Level 2-3","Level 3"};

    private DurationAdapter durationAdapter;
    private RecyclerView recyclerView2;

    String[] tv_flexibility2={"0-10 min","10-20 min","20-30min","30-45 min","45-60 min",">60 min"};

    private DurationAdapter durationAdapter1;
    private RecyclerView recyclerView3;

    String[] tv_flexibility3={"0-10 min","10-20 min","20-30min","30-45 min","45-60 min",">60 min"};


    TextView tv_friend;
    ImageView iv_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setText("Filter");

        iv_close=findViewById(R.id.iv_close);
        iv_close.setImageResource(R.drawable.ic_close);



        recyclerView = findViewById(R.id.rv_type);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Filter.this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_flexibility.length; i++) {
            SearchModel view1 = new SearchModel(tv_flexibility[i]);
            searchModelArrayList.add(view1);
        }

       typeAdapter = new TypeAdapter(Filter.this,searchModelArrayList);
        recyclerView.setAdapter(typeAdapter);

        /*level recycler:*/
        recyclerView1 = findViewById(R.id.rv_level);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(Filter.this,4);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_flexibility1.length; i++) {
            SearchModel view1 = new SearchModel(tv_flexibility1[i]);
            searchModelArrayList.add(view1);
        }

        levelAdapter = new LevelAdapter(Filter.this,searchModelArrayList);
        recyclerView1.setAdapter(levelAdapter);



        recyclerView2 = findViewById(R.id.rv_duration);
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(Filter.this,4);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_flexibility2.length; i++) {
            SearchModel view1 = new SearchModel(tv_flexibility2[i]);
            searchModelArrayList.add(view1);
        }

        durationAdapter = new DurationAdapter(Filter.this,searchModelArrayList);
        recyclerView2.setAdapter(durationAdapter);


        recyclerView3 = findViewById(R.id.rv_focus);
        RecyclerView.LayoutManager layoutManager3 = new GridLayoutManager(Filter.this,4);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());

        searchModelArrayList = new ArrayList<>();

        for (int i = 0; i < tv_flexibility3.length; i++) {
            SearchModel view1 = new SearchModel(tv_flexibility3[i]);
            searchModelArrayList.add(view1);
        }

        durationAdapter1 = new DurationAdapter(Filter.this,searchModelArrayList);
        recyclerView3.setAdapter(durationAdapter1);




    }
}
