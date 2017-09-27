package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.retrofitBean.TeacherListGet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baehy on 2017. 9. 24..
 */

public interface TeacherService {
    @GET("/users")
    Call<TeacherListGet> loadTeacherWithSubject(@Query("offset") int offset, @Query("limit") int limit, @Query("subject") String subject, @Query("score") boolean isSort, @Query("userType") String userType);
}
