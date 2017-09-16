package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseItem;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.User;

import java.util.List;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */

public class RecyclerItemAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerViewHolder> {
    Context context;
    List<SimpleCourse> courseList;
    private static String IMAGE_URL = "http://n0rr.iptime.org:7001/courses/";
    public RecyclerItemAdapter(Context context, List<SimpleCourse> courseList) {
        this.context = context;
        this.courseList = courseList;
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
        SimpleCourse simpleCourse = courseList.get(position);
        holder.getTitle().setText(simpleCourse.getTitle());
        if(simpleCourse.getCourseKey() > 0)
            Glide.with(context).load(IMAGE_URL + simpleCourse.getCourseKey() + "/course-image.jpg").into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return this.courseList.size();
    }
}
