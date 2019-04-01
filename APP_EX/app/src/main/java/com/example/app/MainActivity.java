package com.example.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.app.Request.RetrofitClient;
import com.example.app.Request.RequestInterface;
import com.example.app.Rst.Rst;
import com.example.app.Rst.RstAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RstAdapter adapter;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 이 액티비티의 사용자 인터페이스 레이아웃을 설정한다.
        // 레이아웃 파일은 프로젝트 res/layout/main_activity.xml 파일로 정의됨.
        setContentView(R.layout.activity_main);

        Button filterBtn = (Button)findViewById(R.id.filterBtn);
        filterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog(1); // 다이얼로그 호출
            }
        });

        initViews();
    }

    //  View의 초기화
    private void initViews() {
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
    private void loadJSON() {
        //  Retrofit을 Singleton Pattern으로 생성한 객체를 가져옴.
        retrofit = RetrofitClient.getClient();

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

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("1인당 가격");

        final String[] items = { "1 만원 이하", "1 만원 대", "2 만원 대", "3 만원 대", "4 만원 대", "5 만원 이상" };
        final boolean[] checkedItems = { false, false, false, false, false, false };

        builder.setMultiChoiceItems( items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick( DialogInterface dialog, int which, boolean isChecked ) {
                // 바뀐 것을 적용한다.
                checkedItems[which] = isChecked;
            }
        });

        // 같은 onclick을 쓰기때문에 DialogInterface를 적어주어야 에러발생하지 않는다.
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ArrayList<Integer> selectList = new ArrayList<>();
                // Toast로 현제 체크된 항목 표시하기
                String str = "";
                for ( int i = 0; i < items.length; i++ ){
                    if( checkedItems[i] ) {
                        str += items[i];
                        selectList.add(i);
                        if (i != items.length - 1) {
                            str += "\n";
                        }
                    }
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                if(selectList.size() == 0){
                    Toast.makeText(MainActivity.this, "필터 조건이 없다면\n모든 레스토랑 목록을 보여줍니다.", Toast.LENGTH_LONG).show();
                }
                adapter.filter(selectList);
            }
        });
        return builder.create();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this.getApplicationContext(),"Thanks for using application!!",Toast.LENGTH_LONG).show();
        finish();
        return;
    }
}