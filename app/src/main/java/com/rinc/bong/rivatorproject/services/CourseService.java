package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.ContestManagerListGet;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.retrofitBean.CourseManagerListGet;
import com.rinc.bong.rivatorproject.retrofitBean.SingleCourseGet;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by baehyeonbin on 2017. 9. 17..
 */

public interface CourseService {
    @GET("/courses")
    Call<CourseListGet> getCourseList(@Query("category") String categoryName, @Query("isOpen") boolean isOpen,
                                      @Query("sortBy") String sortBy, @Query("offset") int offset, @Query("limit") int limit);
    @GET("/courses/{courseKey}")
    Call<SingleCourseGet> getCourse(@Path("courseKey") int courseKey);

    @Multipart
    @POST("/courses")
    Call<Status> addCourse(@Part("data") Course course,  @Part MultipartBody.Part file);

    @POST("/course-managers/{courseKey}")
    Call<Status> submitCourse(@Path("courseKey") int courseKey);

    @GET("/course-managers")
    Call<CourseManagerListGet> getCourseManagerListWithStatus(@Query("offset") int offset, @Query("limit") int limit, @Query("userId") String userId, @Query("status") int status);

}
