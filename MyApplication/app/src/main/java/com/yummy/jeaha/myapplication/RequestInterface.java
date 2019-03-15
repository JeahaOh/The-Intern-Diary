package com.yummy.jeaha.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/android/jsonandroid")
    Call<JSONResponse> getJSON();
}