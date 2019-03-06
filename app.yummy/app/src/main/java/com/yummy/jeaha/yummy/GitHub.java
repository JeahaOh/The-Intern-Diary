package com.yummy.jeaha.yummy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHub {

    //  GET/POST/DELETE/PUT 메소드들을 인터페이스레 구현하여 사용 할 수 있음.
    @GET("/repos/{owner}/{repo}/contributors")

    // JSON Array를 리턴하므로 Lisg<>가 되었음.
    Call<List<Contributor>> contributors (
         //  param 값으로 들어가는 것들.
         @Path("owner") String owner,
         @Path("repo") String repo);
}
