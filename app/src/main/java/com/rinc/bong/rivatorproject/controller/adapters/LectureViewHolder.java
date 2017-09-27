package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.activitys.CourseDetailActivity;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

public class LectureViewHolder extends ViewHolder{
    private ImageView imageView;
    private TextView title;
    private TextView teacherName;
    private TextView unit;
    private int courseKey;
    private Context context;

    public LectureViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        teacherName = itemView.findViewById(R.id.teacherName);
        unit = itemView.findViewById(R.id.unit);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(TextView teacherName) {
        this.teacherName = teacherName;
    }

    public TextView getUnit() {
        return unit;
    }

    public void setUnit(TextView unit) {
        this.unit = unit;
    }

    public void setListener(int courseKey, Context context) {
        this.courseKey = courseKey;
        this.context = context;
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra("courseKey", courseKey);
            context.startActivity(intent);
        });
    }
}
