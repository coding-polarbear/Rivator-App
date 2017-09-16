package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baehyeonbin on 2017. 9. 17..
 */

public interface CourseService {
    @GET("/courses")
    Call<CourseListGet> getCourseList(@Query("category") String categoryName, @Query("isOpen") boolean isOpen,
                                      @Query("sortBy") String sortBy, @Query("offset") int offset, @Query("limit") int limit);
}
