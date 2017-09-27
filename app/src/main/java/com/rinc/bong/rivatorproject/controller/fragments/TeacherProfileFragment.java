package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.SearchRecyclerAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.TeacherRecyclerAdapter;


/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherProfileFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_default,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView =  view.findViewById(R.id.recyclerview_default);
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        TeacherRecyclerAdapter mNoticeRecyclerAdapter = new TeacherRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);
    }

    public static TeacherProfileFragment newInstance() {

        Bundle args = new Bundle();

        TeacherProfileFragment fragment = new TeacherProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
}