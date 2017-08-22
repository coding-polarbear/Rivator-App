package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by bong on 2017-08-05.
 */

public class ContestRecyclerAdapter extends RecyclerView.Adapter<ContestRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;

    public ContestRecyclerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ContestRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
        return new ContestRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContestRecyclerAdapter.ViewHolder holder, int position) {

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
