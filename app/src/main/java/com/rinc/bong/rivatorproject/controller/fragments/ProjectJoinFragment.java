package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectInformationActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.utils.RecyclerClickListenerUtil;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectJoinFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerClickListenerUtil(getActivity(),mRecyclerView, new RecyclerClickListenerUtil.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getActivity(), ProjectInformationActivity.class);
                startActivity(i);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    public static ProjectJoinFragment newInstance() {

        Bundle args = new Bundle();

        ProjectJoinFragment fragment = new ProjectJoinFragment();
        fragment.setArguments(args);
        return fragment;
    }
}