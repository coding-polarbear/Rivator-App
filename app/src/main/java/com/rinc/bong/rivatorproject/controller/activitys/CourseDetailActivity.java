package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.CourseAdapter;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.retrofitBean.SingleCourseGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CourseAdapter courseAdapter;
    private CourseService courseService;
    private View view;
    private TextView courseTitle;
    private TextView category;
    private TextView unitTime;
    private TextView score;
    private TextView price;
    private ImageView imageView;
    private de.hdodenhof.circleimageview.CircleImageView teacherProfileImageView;
    private TextView teacherName;
    private TextView subject;
    private Button submit;

    private String description;
    private Course course;
    private int courseKey;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        init();
        setTabLayout();
        loadData();
        setCustomActionbar();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        courseService = RetrofitUtil.retrofit.create(CourseService.class);
        courseKey = getIntent().getExtras().getInt("courseKey");
        view = getWindow().getDecorView().getRootView();
        courseTitle = (TextView) findViewById(R.id.courseTitle);
        category = (TextView) findViewById(R.id.category);
        unitTime = (TextView) findViewById(R.id.item_course_unitTime);
        score = (TextView) findViewById(R.id.score);
        imageView = (ImageView) findViewById(R.id.imageView);
        teacherProfileImageView = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.teacherProfileImage);
        teacherName = (TextView) findViewById(R.id.teacherName);
        subject = (TextView) findViewById(R.id.subject);
        price = (TextView) findViewById(R.id.price);
        submit = (Button) findViewById(R.id.submit);
        User user = User.last(User.class);
        if(user.getUserType().equals("teacher"))
            submit.setEnabled(false);
    }

    public void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("설명"));
        tabLayout.addTab(tabLayout.newTab().setText("강좌 후기"));
    }
    private void loadData() {
        Call<SingleCourseGet> call = courseService.getCourse(courseKey);
        call.enqueue(new Callback<SingleCourseGet>() {
            @Override
            public void onResponse(Call<SingleCourseGet> call, Response<SingleCourseGet> response) {
                course = response.body().getCourse();
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    courseTitle.setText(course.getTitle());
                    category.setText(course.getCategory());
                    unitTime.setText(course.getUnit() + "시간");
                    score.setText(Double.toString(course.getScore()));
                    Log.d("scoreTest",score.getText().toString());
                    subject.setText(course.getCategory());
                    description = course.getCurriculum();
                    price.setText(new DecimalFormat("#,###,###").format(course.getPrice()));
                    teacherName.setText(course.getUser().getUserName());
                    Glide.with(CourseDetailActivity.this).load("http://n0rr.iptime.org:7001/users/" + course.getUser().getUserId() + "/profile-img.jpg").into(teacherProfileImageView);
                    Glide.with(CourseDetailActivity.this).load("http://n0rr.iptime.org:7001/courses/" + course.getCourseKey() + "/course-image.jpg").centerCrop().into(imageView);
                    setViewPager();
                } else {
                    SnackBarUtill.makeSnackBar(view,result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<SingleCourseGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_LONG);
            }
        });
    }

    public void setViewPager() {
        courseAdapter = new CourseAdapter(getSupportFragmentManager(), description, courseKey);
        viewPager.setAdapter(courseAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
            textView.setText("강좌 정보");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }
}
