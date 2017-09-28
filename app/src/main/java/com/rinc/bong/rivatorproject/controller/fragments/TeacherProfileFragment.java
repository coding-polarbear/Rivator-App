package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.controller.adapters.SearchRecyclerAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.TeacherRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherProfileFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;
    private String userId = null;
    private List<Course> courseList;

    private RecyclerView.Adapter adapter;
    public TeacherProfileFragment(String userId) {
        this.userId = userId;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_default,container ,false);
        init();
        loadCourseData();
        return view;
    }

    private void init() {
        mRecyclerView =  view.findViewById(R.id.recyclerview_default);
    }

    private void loadCourseData() {
        CourseService courseService = RetrofitUtil.retrofit.create(CourseService.class);
        Call<CourseListGet> call = courseService.getCourseListWithUserId(0,999,true, userId);
        call.enqueue(new Callback<CourseListGet>() {
            @Override
            public void onResponse(Call<CourseListGet> call, Response<CourseListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    courseList = response.body().getSimpleCourseList();
                    recyclerInit();

                }
            }

            @Override
            public void onFailure(Call<CourseListGet> call, Throwable t) {

            }
        });
    }
    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TeacherRecyclerAdapter(view.getContext(),courseList);
        TeacherRecyclerAdapter mNoticeRecyclerAdapter = new TeacherRecyclerAdapter(view.getContext(), courseList);
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);
        mNoticeRecyclerAdapter.notifyDataSetChanged();
    }

    public static TeacherProfileFragment newInstance(String userId) {
        TeacherProfileFragment fragment = new TeacherProfileFragment(userId);
        return fragment;
    }
}