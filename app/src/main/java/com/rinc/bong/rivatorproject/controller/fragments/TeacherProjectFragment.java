package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectListGet;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherProjectFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;
    private String userId = null;
    private List<Project> projectList;
    private RecyclerView.Adapter adapter;

    public TeacherProjectFragment(String userId) {
        this.userId = userId;
    }

    public TeacherProjectFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_default,container ,false);
        init();
        loadProjectData();
        return view;
    }

    private void init() {
        mRecyclerView =  view.findViewById(R.id.recyclerview_default);
    }

    private void loadProjectData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectListGet> call = projectService.getProjectListWithUserName(0,999,userId);
        call.enqueue(new Callback<ProjectListGet>() {
            @Override
            public void onResponse(Call<ProjectListGet> call, Response<ProjectListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    projectList = response.body().getProjects();
                    recyclerInit();
                }
            }

            @Override
            public void onFailure(Call<ProjectListGet> call, Throwable t) {

            }
        });
    }
    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext(),projectList);
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
    }

    public static TeacherProjectFragment newInstance(String userId) {
        TeacherProjectFragment fragment = new TeacherProjectFragment(userId);
        return fragment;
    }
}