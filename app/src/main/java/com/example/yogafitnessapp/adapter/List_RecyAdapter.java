package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.CategorieDetailSub1;
import com.example.yogafitnessapp.CategoriesDetail;
import com.example.yogafitnessapp.CategoriesDetailSub2;
import com.example.yogafitnessapp.Createacount;
import com.example.yogafitnessapp.Faq;
import com.example.yogafitnessapp.Filter;
import com.example.yogafitnessapp.Home;
import com.example.yogafitnessapp.ProfileAddFriend;
import com.example.yogafitnessapp.Profile_Coupon_Voucher;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.Search;
import com.example.yogafitnessapp.Settings;
import com.example.yogafitnessapp.Signup;
import com.example.yogafitnessapp.TopicDetail;
import com.example.yogafitnessapp.TopicDetailComment;
import com.example.yogafitnessapp.Walkthrough;
import com.example.yogafitnessapp.Welcome;
import com.example.yogafitnessapp.model.ListModel;

import java.util.ArrayList;


/**
 * Created by wolfsoft4 on 10/8/18.
 * */

public class List_RecyAdapter extends RecyclerView.Adapter<List_RecyAdapter.ViewHolder> {

    Context context;
    private ArrayList<ListModel> coffeelistModelArrayList;

    public List_RecyAdapter(Context context, ArrayList<ListModel> coffeelistModelArrayList) {
        this.context = context;
        this.coffeelistModelArrayList = coffeelistModelArrayList;

    }

    @Override
    public List_RecyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new List_RecyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(List_RecyAdapter.ViewHolder holder, final int position) {

        holder.title.setText(coffeelistModelArrayList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent i = new Intent(context, Walkthrough.class);
                    context.startActivity(i);
                }  else if (position == 1) {
                    Intent i = new Intent(context, Welcome.class);
                    context.startActivity(i);
                }else if (position == 2) {
                    Intent i = new Intent(context, Createacount.class);
                    context.startActivity(i);
                }else if (position == 3) {
                    Intent i = new Intent(context,Signup .class);
                    context.startActivity(i);
                }else if (position == 4) {
                    Intent i = new Intent(context, Home.class);
                    context.startActivity(i);
                }else if (position == 5) {
                    Intent i = new Intent(context, CategoriesDetail.class);
                    context.startActivity(i);
                }else if (position == 6) {
                    Intent i = new Intent(context, CategorieDetailSub1.class);
                    context.startActivity(i);
                }else if (position == 7) {
                    Intent i = new Intent(context, CategoriesDetailSub2.class);
                    context.startActivity(i);
                }else if (position == 8) {
                    Intent i = new Intent(context, Filter.class);
                    context.startActivity(i);
                }else if (position == 9) {
                    Intent i = new Intent(context, Search.class);
                    context.startActivity(i);
                }else if (position == 10) {
                    Intent i = new Intent(context,TopicDetailComment .class);
                    context.startActivity(i);
                }else if (position == 11) {
                    Intent i = new Intent(context,TopicDetail .class);
                    context.startActivity(i);
                }else if (position == 12) {
                    Intent i = new Intent(context, Profile_Coupon_Voucher.class);
                    context.startActivity(i);
                }else if (position == 13) {
                    Intent i = new Intent(context, ProfileAddFriend.class);
                    context.startActivity(i);
                }else if (position == 14) {
                    Intent i = new Intent(context, Faq.class);
                    context.startActivity(i);
                }else if (position == 15) {
                    Intent i = new Intent(context, Settings.class);
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return coffeelistModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
        }
    }
}
