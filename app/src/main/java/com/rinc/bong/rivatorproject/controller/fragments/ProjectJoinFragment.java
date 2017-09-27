package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.ProjectManager;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectAddActivity;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectDetailActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectManagerListGet;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.RecyclerClickListenerUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectJoinFragment extends Fragment {
    private List<Project> projectList = new ArrayList<>();
    private FloatingActionButton fab = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private User user = null;

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
        fab.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProjectAddActivity.class));
        });
        user = User.last(User.class);
    }

    private void loadProjectData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectManagerListGet> call = projectService.getProjectMangerList(0,999, user.getUserId());
        call.enqueue(new Callback<ProjectManagerListGet>() {
            @Override
            public void onResponse(Call<ProjectManagerListGet> call, Response<ProjectManagerListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    response.body().getProjectManagerList().stream().forEach(p -> projectList.add(p.getProject()));
                    recyclerInit();
                }
            }

            @Override
            public void onFailure(Call<ProjectManagerListGet> call, Throwable t) {

            }
        });
    }
    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext(),projectList);
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
    }

    public static ProjectJoinFragment newInstance() {

        Bundle args = new Bundle();

        ProjectJoinFragment fragment = new ProjectJoinFragment();
        fragment.setArguments(args);
        return fragment;
    }
}