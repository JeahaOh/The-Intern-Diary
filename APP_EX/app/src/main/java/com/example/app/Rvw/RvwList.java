package com.example.app.Rvw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RvwList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RvwAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_list);

        initViews();
    }

    private void initViews() {
        Bundle intent = getIntent().getExtras();
        final int rst_no = intent.getInt( "rst_no" );

        final TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( intent.getString("rst_name") );
        TextView rvw_cnt = findViewById( R.id.rvw_cnt);
        rvw_cnt.setText( intent.getInt("cnt") + "" );
        TextView avg  = findViewById( R.id.avg);
        avg.setText( intent.getFloat("avg") + "" );
        TextView best = findViewById( R.id.best);
        best.setText( intent.getInt("best") + "" );
        TextView good = findViewById( R.id.good);
        good.setText( intent.getInt("good") + "" );
        TextView soso = findViewById( R.id.soso);
        soso.setText( intent.getInt("soso") + "" );
        TextView bad = findViewById( R.id.bad);
        bad.setText( intent.getInt("bad") + "" );
        TextView worst = findViewById( R.id.worst);
        worst.setText( intent.getInt("worst") + "" );
        TextView grade = findViewById( R.id.grade);
        grade.setText( intent.getFloat("grade") + "" );

        //  MainActivity의 recyclerView를 activity_main.xml의 card_recycler_view와 연결
        recyclerView = (RecyclerView)findViewById(R.id.rvw_card_recycler);

        //  각 Item들이 recyclerView의 전체 size를 변경 하지 않음으로 fix함.
        recyclerView.setHasFixedSize(true);

        //  Layout은 뭔지 알겠는데, LayoutManager는 뭐하는 녀석인지 잘 모르겠음.
        //  어쨌든 이 녀석에게 App의 리소스를 제공함.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadJSON(rst_no);
    }

    private void loadJSON(int rst_no) {
        //  Retrofit을 Singleton Pattern으로 생성한 객체를 가져옴.
        Retrofit retrofit = RetrofitClient.getClient();

        //  Retrofit 클래스로 RequestInterface.class를 구현하여 생성함.
        RequestInterface request = retrofit.create(RequestInterface.class);

        //  request의 getRstJSONList()를 통하여 HTTP 요청을 서버에 보냄.
        //  Call : HTTP 요청을 보내고 응답을 받는 retrofit interface.
        Call<List<Rvw>> call = request.getRvwList(rst_no);

        call.enqueue( new Callback<List<Rvw>> () {

            @Override
            public void onResponse(Call<List<Rvw>> call, Response<List<Rvw>> response) {
                List<Rvw> data = response.body();

                adapter = new RvwAdapter( data );
                recyclerView.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<Rvw>> call, Throwable t) {

            }
        }) ;
    }
}
