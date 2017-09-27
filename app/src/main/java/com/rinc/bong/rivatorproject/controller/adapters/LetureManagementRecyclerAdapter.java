package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseManager;
import com.rinc.bong.rivatorproject.controller.activitys.CourseDetailActivity;
import com.rinc.bong.rivatorproject.controller.activitys.CourseReviewWriteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bong on 2017-08-05.
 */

public class LetureManagementRecyclerAdapter extends RecyclerView.Adapter<LetureManagementRecyclerAdapter.ViewHolder> {
    private List<CourseManager> courseManagerList = new ArrayList<>();
    private View view = null;
    private Context context = null;
    private int idx = 0;

    public LetureManagementRecyclerAdapter(Context context, List<CourseManager> courseManagerList) {
        this.context = context;
        this.courseManagerList = courseManagerList;
    }


    @Override
    public LetureManagementRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
        return new LetureManagementRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LetureManagementRecyclerAdapter.ViewHolder holder, int position) {
        CourseManager courseManager = courseManagerList.get(position);
        holder.title.setText(courseManager.getCourse().getTitle());
        holder.category.setText(courseManager.getCourse().getCategory());
        if(courseManager.getStatus() == -1) {
            holder.condition.setText(Html.fromHtml("<u>평가하기</u>"));
            holder.condition.setOnClickListener(v -> {
                Intent intent = new Intent(context, CourseReviewWriteActivity.class);
                intent.putExtra("courseKey", courseManager.getCourseKey());
                context.startActivity(intent);
            });
        } else if(courseManager.getStatus() == 0) holder.condition.setText("대기중");
        else holder.condition.setText("수강중");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra("courseKey", courseManager.getCourseKey());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return courseManagerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView category;
        private TextView condition;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            category = (TextView) itemView.findViewById(R.id.category);
            condition = (TextView) itemView.findViewById(R.id.condition);
        }
    }
}