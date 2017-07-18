package com.rinc.bong.rivatorproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.beans.Item;

import java.util.List;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Item> items;
    public RecyclerAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.getTitle().setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
