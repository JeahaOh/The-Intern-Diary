package com.example.app;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    /**
     * 집         172.30.1.42
     * 코코스      169.254.29.121
     * 할리스      접속 할 때마다 ip가 바뀜.
     * 폰         172.20.10.2
     * 회사       192.168.1.251
     * 별다방      172.30.26.218
     */
    private static String addr = "172.30.26.218";
    private static String url = "http://" + addr + ":8888";
    private static Retrofit retrofit = null;

    //  Retrofit을 Singleton Pattern으로 생성
    public static Retrofit getClient() {
        if ( retrofit == null) {
            /*  retrofit을 그냥 사용 할 때 호출
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            */
            //  retrofit을 log와 함께 사용할때 호출 >>
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(  url );

            retrofitBuilder.client(client);

            retrofitBuilder.addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = retrofitBuilder.build();
            //  << 여기 까지
            return retrofit;
        }
        return retrofit;
    }


}
