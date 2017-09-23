package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectAddActivity;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectDetailActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectRecyclerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectListGet;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.RecyclerClickListenerUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProjectListFragment extends Fragment {
    private List<Project> projectList;
    private FloatingActionButton fab = null;
    private View view = null;
    private RecyclerView mRecyclerView = null;
    private User user = null;

    public ProjectListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_management_project, container, false);
        init();
        loadProjectData();
        return view;
    }

    public static ProjectListFragment newInstance() {
        ProjectListFragment fragment = new ProjectListFragment();
        return fragment;
    }

    private void init() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_default);
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProjectAddActivity.class));
        });
        user = User.last(User.class);
    }

    private void loadProjectData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectListGet> call = projectService.getProjectList(0,999);
        call.enqueue(new Callback<ProjectListGet>() {
            @Override
            public void onResponse(Call<ProjectListGet> call, Response<ProjectListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    projectList = response.body().getProjects();
                    Log.d("test2",projectList.get(0).toString());
                    recyclerInit();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<ProjectListGet> call, Throwable t) {
                Log.d("log",t.getMessage());
            }
        });
    }
    private void recyclerInit() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProjectRecyclerAdapter mProjectRecyclerAdapter  = new ProjectRecyclerAdapter(view.getContext(),projectList);
        mRecyclerView.setAdapter(mProjectRecyclerAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerClickListenerUtil(getActivity(),mRecyclerView, new RecyclerClickListenerUtil.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getActivity(), ProjectDetailActivity.class);
                startActivity(i);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

}
