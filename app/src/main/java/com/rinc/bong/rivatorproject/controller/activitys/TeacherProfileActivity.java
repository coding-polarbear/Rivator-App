package com.rinc.bong.rivatorproject.controller.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.TeacherProfilePagerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.TeacherGet;
import com.rinc.bong.rivatorproject.retrofitBean.TeacherListGet;
import com.rinc.bong.rivatorproject.services.TeacherService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

/**
 * Created by bong on 2017-09-27.
 */

public class TeacherProfileActivity extends AppCompatActivity {
    private ImageButton backBtn = null;
    private TextView title = null;
    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    private ImageView teacherProfile = null;
    private TextView name = null;
    private TextView teacherSubject = null;

    private String userId = null;
    private User teacher = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        init();
        loadData();
        setCustomActionbar();
        setListener();
    }

    private void init() {
        tabLayout = findViewById(R.id.teacher_tab);
        viewPager = findViewById(R.id.teacher_viewpager);
        teacherProfile = findViewById(R.id.teacher_profile);
        name = findViewById(R.id.name);
        teacherSubject = findViewById(R.id.teacher_subject);
        userId = getIntent().getExtras().getString("userId");
    }

    private void loadData() {
        TeacherService teacherService = RetrofitUtil.retrofit.create(TeacherService.class);
        Call<TeacherGet> call = teacherService.loadTeacherWithUserId(userId);
        call.enqueue(new Callback<TeacherGet>() {
            @Override
            public void onResponse(Call<TeacherGet> call, Response<TeacherGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    teacher = response.body().getUser();
                    name.setText(teacher.getUserName());
                    teacherSubject.setText(teacher.getSubject());
                    Glide.with(getApplicationContext()).load("http://n0rr.iptime.org:7001/users/"+userId + "/profile-image.jpg").centerCrop().into(teacherProfile);
                    pageInit();
                } else {
                    Log.d("problem", result.getMessage());
                }
            }

            @Override
            public void onFailure(Call<TeacherGet> call, Throwable t) {

            }
        });
    }
    private void pageInit() {
        TeacherProfilePagerAdapter teacherProfileActivity = new TeacherProfilePagerAdapter(getSupportFragmentManager(), userId);
        viewPager.setAdapter(teacherProfileActivity);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setListener() {
        backBtn.setOnClickListener(view -> onBackPressed());
    }



    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {
            backBtn = view.findViewById(R.id.btnBack);
            title = view.findViewById(R.id.title);
            title.setText("강사 프로필");
        });

    }


}
