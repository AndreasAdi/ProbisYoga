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
import com.example.yogafitnessapp.CategorieDetailSub1;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.model.WeightlossModel;

import java.util.ArrayList;



public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    Context context;
    private ArrayList<WeightlossModel> weightlossModelArrayList;


    public CoursesAdapter(Context context, ArrayList<WeightlossModel> weightlossModelArrayList) {
        this.context = context;
        this.weightlossModelArrayList = weightlossModelArrayList;

    }

    @NonNull
    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CoursesAdapter.ViewHolder holder, final int position) {
        //holder.iv_weightloss.setImageResource(R.drawable.bridge_pose);
        Glide.with(this.context).load(weightlossModelArrayList.get(position).getGambar()).
                placeholder(R.drawable.yoga1).into(holder.iv_weightloss);
        holder.tv_nama.setText(weightlossModelArrayList.get(position).getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CategorieDetailSub1.class);
                i.putExtra("id",weightlossModelArrayList.get(position).getId());
                i.putExtra("gambar",weightlossModelArrayList.get(position).getGambar());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return weightlossModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_weightloss;
        TextView tv_nama;
        public ViewHolder(View itemView) {

            super(itemView);

            iv_weightloss=itemView.findViewById(R.id.iv_yoga);
            tv_nama = itemView.findViewById(R.id.tv_nama);

        }



    }


}
