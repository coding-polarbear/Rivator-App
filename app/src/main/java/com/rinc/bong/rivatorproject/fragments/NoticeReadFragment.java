package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by Bong on 2017-07-30.
 */

public class NoticeReadFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notice_read ,container ,false);
        init();
        return view;
    }

    private void init() {
    }

    public static NoticeReadFragment newInstance() {

        Bundle args = new Bundle();

        NoticeReadFragment fragment = new NoticeReadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
