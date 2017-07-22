package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.LectureItem;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

public class LectureAdapter extends RecyclerView.Adapter<LectureViewHolder> {
    private Context context;
    private ArrayList<LectureItem> items;
    public LectureAdapter(Context context, ArrayList<LectureItem> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public LectureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_card_view, null);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LectureViewHolder holder, int position) {
        LectureItem item = items.get(position);
        holder.getTitle().setText(item.getTitle());
        holder.getTeacherName().setText(item.getTeacherName());
        holder.getUnit().setText(Integer.toString(item.getUnitTime())+"시간");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
