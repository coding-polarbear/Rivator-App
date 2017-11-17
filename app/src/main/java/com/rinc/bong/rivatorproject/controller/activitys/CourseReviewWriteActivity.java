package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.SingleCourseGet;
import com.rinc.bong.rivatorproject.services.CourseReviewService;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CourseReviewWriteActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView category;
    private TextView unitTime;
    private RatingBar ratingBar;
    private EditText content;
    private de.hdodenhof.circleimageview.CircleImageView teacherProfileImage;
    private TextView teacherName;
    private TextView subject;

    private double score;
    private int courseKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_review_write);
        init();
        loadData();
        setCustomActionbar();
    }

    private void init() {
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.title);
        category = findViewById(R.id.category);
        ratingBar = findViewById(R.id.ratingBar);
        content = findViewById(R.id.content);
        teacherProfileImage = findViewById(R.id.teacherProfileImage);
        teacherName = findViewById(R.id.teacherName);
        subject = findViewById(R.id.subject);
        courseKey = getIntent().getExtras().getInt("courseKey");
        ratingBar.setOnRatingBarChangeListener((ratingBar1, v, b) -> score = v);
    }

    private void loadData() {
        CourseService courseService = RetrofitUtil.retrofit.create(CourseService.class);
        Call<SingleCourseGet> call = courseService.getCourse(courseKey);
        call.enqueue(new Callback<SingleCourseGet>() {
            @Override
            public void onResponse(Call<SingleCourseGet> call, Response<SingleCourseGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    Course course = response.body().getCourse();
                    title.setText(course.getTitle());
                    category.setText(course.getCategory());
                    Glide.with(getApplicationContext()).load("http://n0rr.kro.kr:7001/courses/"+courseKey+"/course-image.jpg").centerCrop().into(imageView);
                    Glide.with(getApplicationContext()).load("http://n0rr.kro.kr:7001/users/"+course.getUser().getUserId()+"/profile-image.jpg").centerCrop().into(teacherProfileImage);
                    subject.setText(course.getCategory());
                    teacherName.setText(course.getUser().getUserName());
                } else {
                    SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<SingleCourseGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(),"알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_SHORT );
            }
        });
    }

    public void submit(View view) {
        CourseReviewService courseReviewService = RetrofitUtil.getLoginRetrofit().create(CourseReviewService.class);
        CourseReview courseReview = new CourseReview();
        courseReview.setContent(content.getText().toString());
        courseReview.setScore(score);

        Call<Status> call = courseReviewService.putCourseReview(courseReview, courseKey);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    ToastUtill.makeToast(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT);
                    finish();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_SHORT);
            }
        });
    }

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = view.findViewById(R.id.title);
            textView.setText("강좌 후기 작성");

            //ImageButton 리스너 설정
            ImageButton imageButton = view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());

        });
    }
}
