package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Status;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by baehy on 2017. 9. 24..
 */

public interface ProjectService {
    @POST("/projects")
    @Multipart
    Call<Status> addProjectWithImage(@Part("data") Project project, @Part MultipartBody.Part file);
}
