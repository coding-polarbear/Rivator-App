package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.ContestManager;
import com.rinc.bong.rivatorproject.controller.activitys.ContestDetailActivity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by baehy on 2017. 9. 26..
 */

public class ContestManagerAdapter extends RecyclerView.Adapter<ContestManagerAdapter.ViewHolder> {
    private Context context = null;
    private View view = null;
    private List<ContestManager> contestManagerList;

    public ContestManagerAdapter(Context context, List<ContestManager> contestManagerList) {
        this.context = context;
        this.contestManagerList = contestManagerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
        return new ContestManagerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ContestManager contestManager = contestManagerList.get(position);
        holder.getTitle().setText(contestManager.getContest().getTitle());
//        holder.getCategory().setText(contestManager.getCategory());
        holder.getItemView().setOnClickListener(v -> {
            Intent intent = new Intent(context, ContestDetailActivity.class);
            intent.putExtra("contestKey", contestManagerList.get(position).getContestKey());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return contestManagerList.size();
    }
    @Getter
    @Setter
    public class ViewHolder extends RecyclerView.ViewHolder {
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
