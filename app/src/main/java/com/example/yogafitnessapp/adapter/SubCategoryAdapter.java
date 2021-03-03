package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.R;
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
        holder.iv_day1.setImageResource(profileModelArrayList.get(position).getIv_profile());
        holder.tv_day1.setText(profileModelArrayList.get(position).getTv_name());
        holder.tv_easy.setText(profileModelArrayList.get(position).getTv_city());

    }

    @Override
    public int getItemCount() {

        return profileModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_day1,tv_easy;
        ImageView iv_day1;

        public ViewHolder(View itemView) {

            super(itemView);
            iv_day1=itemView.findViewById(R.id.iv_day1);
            tv_day1=itemView.findViewById(R.id.tv_day1);
            tv_easy=itemView.findViewById(R.id.tv_easy);

        }
    }
}
