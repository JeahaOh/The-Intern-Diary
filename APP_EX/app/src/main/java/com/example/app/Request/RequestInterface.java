package com.example.app.Request;

import android.graphics.Bitmap;

import com.example.app.Rst.Rater;
import com.example.app.Rst.Rst;
import com.example.app.Rvw.Rvw;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * REST 요청 Interface
 * Interface의 Annotation과 method parameter로 요청을 어떻게 할지 정함.
 */

public interface RequestInterface {

    @GET("/yummy/rst/rstList")
    Call<List<Rst>> getRstJSONList();

    //  GET으로 Rater 정보 받아오기
    @GET("/yummy/rater/getRatee")
    Call<Rater> getRate(@Query("rst_no") int rst_no );

    //  JSON 형식으로 POST 요청하기.
    @FormUrlEncoded
    @POST("/yummy/rvw/getList")
    Call<List<Rvw>> getRvwList( @Field("rst_no") int rst_no );

    @FormUrlEncoded
    @POST("/yummy/rvw/Element")
    Call<String> createRvw(
            @Field("rst_no") int rst_no,
            @Field("id") String id,
            @Field("cont") String cont,
            @Field("score") int score,
            @Field("phot") Bitmap phot    );

//    @POST("/yummy/rvw/Object")
//    Call<String> createRvw(
//            @Body Rvw rvw
//            ,@Field("phot") File phot);
}