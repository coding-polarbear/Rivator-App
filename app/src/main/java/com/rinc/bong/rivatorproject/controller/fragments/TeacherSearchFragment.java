package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.activitys.TeacherProfileActivity;
import com.rinc.bong.rivatorproject.controller.adapters.SearchRecyclerAdapter;
import com.rinc.bong.rivatorproject.utils.RecyclerClickListenerUtil;


/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherSearchFragment extends Fragment {

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
        mRecyclerView = view.findViewById(R.id.recyclerview_default);
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SearchRecyclerAdapter mNoticeRecyclerAdapter = new SearchRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);


    }

    public static TeacherSearchFragment newInstance() {

        Bundle args = new Bundle();

        TeacherSearchFragment fragment = new TeacherSearchFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
