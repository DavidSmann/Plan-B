package com.example.plan_b_exercise.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plan_b_exercise.Models.MapModel;
import com.example.plan_b_exercise.R;

import java.util.ArrayList;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.ViewHolder> {
    ArrayList<MapModel> mapModels;
    Context context;

    public MapAdapter (Context context, ArrayList<MapModel> mapModels){
        this.context = context;
        this.mapModels = mapModels;
    }

    @NonNull
    @Override
    public MapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_items,parent,false  );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(mapModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return mapModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageMap);
        }
    }
}
