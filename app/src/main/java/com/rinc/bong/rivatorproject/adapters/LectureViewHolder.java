package com.rinc.bong.rivatorproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

public class LectureViewHolder extends ViewHolder{
    private ImageView imageView;
    private TextView title;
    private TextView teacherName;
    private TextView unit;

    public LectureViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        title = (TextView) itemView.findViewById(R.id.title);
        teacherName = (TextView)itemView.findViewById(R.id.teacherName);
        unit = (TextView) itemView.findViewById(R.id.unit);
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
}
