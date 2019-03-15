package com.example.app;

import com.example.app.rst.Rst;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * REST 요청 Interface
 * @GET
 * @POST
 */

public interface RequestInterface {

    @GET("/android/jsonandroid")
    Call<JSONResponse> getJSON();

    @GET("/rst/rstList")
    Call<Rst> getList();
}