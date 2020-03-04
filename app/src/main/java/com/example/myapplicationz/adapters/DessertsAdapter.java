package com.example.myapplicationz.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationz.R;
import com.example.myapplicationz.model.Desserts;

import java.util.ArrayList;
import java.util.List;

public class DessertsAdapter extends RecyclerView.Adapter<DessertsAdapter.ViewHolder> {

    private static final String TAG = "DessertsAdapter";

    private LayoutInflater mLayoutInflater;
    private List<Desserts> mDesserts = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener listener;


    public DessertsAdapter(List<Desserts> mDesserts, Context mContext, OnItemClickListener listener) {
        this.mDesserts = mDesserts;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: pasa");
        View view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_desserts, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: pasa");
        Desserts desserts = mDesserts.get(position);
        holder.textView.setText(desserts.getDessertName());
        Glide.with(holder.imageView.getContext()).load(desserts.getId()).centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return mDesserts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewListItem);
            textView = itemView.findViewById(R.id.textViewListItem);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick (this, getNameByPosition(getAdapterPosition()), getImageByPosition(getAdapterPosition()));
            getImageByPosition(getAdapterPosition());
        }

    }

    private String getNameByPosition(int position) {
        if (position != RecyclerView.NO_POSITION) {
            return mDesserts.get(position).getDessertName();
        } else {
            return "DontExistPosition";
        }
    }

    private int getImageByPosition(int position) {
        if (position != RecyclerView.NO_POSITION) {
            return mDesserts.get(position).getId();
        } else {
            return 0;
        }
    }


    public interface OnItemClickListener {
        public void onClick(DessertsAdapter.ViewHolder viewHolder, String imageView, int id);

    }
}
