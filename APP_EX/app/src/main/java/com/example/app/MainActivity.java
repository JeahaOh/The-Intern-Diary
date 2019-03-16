package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.app.rst.RequestInterface;
import com.example.app.rst.Rst;
import com.example.app.rst.RstAdapter;
import com.example.app.rst.RstResponse;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Rst> data;
    private RstAdapter adapter;

    /**
     * 집         172.30.1.42
     * 코코스      169.254.29.121
     */
    private String url = "172.30.1.42:8888";

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

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl( "http://" + url );

        if(BuildConfig.DEBUG) {
            retrofitBuilder.client(client);
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder.build();

        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        */

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<RstResponse> call = request.getJSON();
        call.enqueue(new Callback<RstResponse>() {
            @Override
            public void onResponse(Call<RstResponse> call, Response<RstResponse> response) {
                RstResponse rstResponse = response.body();


                data = new ArrayList<>( Arrays.asList( rstResponse.getRsts() ) );
                adapter = new RstAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RstResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}