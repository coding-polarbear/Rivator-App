package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.ContestGet;
import com.rinc.bong.rivatorproject.retrofitBean.ContestListGet;
import com.rinc.bong.rivatorproject.retrofitBean.ContestManagerListGet;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by baehyeonbin on 2017. 9. 26..
 */


public interface ContestService {
    @Multipart
    @POST("/contests")
    Call<Status> putContest(@Part("data") Contest contest, @Part MultipartBody.Part contestImage);

    @GET("/contests")
    Call<ContestListGet> getContestList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("/contests")
    Call<ContestListGet> getContestListWithUserId(@Query("limit") int limit, @Query("offset") int offset, @Query("userId") String userId);

    @GET("/contest-managers")
    Call<ContestManagerListGet>  getContestManagerList(@Query("limit") int limit, @Query("offset") int offset, @Query("userId") String userId);

    @GET("/contests/{contestKey}")
    Call<ContestGet> getContest(@Path("contestKey") int contestKey);

    @POST("/contest-managers/{contestKey}")
    Call<Status> submitContest(@Path("contestKey") int contestKey);
}
