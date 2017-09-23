package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.controller.adapters.CourseReviewAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewGet;
import com.rinc.bong.rivatorproject.services.CourseReviewService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseReviewFragment extends android.support.v4.app.Fragment {
    private CourseReviewService courseReviewService;
    private List<CourseReview> courseReviews;
    private ListView listView;
    private int courseKey;
    private View view;

    public CourseReviewFragment(int courseKey) {
        this.courseKey = courseKey;
        Log.d("test", Integer.toString(courseKey));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_course_review, container, false);
        init();
        loadData();
        return view;
    }

    private void init() {
        courseReviewService = RetrofitUtil.retrofit.create(CourseReviewService.class);
        listView = (ListView) view.findViewById(R.id.listView);
    }

    private void loadData() {
        Call<CourseReviewGet> call = courseReviewService.getCourseReview(999, 0, courseKey);
        Log.d("courseKey",Integer.toString(courseKey));
        call.enqueue(new Callback<CourseReviewGet>() {
            @Override
            public void onResponse(Call<CourseReviewGet> call, Response<CourseReviewGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    courseReviews = response.body().getCourseReviewList();
                    Log.d("test", courseReviews.get(0).toString());
                    setListView();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<CourseReviewGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_LONG);
            }
        });
    }

    private void setListView() {
        CourseReviewAdapter courseReviewAdapter = new CourseReviewAdapter(getContext(),R.layout.item_default_cousre_review, courseReviews);
        listView.setAdapter(courseReviewAdapter);
    }
}
