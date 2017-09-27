package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewGet;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewListGet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by baehy on 2017. 9. 22..
 */

public interface CourseReviewService{
    @GET("/course-reviews/")
    Call<CourseReviewListGet> getCourseReview(@Query("limit") int limit, @Query("offset") int offset, @Query("courseKey") int courseKey);

    @GET("/course-reviews/{reviewKey}")
    Call<CourseReviewGet> getCourseReview(@Path("reviewKey") int reviewKey);

    @POST("/course-reviews/{courseKey}")
    Call<Status> putCourseReview(@Path("courseKey") int courseKey);
}
