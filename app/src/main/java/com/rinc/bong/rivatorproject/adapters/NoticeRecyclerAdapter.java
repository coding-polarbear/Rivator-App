package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bong on 2017-07-30.
 */

public class NoticeRecyclerAdapter extends RecyclerView.Adapter<NoticeRecyclerAdapter.ViewHolder> {

    private View view = null;
    private Context context = null;
    public NoticeRecyclerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, null);
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
