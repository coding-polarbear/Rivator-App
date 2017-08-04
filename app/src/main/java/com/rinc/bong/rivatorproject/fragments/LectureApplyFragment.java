package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.LetureManagementRecyclerAdapter;

/**
 * Created by bong on 2017-08-05.
 */

public class LectureApplyFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;
    private final int PAGE_NUM = 2;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        LetureManagementRecyclerAdapter mLetureRecyclerAdpater = new LetureManagementRecyclerAdapter(view.getContext(), PAGE_NUM);
        mRecyclerView.setAdapter(mLetureRecyclerAdpater);
    }

    public static LectureApplyFragment newInstance() {

        Bundle args = new Bundle();

        LectureApplyFragment fragment = new LectureApplyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
