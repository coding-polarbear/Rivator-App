package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.ProjectManager;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleStudentAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleStudent;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectManagerListGet;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeamMemberFragment extends Fragment {
    private List<ProjectManager> projectManagerList;
    private ListView listView = null;
    private View view = null;
    private int projectKey;
    private SimpleStudentAdapter adapter;
    public TeamMemberFragment(int projectKey) {
        // Required empty public constructor
        this.projectKey = projectKey;
        Log.d("projectKey", Integer.toString(projectKey));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_team_member, container, false);
        init();
        loadProjectManagerData();
        return view;
    }

    private void init() {
        listView = view.findViewById(R.id.listView);
    }

    private void loadProjectManagerData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectManagerListGet> call = projectService.getProjectMangerListWithProjectKey(0, 999, projectKey);
        call.enqueue(new Callback<ProjectManagerListGet>() {
            @Override
            public void onResponse(Call<ProjectManagerListGet> call, Response<ProjectManagerListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    projectManagerList = response.body().getProjectManagerList();
                    setListView();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ProjectManagerListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다 잠시 후 다시 시도해주세요.", Snackbar.LENGTH_SHORT);
            }
        });
    }

    private void setListView() {

        //리스트뷰의 아이템을 설정할 array adapter 생성
        adapter = new SimpleStudentAdapter(getActivity(),R.layout.item_default_person_list, projectManagerList);
        listView.setAdapter(adapter);

        //리스트뷰에 데이터가 추가된 것을 알림
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    }


}
