package com.example.app.rst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app.R;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RstDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rst_detail);

        initViews();
    }

    private void initViews(){
        //  mainActivity에서 받은 data를 가져옴.
        Bundle intent = getIntent().getExtras();

        //  식당 이름 출력
        TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( intent.getString("rst_name") );

        //  식당 주소 출력
        TextView loc_dtl = findViewById( R.id.loc_dtl );
        loc_dtl.setText( intent.getString( "loc_dtl") );

        //  오픈시간 출력
        TextView opn_tm = findViewById( R.id.opn_tm );
        opn_tm.setText( intent.getString( "opn_tm") );

        //  주문 마감 시간 출력
        TextView lo_tm = findViewById( R.id.lo_tm );
        lo_tm.setText( intent.getString( "lo_tm") );

        //  brck_tm과 dnnr_tm이 같다면 쉬는 시간이 없는 것이므로 값을 주지 않는다.
        if( intent.getString("brck_tm").equals( intent.getString( "dnnr_tm") ) ) {
            Log.i( intent.getString( "brck_tm"), "brck == dnnr" );

            TextView brck_tm = findViewById( R.id.brck_tm );
            brck_tm.setText("");

            TextView dnnr_tm = findViewById( R.id.dnnr_tm );
            dnnr_tm.setText("");
        }   else {
            TextView brck_tm = findViewById( R.id.brck_tm );
            brck_tm.setText( intent.getString( "brck_tm") );

            TextView dnnr_tm = findViewById( R.id.dnnr_tm );
            dnnr_tm.setText( intent.getString( "dnnr_tm") );
        }


        /*
        구글 지도?
        LinearLayout ll = findViewById(R.id.map_layout);
        GoogleMapOptions options = new GoogleMapOptions().liteMode(true);
        MapView mapView = new MapView(this, options);
        ll.addView(mapView);
        mapView.onCreate(Bundle.EMPTY);
        */

    }
}
