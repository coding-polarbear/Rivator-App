package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;


public class DescriptionFragment extends Fragment {

    private String description = null;
    private View view;
    private TextView descriptionText;
    public DescriptionFragment() {
        // Required empty public constructor
    }

    public DescriptionFragment(String description) {
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_description, container, false);
        init();
        return view;
    }

    private void init() {
        descriptionText = view.findViewById(R.id.descriptionText);
            descriptionText.setText(description);
    }

}
