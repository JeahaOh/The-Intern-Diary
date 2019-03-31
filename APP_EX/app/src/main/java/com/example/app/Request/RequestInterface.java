package com.example.app.Request;

import android.graphics.Bitmap;

import com.example.app.Rst.Rater;
import com.example.app.Rst.Rst;
import com.example.app.Rvw.Rvw;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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


    //  Rvw POST : MultipartForm으로 rvw 정보와 사진을 저장함.
    @Headers( "Accept:application/json;charset=UTF-8" )
    @Multipart
    @POST("/yummy/rvw/uploadRvw")
    Call<ResponseBody> upload(
            @Part MultipartBody.Part phot,
            @Part("rst_no")    RequestBody rst_no,
            @Part("id")        RequestBody id,
            @Part("cont")      RequestBody cont,
            @Part("score")     RequestBody score
    );
}