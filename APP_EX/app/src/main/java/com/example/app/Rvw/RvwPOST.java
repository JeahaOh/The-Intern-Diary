package com.example.app.Rvw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.Memb.Memb;
import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RvwPOST extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ImageView imageView;
    Button cameraBtn;
    TextView submit;
    static final int TAKE_PICTURE = 1;

    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;



    File photoFile;
    Bitmap phot;

    RatingBar ratingBar;
    TextView rateResult;
    TextView rst_title;
    int score = 3;

    Button loadPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_post);

        //  데이터 받기
        Bundle intent = getIntent().getExtras();
        final int rst_no = intent.getInt( "rst_no" );
        final String rst_nm = intent.getString("rst_nm");
        rst_title = findViewById(R.id.rst_title);
        rst_title.setText( rst_nm + " 후기" );



        // 레이아웃과 변수 연결
        imageView = findViewById(R.id.phot_preview);
        cameraBtn = findViewById(R.id.takePhoto);
        loadPhoto = findViewById(R.id.loadPhoto);
        submit = findViewById(R.id.submit);


        // ratingBar 레이아웃과 연결
        ratingBar = findViewById(R.id.ratingBar);
        rateResult = findViewById(R.id.rateResult);

        //  ratingBar 변경 리스너 추가
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score = (int) rating;
                switch( score ) {
                    case 1 :
                        rateResult.setText( "최악" );
                        return;
                    case 2 :
                        rateResult.setText( "별로" );
                        return;
                    case 3 :
                        rateResult.setText( "무난" );
                        return;
                    case 4 :
                        rateResult.setText( "맛집" );
                        return;
                    case 5 :
                        rateResult.setText( "추천" );
                        return;
                }
            }
        });


        // 카메라 버튼에 리스너 추가
        cameraBtn.setOnClickListener(new Button.OnClickListener(){
            // 버튼 onClick 리스너 처리부분
            @Override
            public void onClick( View v ) {

            }
        });

        //  사진 가져오기 버튼에 리스너 추가
        loadPhoto.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick( View v ) {

            }
        });


        // submit 버튼에 리스너 추가
        submit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("\n\tSUBMIT BTN CLICKED!");

                String id = Memb.getMemb().getId();

                EditText contText = (EditText)findViewById(R.id.rvw_cont);
                String cont = contText.getText().toString();
                if( cont.length() <= 0 || cont == "" ) {
                    Toast.makeText( getApplicationContext(),
                            "후기를 작성 해 주세요", Toast.LENGTH_SHORT ).show();
                    return;
                }


                System.out.println
                        ("id : " + id + "\nrst_no : " + rst_no
                                + "\nscore : " + score + "\ncont : "
                                + cont + "\nphot.path() :" + photoFile );
                
            }
        });

    }

}
