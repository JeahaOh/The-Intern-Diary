package com.example.app.Request;

import android.graphics.Bitmap;

import com.example.app.Rst.Rater;
import com.example.app.Rst.Rst;
import com.example.app.Rvw.Rvw;

import java.io.File;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
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

//    @FormUrlEncoded
//    @POST("/yummy/rvw/Element")
//    Call<ResponseBody> createRvw(
//            @Field(value="rst_no") int rst_no,
//            @Field("id") String id,
//            @Field("cont") String cont,
//            @Field("score") int score
//            //,@Part("phot") Bitmap phot
//    );

    @Headers({
            "Content-Type:application/x-www-form-urlencoded;charset=UTF-8"
    })
    @FormUrlEncoded
    @POST("/yummy/rvw/Element")
    Call<ResponseBody> postRvw(
            @Field("rst_no")    int rst_no,
            @Field("id")        String id,
            @Field("cont")      String cont,
            @Field("score")     int score
    );

    @Multipart
    @POST("/yummy/rvw/phot")
    Call<ResponseBody> postPhot( @Part MultipartBody.Part phot );

    interface FileUploadService {
        @Multipart
        @POST("upload")
        Call<ResponseBody> upload(
                @Part("description") RequestBody description,
                @Part MultipartBody.Part file
        );
    }

//@Headers("Content-Type: multipart/form-data")
}