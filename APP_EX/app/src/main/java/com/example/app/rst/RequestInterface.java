package com.example.app.rst;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * REST 요청 Interface
 * @GET
 * @POST
 */

public interface RequestInterface {

    @GET("/yummy/rst/rstList")
    Call<RstResponse> getJSON();

//    @GET("/rst/rstList")
//    Call<Rst> getList();
}