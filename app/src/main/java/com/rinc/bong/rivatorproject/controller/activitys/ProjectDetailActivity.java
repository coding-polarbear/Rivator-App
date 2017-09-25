package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectGet;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectJoin;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectDetailActivity extends AppCompatActivity {
    private int projectKey;
    private Project project;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ProjectAdapter projectAdapter;
    private ImageView imageView;
    private TextView projectTitle;
    private TextView teamName;
    private TextView categoryName;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_information);
        init();
        setTabLayout();
        loadProjectData();
        setCustomActionbar();
    }

    public void init() {
        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        projectKey = getIntent().getExtras().getInt("projectKey");

        imageView = (ImageView) findViewById(R.id.imageView);
        projectTitle = (TextView) findViewById(R.id.projectTitle);
        teamName = (TextView) findViewById(R.id.teamName);
        categoryName = (TextView) findViewById(R.id.categoryName);
        user = User.last(User.class);
    }
    public void setTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setText("설명"));
        mTabLayout.addTab(mTabLayout.newTab().setText("팀원 목록"));
    }

    private void loadProjectData() {
        ProjectService projectService = RetrofitUtil.retrofit.create(ProjectService.class);
        Call<ProjectGet> call = projectService.getProject(projectKey);
        call.enqueue(new Callback<ProjectGet>() {
            @Override
            public void onResponse(Call<ProjectGet> call, Response<ProjectGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    project = response.body().getProject();
                    setViewPager();
                    Glide.with(getApplicationContext()).load("http://n0rr.iptime.org:7001/projects/"+project.getProjectKey()+"/project-image.jpg").centerCrop().into(imageView);
                    projectTitle.setText(project.getTitle());
                    categoryName.setText(project.getCategory());
                    teamName.setText(project.getTeamName());
                }
            }

            @Override
            public void onFailure(Call<ProjectGet> call, Throwable t) {

            }
        });
    }

    public void setViewPager() {
        projectAdapter = new ProjectAdapter(getSupportFragmentManager(),project.getDescription(), projectKey);
        mViewPager.setAdapter(projectAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /* custom ActionBar
   백그라운드 설정 및 뒤로가기 버튼 달린 커스텀 액션바
 */
    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("프로젝트 정보");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }

    public void join(View view) {
        ProjectJoin projectJoin = new ProjectJoin(user.getSubject());
        ProjectService projectService = RetrofitUtil.getLoginRetrofit().create(ProjectService.class);
        Call<Status> call = projectService.joinProject(projectJoin, projectKey);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Result result = response.body().getResult();
                Log.d("success", result.getSuccess());
                SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다!", Snackbar.LENGTH_SHORT);
            }
        });
    }
}
