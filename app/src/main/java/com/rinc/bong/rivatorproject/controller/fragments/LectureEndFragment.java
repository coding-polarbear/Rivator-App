package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseManager;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.LetureManagementRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.CourseManagerListGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bong on 2017-08-05.
 */

public class LectureEndFragment extends Fragment {
    private List<CourseManager> courseManagerList = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private User user = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_course,container ,false);
        init();
        loadCourseData();
        return view;
    }

    private void init() {
        mRecyclerView = view.findViewById(R.id.recyclerview_default);
        user = User.last(User.class);
    }

    private void loadCourseData() {
        CourseService courseService = RetrofitUtil.retrofit.create(CourseService.class);
        Call<CourseManagerListGet> call = courseService.getCourseManagerListWithStatus(0, 999, user.getUserId(), -1);
        call.enqueue(new Callback<CourseManagerListGet>() {
            @Override
            public void onResponse(Call<CourseManagerListGet> call, Response<CourseManagerListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    courseManagerList = response.body().getCourseManagerList();
                    Log.d("size", Integer.toString(courseManagerList.size()));
                    recyclerInit();
                }
            }

            @Override
            public void onFailure(Call<CourseManagerListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다!", Snackbar.LENGTH_SHORT);
            }
        });
    }

    private void recyclerInit() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        LetureManagementRecyclerAdapter mLetureRecyclerAdpater = new LetureManagementRecyclerAdapter(view.getContext(), courseManagerList);
        mRecyclerView.setAdapter(mLetureRecyclerAdpater);
}

    public static LectureEndFragment newInstance() {
        LectureEndFragment fragment = new LectureEndFragment();
        return fragment;
    }
}