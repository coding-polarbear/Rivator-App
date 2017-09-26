package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.controller.adapters.ContestRecyclerAdapter;

import java.util.List;

/**
 * Created by bong on 2017-08-05.
 */

public class ContestCreateFragment extends Fragment {
    private List<Contest> contestList;
    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default ,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
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