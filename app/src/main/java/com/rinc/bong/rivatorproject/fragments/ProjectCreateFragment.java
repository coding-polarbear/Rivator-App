package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.NoticeRecyclerAdapter;
import com.rinc.bong.rivatorproject.adapters.ProjectRecyclerAdapter;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectCreateFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_project_create ,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.project_recycler_create);
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NoticeRecyclerAdapter mNoticeRecyclerAdapter = new NoticeRecyclerAdapter(view.getContext(),5);
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);
    }

    public static NoticeReadFragment newInstance() {

        Bundle args = new Bundle();

        NoticeReadFragment fragment = new NoticeReadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
