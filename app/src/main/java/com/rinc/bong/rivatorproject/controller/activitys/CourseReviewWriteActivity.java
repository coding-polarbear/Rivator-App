package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.services.CourseReviewService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseReviewWriteActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView category;
    private TextView unitTime;
    private RatingBar ratingBar;
    private EditText content;

    private double score;
    private int courseKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_review_write);
        init();
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.title);
        category = (TextView) findViewById(R.id.category);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        content = (EditText) findViewById(R.id.content);
        courseKey = getIntent().getExtras().getInt("courseKey");
        ratingBar.setOnRatingBarChangeListener((ratingBar1, v, b) -> score = v);
    }

    private void loadData() {
        CourseReviewService courseReviewService = RetrofitUtil.retrofit.create(CourseReviewService.class);
        Call<Status> call = courseReviewService.putCourseReview(courseKey);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    ToastUtill.makeToast(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT);
                    finish();
                } else {
                    SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), "알 수 없는 오류가 발생하였습니다", Snackbar.LENGTH_SHORT);
            }
        });
    }

    public void submit(View view) {
    }
}
