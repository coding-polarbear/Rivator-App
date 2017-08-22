package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.NoticeRecyclerAdapter;

/**
 * Created by Bong on 2017-07-30.
 */

public class NoticeNotReadFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    public NoticeNotReadFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NoticeRecyclerAdapter mNoticeRecyclerAdapter = new NoticeRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
    }

    public static NoticeNotReadFragment newInstance() {

        Bundle args = new Bundle();

        NoticeNotReadFragment fragment = new NoticeNotReadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
