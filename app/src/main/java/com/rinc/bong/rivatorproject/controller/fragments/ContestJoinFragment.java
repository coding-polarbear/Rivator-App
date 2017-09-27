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
import com.rinc.bong.rivatorproject.beans.ContestManager;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ContestAddActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ContestManagerAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ContestManagerListGet;
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

public class ContestJoinFragment extends Fragment {
    private List<ContestManager> contestManagerList = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private User user = null;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default,container ,false);
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
        Call<ContestManagerListGet> call = contestService.getContestManagerList(999,0, user.getUserId());
        call.enqueue(new Callback<ContestManagerListGet>() {
            @Override
            public void onResponse(Call<ContestManagerListGet> call, Response<ContestManagerListGet> response) {
                Result result  = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    contestManagerList = response.body().getContestManagerList();
                    recyclerInit();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ContestManagerListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생했습니다!", Snackbar.LENGTH_SHORT);
            }
        });
    }
    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ContestManagerAdapter adapter = new ContestManagerAdapter(getContext(), contestManagerList);
        mRecyclerView.setAdapter(adapter);
    }

    public static ContestJoinFragment newInstance() {

        Bundle args = new Bundle();

        ContestJoinFragment fragment = new ContestJoinFragment();
        fragment.setArguments(args);
        return fragment;
    }
}