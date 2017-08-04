package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by bong on 2017-08-05.
 */

public class LetureManagementRecyclerAdapter extends RecyclerView.Adapter<LetureManagementRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;
    private int idx = 0;

    public LetureManagementRecyclerAdapter(Context context, int idx) {
        this.context = context;
        this.idx = idx;
    }


    @Override
    public LetureManagementRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (idx){
            case 1:
                view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_default_type_menu, null);
                return new LetureManagementRecyclerAdapter.ViewHolder(view);
            case 2:
                view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
                return new LetureManagementRecyclerAdapter.ViewHolder(view);
            case 3:
                view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_default_type3, null);
                return new LetureManagementRecyclerAdapter.ViewHolder(view);
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(LetureManagementRecyclerAdapter.ViewHolder holder, int position) {

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