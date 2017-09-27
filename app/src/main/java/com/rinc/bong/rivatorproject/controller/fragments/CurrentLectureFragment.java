package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.LectureAdapter;
import com.rinc.bong.rivatorproject.beans.CurrentCourse;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CurrentLectureFragment extends Fragment {
    RecyclerView lectureRecyclerView;
    private String subject;
    private CourseService courseService;
    private List<SimpleCourse> simpleCourseList;
    private Call<CourseListGet> call;
    public CurrentLectureFragment() {
        // Required empty public constructor
    }
    public CurrentLectureFragment(String subject) {
        this.subject = subject;
        User user = User.last(User.class);
        courseService = RetrofitUtil.retrofit.create(CourseService.class);
        switch (subject) {
            case "추천":
                call = courseService.getCourseList(user.getSubject(), true, "score", 0, 5);
                break;
            default:
                call = courseService.getCourseList(subject, true, "score",0,5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_lecture, container,false);
        lectureRecyclerView = view.findViewById(R.id.lectureRecyclerView);
        loadData();
        return view;
    }

    private void loadData() {
        call.enqueue(new Callback<CourseListGet>() {
            @Override
            public void onResponse(Call<CourseListGet> call, Response<CourseListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    simpleCourseList = response.body().getSimpleCourseList();
                    setRecyclerView(lectureRecyclerView);
                }
            }

            @Override
            public void onFailure(Call<CourseListGet> call, Throwable t) {

            }
        });
    }
    public void setRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        LectureAdapter adapter = new LectureAdapter(getActivity(),simpleCourseList);
       recyclerView.setAdapter(adapter);
    }
}
