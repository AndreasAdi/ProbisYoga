package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.model.SearchModel;

import java.util.ArrayList;

/**
 * Created by wolfsoft4 on 28/12/18.
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder>{

    int mypos;

    Context context;
    private ArrayList<SearchModel> searchModelArrayList;

    public TypeAdapter(Context context, ArrayList<SearchModel> searchModelArrayList) {
        this.context = context;
        this.searchModelArrayList = searchModelArrayList;
    }

    @NonNull
    @Override
    public TypeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TypeAdapter.ViewHolder holder, final int position) {

        holder.tv_flexibility.setText(searchModelArrayList.get(position).getTv_flexibility());

        if (position==1 || position==2){
            holder.tv_flexibility.setTextColor(Color.parseColor("#ffffff"));
            holder.tv_flexibility.setBackgroundResource(R.drawable.rect_pink_radius);
        }

    }

    @Override
    public int getItemCount() {

        return searchModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_flexibility;

        public ViewHolder(View itemView) {

            super(itemView);

            tv_flexibility=itemView.findViewById(R.id.tv_session);

        }
    }
}
