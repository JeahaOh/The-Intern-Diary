package com.example.app.Request;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String addr = "172.30.1.39";
    private static final String url = "http://" + addr + ":8888";

    public static final String getBASE_URL() { return  url; }

    /*  retrofit을 그냥 사용 할 때 호출
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://" + url)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    */
    //  retrofit을 log와 함께 사용할때 호출 >>
    private static HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor()
                    .setLevel( HttpLoggingInterceptor.Level.BODY );

    private static OkHttpClient client =
            new OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor).build();

    private static Retrofit retrofit =
            new Retrofit
                    .Builder()
                    .baseUrl( url )
                    .client( client )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
    //  << 여기 까지

    //  Retrofit을 Singleton Pattern으로 생성
    public static Retrofit getClient() {
        return retrofit;
    }

    //  rst의 이미지를 저장하는 base url
    public static String getRstImgUrl() {
        return url + "/yummy/resources/images/rst/";
    }
    //  rvw의 이미지를 저장하는 base url
    public static String getRvwImgUrl() {
        return url + "/yummy/resources/images/rvw/";
    }

}
