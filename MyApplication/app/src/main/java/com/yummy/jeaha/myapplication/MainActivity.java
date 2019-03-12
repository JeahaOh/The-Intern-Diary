package com.yummy.jeaha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<AndroidVersion> data;
    private DataAdapter adapter;
    private String url = "http://192.168.1.33:8080";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //  onCreate : 앱을 생성함.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //  첫 화면에 activity_main 내용을 띄움.
        //  R : 앱이 생성될 때 만들어진 기본 클래스 layout = R에서 파생된 레이아웃 킅래스
        //  res/layout/activity_main.xml 파일의 내용을 불러옴.

        initViews();
        init();

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void loadJSON(){

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<AndroidVersion>> call = request.getJSON();
        call.enqueue(new Callback<List<AndroidVersion>>() {
                         @Override
                         public void onResponse(Call<List<AndroidVersion>> call, Response<List<AndroidVersion>> response) {
                             data = response.body();
                             adapter = new DataAdapter(data);
                             recyclerView.setAdapter(adapter);
                         }

                         @Override
                         public void onFailure(Call<List<AndroidVersion>> call, Throwable t) {
                             Log.d("Error",t.getMessage());
                         }
                     });

        /*{
            @Override
            public void onResponse(Call<List<AndroidVersion>> call, Response<J> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });*/
    }
}
