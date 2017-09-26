package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CurrentCourse;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

public class LectureAdapter extends RecyclerView.Adapter<LectureViewHolder> {
    private Context context;
    private List<SimpleCourse> items;
    private final static String IMAGE_URL = "http://n0rr.iptime.org:7001/courses/";
    public LectureAdapter(Context context, List<SimpleCourse> items) {
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
        SimpleCourse item = items.get(position);
        holder.getTitle().setText(item.getTitle());
        holder.getTeacherName().setText(item.getUser().getUserName());
        holder.getUnit().setText(Integer.toString(item.getUnitTime())+"시간");
        Glide.with(context).load(IMAGE_URL + item.getCourseKey() + "/course-image.jpg").centerCrop().into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
