package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.beans.UserLogin;
import com.rinc.bong.rivatorproject.beans.UserRegister;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

public interface UserService {
    @Multipart
    @POST("/users")
    Call<UserRegister> register(@Part("data") User user, @Part MultipartBody.Part profileImage);

    @FormUrlEncoded
    @POST("/sign/login")
    Call<UserLogin> login(@Field("userId") String userId, @Field("userPw") String userPw);
}
