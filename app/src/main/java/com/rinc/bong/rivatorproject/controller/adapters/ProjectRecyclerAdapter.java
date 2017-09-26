package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectDetailActivity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectRecyclerAdapter extends RecyclerView.Adapter<ProjectRecyclerAdapter.ViewHolder> {
    List<Project> projectList;
    private View view = null;
    private Context context = null;
    public ProjectRecyclerAdapter(Context context, List<Project> projectList) {
        this.context = context;
        this.projectList = projectList;
    }
    public ProjectRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ProjectRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
        return new ProjectRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectRecyclerAdapter.ViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.getTitle().setText(project.getTitle());
            holder.getCategory().setText(project.getCategory());
            holder.getItemView().setOnClickListener(v -> {
            Intent i = new Intent(context, ProjectDetailActivity.class);
            i.putExtra("projectKey",project.getProjectKey());
            context.startActivity(i);
        });
    }



    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return projectList.size();
    }

    @Getter
    @Setter
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView condition;
        private TextView category;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            condition = (TextView) itemView.findViewById(R.id.condition);
            category = (TextView) itemView.findViewById(R.id.category);
            this.itemView = itemView;
        }
    }
}
