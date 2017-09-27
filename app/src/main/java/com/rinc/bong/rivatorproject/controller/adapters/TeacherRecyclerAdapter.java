package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.activitys.TeacherProfileActivity;

/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherRecyclerAdapter extends RecyclerView.Adapter<TeacherRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;

    public TeacherRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_teacher_profile, null);
        view.setOnClickListener(view1 -> context.startActivity(new Intent(context, TeacherProfileActivity.class)));
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
