package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.app.rst.RequestInterface;
import com.example.app.rst.Rst;
import com.example.app.rst.RstAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RstAdapter adapter;

    /**
     * 집         172.30.1.42
     * 코코스      169.254.29.121
     * 할리스      192.168.0.52
     */
    private String url = "192.168.0.52:8888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){

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

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl( "http://" + url );

        if(BuildConfig.DEBUG) {
            retrofitBuilder.client(client);
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder.build();

        //  << 여기 까지

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<Rst>> call = request.getJSON();
        call.enqueue(new Callback<List<Rst>>() {
            @Override
            public void onResponse(Call<List<Rst>> call, Response<List<Rst>> response) {
                List<Rst> data = response.body();
                adapter = new RstAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Rst>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}