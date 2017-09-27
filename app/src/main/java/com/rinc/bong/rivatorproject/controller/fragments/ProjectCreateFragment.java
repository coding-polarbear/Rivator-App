package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectAddActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectListGet;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectCreateFragment extends Fragment {
    private List<Project> projectList = null;
    private User user = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_project,container ,false);
        init();
        loadProjectData();
        return view;
}

    private void init() {
        mRecyclerView = view.findViewById(R.id.recyclerview_default);
        fab = view.findViewById(R.id.floatingActionButton);
        user = User.last(User.class);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProjectAddActivity.class));
        });
    }

    private void loadProjectData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectListGet> call = projectService.getProjectListWithUserName(0,999, user.getUserId());
        call.enqueue(new Callback<ProjectListGet>() {
            @Override
            public void onResponse(Call<ProjectListGet> call, Response<ProjectListGet> response) {
                ProjectListGet projectListGet = response.body();
                if(projectListGet.getResult().getSuccess().equals("200")) {
                    projectList = projectListGet.getProjects();
                    recyclerInit();
                } else {
                    SnackBarUtill.makeSnackBar(view, projectListGet.getResult().getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<ProjectListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_LONG);
            }
        });
    }
    private void recyclerInit() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext(),projectList);
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
    }

    public static ProjectCreateFragment newInstance() {

        Bundle args = new Bundle();

        ProjectCreateFragment fragment = new ProjectCreateFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
