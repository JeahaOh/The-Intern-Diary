package com.yummy.jeaha.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("rst/rstList")
    Call<JSONResponse> getJSON();
}
