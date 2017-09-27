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
import com.rinc.bong.rivatorproject.controller.activitys.ContestDetailActivity;
import com.rinc.bong.rivatorproject.retrofitBean.ContestListGet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by bong on 2017-08-05.
 */

public class ContestRecyclerAdapter extends RecyclerView.Adapter<ContestRecyclerAdapter.ViewHolder> {
    private List<Contest> contestList = null;
    private View view = null;
    private Context context = null;

    public ContestRecyclerAdapter(Context context, List<Contest> contestList) {
        this.context = context;
        this.contestList = contestList;
    }


    @Override
    public ContestRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_dafault_type2, null);
        return new ContestRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContestRecyclerAdapter.ViewHolder holder, int position) {
        Contest contest = contestList.get(position);
        holder.getTitle().setText(contest.getTitle());
        holder.getCategory().setText(contest.getCategory());
        long current = System.currentTimeMillis();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(formatter.parse(contest.getDateStart()).getTime() < current && current >= formatter.parse(contest.getDateEnd()).getTime()) {
                holder.getCondition().setText("진행중");
            } else {
                holder.getCondition().setText("종료");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.getItemView().setOnClickListener(v -> {
            Intent intent = new Intent(context, ContestDetailActivity.class);
            intent.putExtra("contestKey", contestList.get(position).getContestKey());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        //return super.getItemCount();
        return contestList.size();
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
