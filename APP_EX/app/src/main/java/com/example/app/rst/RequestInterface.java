package com.example.app.rst;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * REST 요청 Interface
 * Interface의 Annotation과 method parameter로 요청을 어떻게 할지 정함.
 */

public interface RequestInterface {

    @GET("/yummy/rst/rstList")
    Call<List<Rst>> getRstJSONList();

    //  get으로 Rater 정보 받아오기는 됨.
    @GET("/yummy/rater/getRatee")
    Call<Rater> getRate( @Query("rst_no") int rst_no );

}