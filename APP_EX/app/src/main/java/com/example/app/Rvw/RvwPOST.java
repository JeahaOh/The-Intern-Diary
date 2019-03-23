package com.example.app.Rvw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.Memb.Memb;
import com.example.app.R;

import java.io.File;

public class RvwPOST extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();

    TextView rst_title;     //  화면 타이틀
    RatingBar ratingBar;    //  레이팅 바
    TextView rateResult;    //  레이팅 바 추가 text
    ImageView imageView;    //  이미지 미리보기
    Button cameraBtn;       //  사진 찍기 버튼
    Button loadPhoto;       //  사진 가져오기 버튼
    Button submit;          //  사진 가져오기 버튼

    int score = 3;          //  RatingBar 초기값.

    File photoFile;         //  보냏 사진 File의 껍데기.








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_post);

        //  데이터 받기
        Bundle intent = getIntent().getExtras();
        //  rst_no
        final int rst_no = intent.getInt( "rst_no" );
        //  rst_name
        final String rst_nm = intent.getString("rst_nm");
        rst_title = findViewById(R.id.rst_title);
        rst_title.setText( rst_nm + " 후기" );

        // 레이아웃과 변수 연결
        ratingBar = findViewById(R.id.ratingBar);       //  Rating Bar
        rateResult = findViewById(R.id.rateResult);     //  Rating Bar의 Sub Text
        cameraBtn = findViewById(R.id.takePhoto);       //  카메라 버튼
        loadPhoto = findViewById(R.id.loadPhoto);       //  사진 가져오기 버튼
        imageView = findViewById(R.id.phot_preview);    //  사진 미리보기 view
        submit = findViewById(R.id.submit);             //  submit 버튼


        //  ratingBar 변경 리스너
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

                //  후기 값을 String 가져온 뒤, null 값이면 Toast와 함께 리턴함.
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

                //  POST METHOD 들어올 자리.
            }
        });

    }

}
