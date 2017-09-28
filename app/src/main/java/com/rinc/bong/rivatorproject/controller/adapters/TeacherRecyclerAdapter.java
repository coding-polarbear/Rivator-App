package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.controller.activitys.CourseDetailActivity;
import com.rinc.bong.rivatorproject.controller.activitys.TeacherProfileActivity;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherRecyclerAdapter extends RecyclerView.Adapter<TeacherRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;
    private List<Course> courseList;
    public TeacherRecyclerAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_teacher_profile, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course item = courseList.get(position);
        holder.title.setText(item.getTitle());
        holder.subject.setText(item.getCategory());
        holder.teacherName.setText(item.getUser().getUserName() + " ・ 총" + item.getUnit() + "시간");
        holder.price.setText(new DecimalFormat("#,###,###").format(item.getPrice()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra("courseKey", item.getCourseKey());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView subject;
        private TextView teacherName;
        private TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.teacher_subject);
            title = itemView.findViewById(R.id.teacher_title);
            teacherName = itemView.findViewById(R.id.teacher_category);
            price = itemView.findViewById(R.id.teacher_price);
        }
    }
}
