package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectAddActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectCreateFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_project,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProjectAddActivity.class));
        });
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
    }

    public static ProjectCreateFragment newInstance() {

        Bundle args = new Bundle();

        ProjectCreateFragment fragment = new ProjectCreateFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
