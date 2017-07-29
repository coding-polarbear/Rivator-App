package com.rinc.bong.rivatorproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.activitys.NoticeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    private View view = null;

    private Button notice_btn;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        init();
        setListener();
        return view;
    }

    private void init() {
        notice_btn = (Button)view.findViewById(R.id.profile_notice_btn);
    }

    private void setListener() {
        notice_btn.setOnClickListener(view -> {
           startActivity(new Intent(view.getContext(), NoticeActivity.class));
        });
    }


}
