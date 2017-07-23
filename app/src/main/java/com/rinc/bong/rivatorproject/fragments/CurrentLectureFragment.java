package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.LectureAdapter;
import com.rinc.bong.rivatorproject.beans.LectureItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CurrentLectureFragment extends Fragment {
    RecyclerView lectureRecyclerView;
    public CurrentLectureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_lecture, container,false);
        lectureRecyclerView = (RecyclerView) view.findViewById(R.id.lectureRecyclerView);
        setRecyclerView(lectureRecyclerView);
        return view;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        ArrayList<LectureItem> myDataset = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myDataset.add(new LectureItem("웹프로그래밍 기초","김철수",124));
        myDataset.add(new LectureItem("웹프로그래밍 기초","김철수",124));
        myDataset.add(new LectureItem("웹프로그래밍 기초","김철수",124));
        myDataset.add(new LectureItem("웹프로그래밍 기초","김철수",124));

        LectureAdapter adapter = new LectureAdapter(getActivity(),myDataset);
       recyclerView.setAdapter(adapter);
    }
}
