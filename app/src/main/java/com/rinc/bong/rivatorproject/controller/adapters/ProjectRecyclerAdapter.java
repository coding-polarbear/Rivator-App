package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectRecyclerAdapter extends RecyclerView.Adapter<ProjectRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;
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

    }



    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
