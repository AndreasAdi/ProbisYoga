package com.example.yogafitnessapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;

/**
 * Created by wolfsoft4 on 28/12/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{

    Context context;
    private ArrayList<ProfileModel> profileModelArrayList;

    public ProfileAdapter(Context context, ArrayList<ProfileModel> profileModelArrayList) {
        this.context = context;
        this.profileModelArrayList = profileModelArrayList;
    }

    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ProfileAdapter.ViewHolder holder, final int position) {
        holder.iv_profile.setImageResource(profileModelArrayList.get(position).getIv_profile());
        holder.tv_name.setText(profileModelArrayList.get(position).getTv_name());
        holder.tv_city.setText(profileModelArrayList.get(position).getTv_city());

        if (position==0 || position==4 || position==5){
            holder.tv_follow.setTextColor(Color.parseColor("#ffffff"));
            holder.tv_follow.setBackgroundResource(R.drawable.rect_pink_radius);
        }

    }

    @Override
    public int getItemCount() {

        return profileModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;

        TextView tv_name,tv_city,tv_follow;


        public ViewHolder(View itemView) {

            super(itemView);

            iv_profile=itemView.findViewById(R.id.iv_profile);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_city=itemView.findViewById(R.id.tv_city);
            tv_follow=itemView.findViewById(R.id.tv_follow);


        }
    }
}
