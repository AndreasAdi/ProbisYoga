package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.model.WeightlossModel;

import java.util.ArrayList;

/**
 * Created by wolfsoft4 on 28/12/18.
 */

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder>{

    Context context;
    private ArrayList<WeightlossModel> weightlossModelArrayList;

    public ProgramAdapter(Context context, ArrayList<WeightlossModel> weightlossModelArrayList) {
        this.context = context;
        this.weightlossModelArrayList = weightlossModelArrayList;
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_program,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProgramAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(weightlossModelArrayList.get(position).getGambar()).into(holder.iv_weightloss);
        //holder.iv_weightloss.setImageResource(weightlossModelArrayList.get(position).getIv_weightloss());
    }

    @Override
    public int getItemCount() {

        return weightlossModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_weightloss;

        public ViewHolder(View itemView) {

            super(itemView);

            iv_weightloss=itemView.findViewById(R.id.iv_program);

        }
    }
}
