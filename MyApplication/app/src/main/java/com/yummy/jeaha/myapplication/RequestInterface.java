package com.yummy.jeaha.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("/vetproject_v2/vetJson.do")
    Call<List<AndroidVersion>> getJSON();
}
