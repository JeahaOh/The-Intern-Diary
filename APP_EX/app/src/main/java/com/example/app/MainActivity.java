package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.app.rst.RequestInterface;
import com.example.app.rst.Rst;
import com.example.app.rst.RstAdapter;

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
     * 할리스      접속 할 때마다 ip가 바뀜.
     * 폰         172.20.10.2
     * 회사       192.168.1.251
     * 별다방      172.30.26.218
     */
    private String addr = "172.30.26.218";
    private String url = "http://" + addr + ":8888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 이 액티비티의 사용자 인터페이스 레이아웃을 설정한다.
        // 레이아웃 파일은 프로젝트 res/layout/main_activity.xml 파일로 정의됨.
        setContentView(R.layout.activity_main);

        initViews();
    }

    //  View의 초기화
    private void initViews(){
        //  MainActivity의 recyclerView를 activity_main.xml의 card_recycler_view와 연결
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);

        //  각 Item들이 recyclerView의 전체 size를 변경 하지 않음으로 fix함.
        recyclerView.setHasFixedSize(true);

        //  Layout은 뭔지 알겠는데, LayoutManager는 뭐하는 녀석인지 잘 모르겠음.
        //  어쨌든 이 녀석에게 App의 리소스를 제공함.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadJSON();
    }

    //
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
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(  url );
        retrofitBuilder.client(client);
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.build();
        //  << 여기 까지

        //  Retrofit 클래스로 RequestInterface.class를 구현하여 생성함.
        RequestInterface request = retrofit.create(RequestInterface.class);

        //  request의 getRstJSONList()를 통하여 HTTP 요청을 서버에 보냄.
        //  Call : HTTP 요청을 보내고 응답을 받는 retrofit interface.
        Call<List<Rst>> call = request.getRstJSONList();

        call.enqueue( new Callback<List<Rst>>() {
            //  요청이 성공하고 응답이 수신되면 onResponse() callback Method 가 실행되고, 실패하면 onFailure가 실행됨.

            @Override
            public void onResponse( Call<List<Rst>> call, Response<List<Rst>> response ) {

                //  HTTP response을 List<Rst> 형태로 받음.
                List<Rst> data = response.body();
                //  응답 받은 data를 담아서 Adapter 객체 생성
                adapter = new RstAdapter(data);
                //  생성한 Adapter를 recyclerView의 adapter로 set.
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure( Call<List<Rst>> call, Throwable t ) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}