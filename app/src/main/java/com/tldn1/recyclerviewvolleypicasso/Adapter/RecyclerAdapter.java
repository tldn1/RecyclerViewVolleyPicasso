package com.tldn1.recyclerviewvolleypicasso.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tldn1.recyclerviewvolleypicasso.Model.SomethingModel;
import com.tldn1.recyclerviewvolleypicasso.R;

import java.util.ArrayList;

/**
 * Created by X on 12/25/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<SomethingModel> arrayList = new ArrayList<SomethingModel>();
    Context context;

    public RecyclerAdapter(ArrayList<SomethingModel> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        SomethingModel somethingModel = arrayList.get(position);
        holder.txtTitle.setText(somethingModel.getTitle());
        Picasso.with(context).load(somethingModel.getPicture()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtTitle;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        }
    }
}
