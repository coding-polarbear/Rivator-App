package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;

/**
 * Created by Bong on 2017-07-30.
 */

public class NoticeNotReadFragment extends Fragment {

    public NoticeNotReadFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_not_read,container,false);
        return view;
    }

    public static NoticeNotReadFragment newInstance() {

        Bundle args = new Bundle();

        NoticeNotReadFragment fragment = new NoticeNotReadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
