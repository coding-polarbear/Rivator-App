package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.controller.adapters.ContestRecyclerAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ContestListGet;
import com.rinc.bong.rivatorproject.services.ContestService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContestListFragment extends Fragment {
    private View view = null;
    private RecyclerView recyclerView = null;
    private List<Contest> contestList = null;
    public ContestListFragment() {
        // Required empty public constructor
    }

    public static ContestListFragment newInstance() {
        ContestListFragment fragment = new ContestListFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_management_default, container, false);
        init();
        loadContestData();
        return view;
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
    }

    private void loadContestData() {
        ContestService contestService = RetrofitUtil.retrofit.create(ContestService.class);
        Call<ContestListGet> call = contestService.getContestList(999, 0);
        call.enqueue(new Callback<ContestListGet>() {
            @Override
            public void onResponse(Call<ContestListGet> call, Response<ContestListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    contestList = response.body().getContestList();
                    recyclerInit();
                }
            }

            @Override
            public void onFailure(Call<ContestListGet> call, Throwable t) {

            }
        });
    }
    private void recyclerInit() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ContestRecyclerAdapter contestRecyclerAdapter = new ContestRecyclerAdapter(getContext(), contestList);
        recyclerView.setAdapter(contestRecyclerAdapter);
    }
}
