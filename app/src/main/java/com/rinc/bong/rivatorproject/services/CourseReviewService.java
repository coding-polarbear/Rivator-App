package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewGet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baehy on 2017. 9. 22..
 */

public interface CourseReviewService{
    @GET("/course-reviews/")
    Call<CourseReviewGet> getCourseReview(@Query("limit") int limit, @Query("offset") int offset, @Query("courseKey") int courseKey);
}
