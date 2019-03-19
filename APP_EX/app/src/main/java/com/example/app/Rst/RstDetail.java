package com.example.app.Rst;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;
import com.example.app.Rvw.RvwAdapter;
import com.example.app.Rvw.RvwList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class RstDetail extends AppCompatActivity implements OnMapReadyCallback {

    Rater rate;
//    private RecyclerView recyclerView;
//    private RvwAdapter adapter;
//
    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rst_detail);

        initViews();
    }

    private void initViews(){
        //  mainActivity에서 받은 data를 가져옴.
        Bundle intent = getIntent().getExtras();
        final int rst_no = intent.getInt( "rst_no" );
        final String rst_nm = intent.getString("rst_name");
        //  식당 이름 출력

        final TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( rst_nm );

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


        //  구글 지도를 쓰기위한 Fragment
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mapView);
        //  OnMapReadyCallback를 implement 해서 onMapReady()가 있어야 쓸 수 있음.
        mapFragment.getMapAsync(this);

        //  rst_rvw_info를 클릭하면 rvwList화면으로 넘어가기 위해 onClickListener를 만들어줌.
        ViewGroup layout = (ViewGroup) findViewById( R.id.rst_rvw_info );
        layout.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  인텐트 선언
                Intent intent = new Intent(v.getContext(), RvwList.class);

                //  rvwList인텐트에 넘겨줄 데이터를 정의해야 함.
                intent.putExtra("rst_no", rst_no );
                intent.putExtra( "rst_name", rst_nm );

                //  이 외의 정보를 넘겨야 하는가?
                intent.putExtra( "cnt", rate.getCnt() );
                intent.putExtra( "avg", rate.getAvg() );
                intent.putExtra( "best", rate.getBest() );
                intent.putExtra( "good", rate.getGood() );
                intent.putExtra( "soso", rate.getSoso() );
                intent.putExtra( "bad", rate.getBad() );
                intent.putExtra( "worst", rate.getWorst() );
                intent.putExtra( "grade", rate.getGrade() );

                //  화면 넘김.
                startActivity(intent);
            }
        });


        loadJSON( rst_no );
    }

    private void loadJSON( int rst_no ){

        //  Retrofit을 Singleton Pattern으로 생성한 객체를 가져옴.
        Retrofit retrofit = RetrofitClient.getClient();

        //  Retrofit 클래스로 RequestInterface.class를 구현하여 생성함.
        RequestInterface request = retrofit.create(RequestInterface.class);


        //  request의 getRstJSONList()를 통하여 HTTP 요청을 서버에 보냄.
        //  Call : HTTP 요청을 보내고 응답을 받는 retrofit interface.
        Call<Rater> call = request.getRate(rst_no);

        call.enqueue( new Callback<Rater>() {
            //  요청이 성공하고 응답이 수신되면 onResponse() callback Method 가 실행되고, 실패하면 onFailure가 실행됨.

            @Override
            public void onResponse( Call<Rater> call, Response<Rater> response ) {

                rate = response.body();

                TextView wannago = (TextView) findViewById(R.id.wannago);
                wannago.setText( "  " + rate.getWannago() + "개" );

                TextView cnt  = (TextView) findViewById( R.id.cnt );
                cnt.setText( rate.getCnt() + "건" );

                TextView avg  = (TextView) findViewById( R.id.avg );
                avg.setText( rate.getAvg() + "점" );

                TextView  grade = (TextView) findViewById( R.id.grade );
                grade.setText( rate.getGrade() + "점" );

                TextView  best = (TextView) findViewById( R.id.best );
                best.setText( rate.getBest() + "건" );

                TextView  good = (TextView) findViewById( R.id.good );
                good.setText( rate.getGood() + "건" );

                TextView soso = (TextView) findViewById( R.id.soso );
                soso.setText( rate.getSoso() + "건" );

                TextView bad = (TextView) findViewById( R.id.bad );
                bad.setText( rate.getBad() + "건" );

                TextView worst = (TextView) findViewById( R.id.worst);
                worst.setText( rate.getWorst() + "건" );
            }

            @Override
            public void onFailure( Call<Rater> call, Throwable t ) {
                Log.v("Error",t.getMessage());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {
        geocoder = new Geocoder(this);  // 주소 -> 좌표 변환
        double lati=0, longti=0;    // 위도, 경도 변수 선언
        List<Address> addressList = null;
        Bundle intent = getIntent().getExtras();
        String address = intent.getString( "loc_dtl");

        try{
            addressList = geocoder.getFromLocationName(
                    address,
                    10);
        } catch (IOException e){
            e.printStackTrace();
            Log.e("test","입출력 오류");
        }

        MarkerOptions markerOptions = new MarkerOptions();
        if(addressList!=null){
            lati = addressList.get(0).getLatitude();   // 해당 주소의 위도
            longti = addressList.get(0).getLongitude();  // 해당 주소의 경도
        }
        LatLng marker = new LatLng(lati,longti);

        markerOptions.position(marker);
        markerOptions.title(intent.getString("hpt_name"));  // 마커 클릭하면 뜨는 정보
        markerOptions.snippet(intent.getString("hpt_phone"));
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(marker));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
    /* 구글 지도 끝 */
}
