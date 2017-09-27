package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleTeacherAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.retrofitBean.TeacherListGet;
import com.rinc.bong.rivatorproject.services.TeacherService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherFragment extends Fragment {
    private TextView moreText;
    private ListView listView;
    private View view;;
    private TextView subjectText;
    private SimpleTeacherAdapter adapter;
    private String subject;
    private List<User> teacherList = new ArrayList<>();
    public TeacherFragment() {
        // Required empty public constructor
    }

    public TeacherFragment(String subject) {
        this.subject = subject;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_teacher, container,false);
        moreText = (TextView) view.findViewById(R.id.moreText);
        moreText.setText(Html.fromHtml("<u>더보기<u>"));
        listView = (ListView) view.findViewById(R.id.teacherList);
        subjectText = (TextView) view.findViewById(R.id.subjectText);
        subjectText.setText(subject);
        loadTeacherData();
        return view;
    }

    private void loadTeacherData() {
        TeacherService teacherService = RetrofitUtil.retrofit.create(TeacherService.class);
        if(subject.equals("추천")) subject = User.last(User.class).getSubject();
        Call<TeacherListGet> call = teacherService.loadTeacherWithSubject(0,999,subject,true, "teacher");
        call.enqueue(new Callback<TeacherListGet>() {

            @Override
            public void onResponse(Call<TeacherListGet> call, Response<TeacherListGet> response) {
                if(response.body().getResult().getSuccess().equals("200")) {
                    teacherList = response.body().getUsers();
                    setListView();
                } else {
                    SnackBarUtill.makeSnackBar(view,response.body().getResult().getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<TeacherListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다!", Snackbar.LENGTH_LONG);
            }
        });
    }
    public void setListView() {
        adapter = new SimpleTeacherAdapter(getActivity(), R.layout.item_default_person_list, teacherList);
        Log.d(subject + " count",Integer.toString(adapter.getCount()));
        listView.setAdapter(adapter);
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    }

}
