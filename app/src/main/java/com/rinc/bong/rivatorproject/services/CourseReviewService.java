package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewGet;
import com.rinc.bong.rivatorproject.retrofitBean.CourseReviewListGet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @Multipart
    @POST("/course-reviews/{courseKey}")
    Call<Status> putCourseReview(@Part("data")CourseReview courseReview, @Path("courseKey") int courseKey);
}
