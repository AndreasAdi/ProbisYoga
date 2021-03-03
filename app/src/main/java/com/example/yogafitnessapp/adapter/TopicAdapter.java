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
import com.example.yogafitnessapp.model.SettingsModel;

import java.util.ArrayList;

/**
 * Created by wolfsoft4 on 28/12/18.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{

    Context context;
    private ArrayList<SettingsModel> settingsModelArrayList;

    public TopicAdapter(Context context, ArrayList<SettingsModel> settingsModelArrayList) {
        this.context = context;
        this.settingsModelArrayList = settingsModelArrayList;
    }

    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hottopics,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final TopicAdapter.ViewHolder holder, final int position) {

        holder.iv_profile.setImageResource(settingsModelArrayList.get(position).getIv_profile());

        holder.tv_account.setText(settingsModelArrayList.get(position).getTv_account());
    }

    @Override
    public int getItemCount() {

        return settingsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;

        TextView tv_account;

        public ViewHolder(View itemView) {

            super(itemView);

            iv_profile=itemView.findViewById(R.id.iv_salad);
            tv_account=itemView.findViewById(R.id.tv_dinner);

        }
    }
}
