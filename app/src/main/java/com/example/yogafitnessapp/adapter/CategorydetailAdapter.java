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

/**
 * Created by wolfsoft4 on 28/12/18.
 */

public class CategorydetailAdapter extends RecyclerView.Adapter<CategorydetailAdapter.ViewHolder>{

    Context context;
    private ArrayList<CategoryModel> categoryModelArrayList;

    public CategorydetailAdapter(Context context, ArrayList<CategoryModel> categoryModelArrayList) {
        this.context = context;
        this.categoryModelArrayList = categoryModelArrayList;
    }

    @NonNull
    @Override
    public CategorydetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorydetail,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CategorydetailAdapter.ViewHolder holder, final int position) {
        holder.tv_week.setText(categoryModelArrayList.get(position).getTv_week());
        holder.tv_trial.setText(categoryModelArrayList.get(position).getTv_trial());
        holder.tv_yoga.setText(categoryModelArrayList.get(position).getTv_yoga());
        holder.tv_level.setText(categoryModelArrayList.get(position).getTv_level());
        holder.iv_yoga.setImageResource(categoryModelArrayList.get(position).getIv_yoga());

        if (position==2 ||position==3){

            holder.tv_trial.setBackgroundResource(R.drawable.rect_yellow);
        }


    }

    @Override
    public int getItemCount() {

        return categoryModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_week,tv_trial,tv_yoga,tv_level;

        ImageView iv_yoga;

        public ViewHolder(View itemView) {

            super(itemView);

            tv_week=itemView.findViewById(R.id.tv_week);
            tv_trial=itemView.findViewById(R.id.tv_trial);
            tv_yoga=itemView.findViewById(R.id.tv_yoga);
            tv_level=itemView.findViewById(R.id.tv_level);
            iv_yoga=itemView.findViewById(R.id.iv_yoga);


        }
    }
}
