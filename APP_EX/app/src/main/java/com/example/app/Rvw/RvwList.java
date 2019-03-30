package com.example.app.Rvw;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;
import com.example.app.Rst.Rater;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RvwList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RvwAdapter adapter;
    private int rst_no;
    private String rst_nm;

    private Rater rate;

    //  resume시 POST가 true이면 (rvwPost Activity를 하고 왔다면.) 새로고침함.
    private static Boolean POST = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_list);

        rate = (Rater) getIntent().getSerializableExtra("rate");

        initViews();
    }

    private void initViews() {
        Bundle intent = getIntent().getExtras();
        rst_no = intent.getInt( "rst_no" );
        rst_nm = intent.getString( "rst_name" );

        final TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( rst_nm );

        TextView rvw_cnt = findViewById( R.id.rvw_cnt);
        rvw_cnt.setText( rate.getCnt() + "" );
        TextView avg  = findViewById( R.id.avg);
        avg.setText( rate.getAvg() + "" );
        TextView best = findViewById( R.id.best);
        best.setText( rate.getBest() + "" );
        TextView good = findViewById( R.id.good);
        good.setText( rate.getGood() + "" );
        TextView soso = findViewById( R.id.soso);
        soso.setText( rate.getSoso() + "" );
        TextView bad = findViewById( R.id.bad);
        bad.setText( rate.getBad() + "" );
        TextView worst = findViewById( R.id.worst);
        worst.setText( rate.getWorst() + "" );
        TextView grade = findViewById( R.id.grade);
        grade.setText( rate.getGrade() + "" );

        /*  후기 작성 클릭시 후기 작성 화면으로 넘기기 위한 click 버튼  */
        TextView createRvw =  (TextView) findViewById(R.id.rvw_create_button);
        createRvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  인텐트 선언
                Intent createRvw = new Intent(v.getContext(), RvwPOST.class);

                createRvw.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //  createRvw 인텐트에게 넘겨줄 데이터
                createRvw.putExtra("rst_no", rst_no );
                createRvw.putExtra( "rst_nm", rst_nm );
                POST = true;
                startActivity(createRvw);
            }
        });
        /*  후기 작성 클릭시 후기 작성 화면으로 넘기기 위한 click 버튼  */


        recyclerView = (RecyclerView)findViewById(R.id.rvw_card_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        /* 당겨서 새로고침을 하기 위한 SwipeRefreshLayout 객체 */
        final SwipeRefreshLayout swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadJSON(rst_no);
                swipeRefresh.setRefreshing(false);
            }
        });
        /* 당겨서 새로고침을 하기 위한 SwipeRefreshLayout 객체 */


        loadJSON(rst_no);
    }

    //  페이지로 돌아 올 시 할 행동.
    public void onResume(){
        super.onResume();
        //  RvwPost 후 페이지로 돌아 올 시 RVW List를 refresh함.
        if(POST) {
            loadJSON(rst_no);
            POST = false;
        }
    }

    private void loadJSON(int rst_no) {
        RequestInterface request = RetrofitClient.getClient().create(RequestInterface.class);
        Call<List<Rvw>> call = request.getRvwList(rst_no);
        call.enqueue( new Callback<List<Rvw>> () {

            @Override
            public void onResponse(Call<List<Rvw>> call, Response<List<Rvw>> response) {
                //  로드 전에 뷰 레이아웃을 모두 지워준다.
                recyclerView.removeAllViewsInLayout();
                recyclerView.getRecycledViewPool().clear();
                //  서버의 응답으로 Rvw List를 받아온다.
                List<Rvw> data = response.body();

                //  adapter에 Rvw List를 준다.
                adapter = new RvwAdapter( data );
                adapter.setRst_nm(rst_nm);
                //  recyclerView에 adapter를 넣어 실행. 화면에 보여준다.
                recyclerView.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<Rvw>> call, Throwable t) {

            }
        }) ;
    }
}
