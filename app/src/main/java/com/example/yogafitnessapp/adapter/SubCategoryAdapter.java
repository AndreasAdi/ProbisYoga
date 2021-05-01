package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.VideoActivity;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>{

    Context context;
    private ArrayList<ProfileModel> profileModelArrayList;

    public SubCategoryAdapter(Context context, ArrayList<ProfileModel> profileModelArrayList) {
        this.context = context;
        this.profileModelArrayList = profileModelArrayList;
    }

    @NonNull
    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorydetailsub2,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SubCategoryAdapter.ViewHolder holder, final int position) {
        //holder.iv_day1.setImageResource(profileModelArrayList.get(position).getIv_profile());
        Glide.with(context).load(profileModelArrayList.get(position).getGambar()).into(holder.iv_day1);
        holder.tv_nama.setText(profileModelArrayList.get(position).getNama());
        holder.tv_waktu.setText(profileModelArrayList.get(position).getWaktu());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, VideoActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

        return profileModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nama,tv_waktu;
        ImageView iv_day1;

        public ViewHolder(View itemView) {

            super(itemView);
            tv_waktu=itemView.findViewById(R.id.tv_waktu);
            tv_nama=itemView.findViewById(R.id.tv_easy);
            iv_day1 = itemView.findViewById(R.id.iv_day1);


        }
    }
}
