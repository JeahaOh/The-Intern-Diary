package com.example.app.Request;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //  ip주소
    private static final String addr = "192.168.1.251";
    //  URL
    private static final String url = "http://" + addr + ":8888";

    /*  retrofit을 그냥 사용 할 때 호출
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://" + url)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    */
    //  retrofit을 log와 함께 사용할때 호출 >>
    private static final HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor()
                    .setLevel( HttpLoggingInterceptor.Level.BODY );

    private static final OkHttpClient client =
            new OkHttpClient
                    .Builder()
                    .addInterceptor( interceptor )
                    .build();

    private static final Retrofit retrofit =
            new Retrofit
                    .Builder()
                    .baseUrl( url )
                    .client( client )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
    //  << 여기 까지

    //  Retrofit을 Singleton Pattern으로 호출
    public static Retrofit getClient() {
        return retrofit;
    }

    //  rst의 이미지를 불러 올 수 있는 url
    public static String getRstImgUrl() {
        return url + "/yummy/resources/images/rst/";
    }
    //  rvw의 이미지를 불러 올 수 있는 url
    public static String getRvwImgUrl() {
        return url + "/yummy/resources/images/rvw/";
    }

}
