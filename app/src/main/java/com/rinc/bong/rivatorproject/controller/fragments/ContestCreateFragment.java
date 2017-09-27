package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ContestAddActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ContestRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ContestListGet;
import com.rinc.bong.rivatorproject.services.ContestService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bong on 2017-08-05.
 */

public class ContestCreateFragment extends Fragment {
    private List<Contest> contestList = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private User user = null;
    private FloatingActionButton fab = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default ,container ,false);
        init();
        loadContestData();
        return view;
    }

    private void init() {
        mRecyclerView = view.findViewById(R.id.recyclerview_default);
        user = User.last(User.class);
        fab = view.findViewById(R.id.fab);
        fab.bringToFront();
        fab.setOnClickListener(v -> {
            Log.d("click", "clicked");
            getContext().startActivity(new Intent(getActivity(), ContestAddActivity.class));
        });
    }

    private void loadContestData() {
        ContestService contestService = RetrofitUtil.retrofit.create(ContestService.class);
        Call<ContestListGet> call = contestService.getContestListWithUserId(999,0, user.getUserId());
        call.enqueue(new Callback<ContestListGet>() {
            @Override
            public void onResponse(Call<ContestListGet> call, Response<ContestListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    contestList = response.body().getContestList();
                    recyclerInit();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ContestListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생했습니다!", Snackbar.LENGTH_SHORT);
            }
        });
    }
    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ContestRecyclerAdapter mContestRecyclerAdapter  = new ContestRecyclerAdapter(view.getContext(), contestList);
        mRecyclerView.setAdapter(mContestRecyclerAdapter);
    }

    public static ContestCreateFragment newInstance() {

        Bundle args = new Bundle();

        ContestCreateFragment fragment = new ContestCreateFragment();
        fragment.setArguments(args);
        return fragment;
    }
}