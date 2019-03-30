package com.example.app.Rst;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;
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
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class RstDetail extends AppCompatActivity implements OnMapReadyCallback {

    private static Rst rst;
    private static Rater rate;

    private Geocoder geocoder;
    private static String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rst_detail);

        //  mainActivity에서 받은 Rst를 가져옴.
        Intent intent = getIntent();
        rst = (Rst) intent.getSerializableExtra("rst");

        initViews();
    }

    private void initViews() {
        //  RetrofitClient Class에서 default url을 가져옴.
        String url = RetrofitClient.getRstImgUrl();
        //  image의 resource 경로와, image의 이름을 경로에 추가
        url += rst.getRst_phot();

        ImageView imageView = findViewById(R.id.imageView);

        Picasso.with( this )
                //  URL에서 Image를 가져와라.
                .load(url)
                //  사진이 없다면, res/drawable/ic_star_black.xml의 이미지를 띄워라.
                .error(R.drawable.ic_star_black)
                .into(imageView);

        //  식당 주소 출력
        TextView loc_dtl = findViewById( R.id.loc_dtl );
        loc_dtl.setText( rst.getLoc_dtl() );

        //  오픈시간 출력
        TextView opn_tm = findViewById( R.id.opn_tm );
        opn_tm.setText( rst.getOpn_tm() );

        //  주문 마감 시간 출력
        TextView lo_tm = findViewById( R.id.lo_tm );
        lo_tm.setText( rst.getLo_tm() );

        //  미슐랭 별점 출력
        TextView starGrade = findViewById( R.id.starValue );
        starGrade.setText( rst.getStarGrade() );

        //  전화번호 클릭시 전화 dial로 연결, 전화 번호 출력.
        ViewGroup tel_no = findViewById(R.id.tel);
        TextView tel = findViewById( R.id.telVal );
        tel.setText( rst.getTel() );
        tel_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData( Uri.parse("tel:" + rst.getTel() ) );
                try{
                    startActivity(call);
                }   catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //  brck_tm과 dnnr_tm이 같다면 쉬는 시간이 없는 것이므로 값을 주지 않는다.
        String brck = rst.getBrck_tm();
        String dnnr = rst.getDnnr_tm();
        System.out.println( brck + " / " + dnnr );

        if( brck == null || brck.equals( dnnr ) ) {
            Log.i( "brck == dnnr", brck + dnnr );

            TextView brck_tm = findViewById( R.id.brck_tm );
            brck_tm.setText("");

            TextView dnnr_tm = findViewById( R.id.dnnr_tm );
            dnnr_tm.setText("");
        }   else {
            TextView brck_tm = findViewById( R.id.brck_tm );
            brck_tm.setText( brck );

            TextView dnnr_tm = findViewById( R.id.dnnr_tm );
            dnnr_tm.setText( dnnr );
        }

        //  식당 이름 출력
        final TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( rst.getRst_name() );


        /**
         *  구글 지도를 쓰기위한 Fragment
         *  OnMapReadyCallback를 implement 해야 하며,
         *  onMapReady()가 있어야 쓸 수 있음.
         */
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
        /*  구글 지도를 쓰기위한 Fragment  */

        /*  rst_rvw_info를 클릭하면 rvwList화면으로 넘어가기 위한 onClickListener  */
        ViewGroup layout = (ViewGroup) findViewById( R.id.rst_rvw_info );
        layout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRvwList(v);
            }
        });
        /*  rst_rvw_info를 클릭하면 rvwList화면으로 넘어가기 위한 onClickListener  */

        /* 후기 보기 버튼을 클릭하면 rvwList화면으로 넘어가기 위한 onClickListener */
        Button toRvwListBtn = findViewById( R.id.toRvwListBtn );
        toRvwListBtn.setOnClickListener( new View.OnClickListener(){
           @Override
           public void onClick(View v){
               toRvwList(v);
           }
        });
        /* 후기 보기 버튼을 클릭하면 rvwList화면으로 넘어가기 위한 onClickListener */


        loadJSON( rst.getRst_no() );
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

    /*  구글 지도 생성시 하는 작업  */
    @Override
    public void onMapReady( GoogleMap map ) {
        geocoder = new Geocoder(this);  // 주소 -> 좌표 변환
        double lati = 0, longti = 0;            // 위도, 경도 변수 선언
        List<Address> addressList = null;

        address = rst.getLoc_dtl();

        if( address == null || address.equals("") || address.length() < 3 ) {
            address = "성남대로 925번길 41";
        }

        try{
            addressList = geocoder.getFromLocationName(
                    address,
                    10);
        } catch (IOException e){
            e.printStackTrace();
        }

        MarkerOptions markerOptions = new MarkerOptions();
        if( addressList != null ) {
            lati = addressList.get(0).getLatitude();    // 해당 주소의 위도
            longti = addressList.get(0).getLongitude(); // 해당 주소의 경도
        }
        LatLng marker = new LatLng( lati, longti );

        markerOptions.position( marker );
        markerOptions.title( rst.getRst_name() );       // 마커 클릭하면 가게 이름이 뜨도록 함.
        markerOptions.snippet( rst.getTel() );
        map.addMarker( markerOptions );

        map.moveCamera( CameraUpdateFactory.newLatLng( marker ) );
        map.animateCamera( CameraUpdateFactory.zoomTo(15) );
    }
    /*  구글 지도 생성시 하는 작업  */

    private void toRvwList(View v){
        //  인텐트 선언
        Intent rvwList = new Intent(v.getContext(), RvwList.class);

        //  rvwList인텐트에 넘겨줄 데이터를 정의해야 함.
        rvwList.putExtra("rst_no", rst.getRst_no() );
        rvwList.putExtra( "rst_name", rst.getRst_name() );
        rvwList.putExtra("rate", rate);

        //  화면 넘김.
        startActivity( rvwList );
    }
}
