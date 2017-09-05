package com.rinc.bong.rivatorproject.utils;

import android.support.annotation.NonNull;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

public class RetrofitUtil {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://n0rr.iptime.org:7001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final String MULTIPART_FORM_DATA = "multipart/form-data";

    public static MultipartBody.Part  createRequestBody(@NonNull File file) {

        RequestBody mFile = RequestBody.create(MediaType.parse("images/*"),file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("profileImage",file.getName(),mFile);
        return fileToUpload;
    }
    public static RequestBody createRequestBody(@NonNull String value) {

        return RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA),value);
    }
}
