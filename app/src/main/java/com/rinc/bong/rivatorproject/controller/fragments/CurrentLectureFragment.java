package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.LectureAdapter;
import com.rinc.bong.rivatorproject.beans.CurrentCourse;

import java.util.ArrayList;


public class CurrentLectureFragment extends Fragment {
    RecyclerView lectureRecyclerView;
    private String subject;
    public CurrentLectureFragment() {
        // Required empty public constructor
    }
    public CurrentLectureFragment(String subject) {

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
        ArrayList<CurrentCourse> myDataset = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myDataset.add(new CurrentCourse("웹프로그래밍 기초","김철수",124));
        myDataset.add(new CurrentCourse("웹프로그래밍 기초","김철수",124));
        myDataset.add(new CurrentCourse("웹프로그래밍 기초","김철수",124));
        myDataset.add(new CurrentCourse("웹프로그래밍 기초","김철수",124));

        LectureAdapter adapter = new LectureAdapter(getActivity(),myDataset);
       recyclerView.setAdapter(adapter);
    }
}
