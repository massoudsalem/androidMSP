package com.example.mohmassoud.customrecycleview;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Moh.Massoud on 6/30/2018.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final Context currActivity;
    private final List<listItem> dataList;
    private final LayoutInflater inflater;

    public RecyclerViewAdapter(Context currActivity, List<listItem> dataList) {
        this.currActivity = currActivity;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(currActivity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView desTextView;
        TextView ratingTextView;
        ImageView imageView;
        RatingBar ratingBar;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            desTextView=itemView.findViewById(R.id.desTextView);
            ratingTextView=itemView.findViewById(R.id.ratingTextView);
            imageView=itemView.findViewById(R.id.imageView);
            ratingBar=itemView.findViewById(R.id.ratingBar);
        }
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.itemview,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        listItem currItem = dataList.get(position);
        holder.nameTextView.setText(currItem.getItemName());
        holder.desTextView.setText(currItem.getItemDes());
        holder.ratingTextView.setText(String.format("%.1f", currItem.getItemRating()));
        holder.imageView.setImageResource(currItem.getItemImg());
        holder.ratingBar.setRating((float)currItem.getItemRating());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
