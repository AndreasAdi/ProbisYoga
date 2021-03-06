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

public class Seetings1Adapter extends RecyclerView.Adapter<Seetings1Adapter.ViewHolder> {

    Context context;
    private ArrayList<SettingsModel> settingsModelArrayList;

    public Seetings1Adapter(Context context, ArrayList<SettingsModel> settingsModelArrayList) {
        this.context = context;
        this.settingsModelArrayList = settingsModelArrayList;
    }

    @NonNull
    @Override
    public Seetings1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final Seetings1Adapter.ViewHolder holder, final int position) {

        holder.iv_profile.setImageResource(settingsModelArrayList.get(position).getIv_profile());

        holder.tv_account.setText(settingsModelArrayList.get(position).getTv_account());

    }

    @Override
    public int getItemCount() {

        return settingsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;

        TextView tv_account, tv_m;

        public ViewHolder(View itemView) {

            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_account = itemView.findViewById(R.id.tv_account);
            tv_m = itemView.findViewById(R.id.tv_m);

        }
    }
}
