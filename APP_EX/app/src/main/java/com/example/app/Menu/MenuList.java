
package com.example.app.Menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;
import com.example.app.Menu.MenuAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MenuList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private Retrofit retrofit;
    private static int rst_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("메뉴판");
        setContentView(R.layout.activity_menu_list);


        Intent menuList = getIntent();
        rst_no = menuList.getIntExtra("rst_no", 0);
        if( rst_no == 0 ){
            Toast.makeText(getApplicationContext(),
                    "Menu Error\n관리자에게 문의하세요",
                    Toast.LENGTH_LONG).show();
            return;
        }   else    {
            initViews( rst_no );
        }
    }

    private void initViews( int rst_no ) {
        recyclerView = (RecyclerView)findViewById(R.id.menu_card);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON( rst_no );
    }

    private void loadJSON( int rst_no ) {
        retrofit = RetrofitClient.getClient();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<Menu>> call = request.getMenuBoard( rst_no );
        call.enqueue( new Callback<List<Menu>>() {

            @Override
            public void onResponse( Call<List<Menu>> call, Response<List<Menu>> response ) {

                List<Menu> list = response.body();
                adapter = new MenuAdapter( list );
                recyclerView.setAdapter( adapter );
            }

            @Override
            public void onFailure( Call<List<Menu>> call, Throwable t ) {
                Toast.makeText(
                        getApplicationContext(),
                        "Menu Error\n관리자에게 문의하세요",
                        Toast.LENGTH_LONG).show();
                Log.v("Error",t.getMessage());
            }
        });
    }

}
