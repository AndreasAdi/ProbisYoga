package com.example.yogafitnessapp.adapter;

import android.content.Context;
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

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder>{

    Context context;
    private ArrayList<SearchModel> searchModelArrayList;

    public FaqAdapter(Context context, ArrayList<SearchModel> searchModelArrayList) {
        this.context = context;
        this.searchModelArrayList = searchModelArrayList;
    }

    @NonNull
    @Override
    public FaqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FaqAdapter.ViewHolder holder, final int position) {
        holder.tv_flexibility.setText(searchModelArrayList.get(position).getTv_flexibility());
    }

    @Override
    public int getItemCount() {

        return searchModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_flexibility;

        public ViewHolder(View itemView) {

            super(itemView);

            tv_flexibility=itemView.findViewById(R.id.tv_question);

        }
    }
}
