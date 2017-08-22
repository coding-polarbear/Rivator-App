package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseItem;

import java.util.List;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */

public class RecyclerItemAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerViewHolder> {
    Context context;
    List<CourseItem> courseItems;
    public RecyclerItemAdapter(Context context, List<CourseItem> courseItems) {
        this.context = context;
        this.courseItems = courseItems;
    }

    public RecyclerItemAdapter() {
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        CourseItem courseItem = courseItems.get(position);
        holder.getTitle().setText(courseItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.courseItems.size();
    }
}
