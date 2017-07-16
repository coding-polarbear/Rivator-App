package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;


public class HomeFragment extends Fragment {
    private TextView moreText;
    private ListView listView;
    public HomeFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, null);
        moreText = (TextView) view.findViewById(R.id.moreText);
        moreText.setText(Html.fromHtml("<u>더보기<u>"));
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
