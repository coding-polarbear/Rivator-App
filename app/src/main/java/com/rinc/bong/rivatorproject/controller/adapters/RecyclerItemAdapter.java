package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseItem;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.CourseDetailActivity;

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
        String title = simpleCourse.getTitle();
        if(title.length() > 10)
            title = title.substring(0,7) + "...";
        holder.getTitle().setText(title);
        if(simpleCourse.getCourseKey() > 0)
            Glide.with(context).load(IMAGE_URL + simpleCourse.getCourseKey() + "/course-image.jpg")
                    .centerCrop().into(holder.getImageView());
        holder.getCard().setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra("courseKey",simpleCourse.getCourseKey());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.courseList.size();
    }
}
