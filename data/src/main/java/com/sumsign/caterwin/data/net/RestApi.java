package com.sumsign.caterwin.data.net;

import com.sumsign.caterwin.domain.entity.MessageEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApi {

    String URL_BASE = "https://api.caterwin.com/";
    String ACCEPT = "application/json";

    @POST("userregister")
    Observable<Response<UserResponse>> createUser(@Body UserLoginModel userWrapper);

    @POST("/users/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Body UserLoginModel userWrapper);

    @POST("userlogin")
    Observable<Response<UserResponse>> doLogin(@Body UserLoginModel userLoginModel);


}
