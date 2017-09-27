package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewGet;
import com.rinc.bong.rivatorproject.services.CourseReviewService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseReviewDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView aurthor;
    private TextView courseTitle;
    private TextView date;
    private TextView score;
    private TextView content;
    private int reviewKey;
    private CourseReview courseReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_review_detail);
        init();
        loadData();
        setCustomActionbar();
    }

    private void init() {
        title = (TextView) findViewById(R.id.title);
        aurthor = (TextView) findViewById(R.id.aurthor);
        courseTitle = (TextView) findViewById(R.id.courseTitle);
        date = (TextView) findViewById(R.id.date);
        score = (TextView) findViewById(R.id.score);
        content = (TextView) findViewById(R.id.content);
        reviewKey = getIntent().getExtras().getInt("reviewKey");
    }

    private void loadData(){
        CourseReviewService courseReviewService = RetrofitUtil.retrofit.create(CourseReviewService.class);
        Call<CourseReviewGet> call = courseReviewService.getCourseReview(reviewKey);
        call.enqueue(new Callback<CourseReviewGet>() {
            @Override
            public void onResponse(Call<CourseReviewGet> call, Response<CourseReviewGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    courseReview = response.body().getCourseReview();
                    title.setText(courseReview.getContent().substring(0,9)+"...");
                    aurthor.setText(courseReview.getUser().getUserName());
                    courseTitle.setText(courseReview.getCourse().getTitle());
                    date.setText(courseReview.getCreatedAt());
                    score.setText(Double.toString(courseReview.getScore()));
                    content.setText(courseReview.getContent());
                } else {
                    SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<CourseReviewGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), "알 수 없는 오류가 발생하였습니다", Snackbar.LENGTH_SHORT);
            }
        });
    }

    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("강좌 리뷰");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }
}