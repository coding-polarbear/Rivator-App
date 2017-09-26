package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.ContesListGet;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by baehyeonbin on 2017. 9. 26..
 */

public interface ContestService {
    @Multipart
    @POST("/contests")
    Call<Status> putContest(@Part("data") Contest contest, @Part MultipartBody.Part contestImage);

    @GET("/contests")
    Call<ContesListGet> getContestList(@Query("limit") int limit, @Query("offset") int offset);
}
