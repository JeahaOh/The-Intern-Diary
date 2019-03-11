package com.yummy.jeaha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //  onCreate : 앱을 생성함.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //  첫 화면에 activity_main 내용을 띄움.
        //  R : 앱이 생성될 때 만들어진 기본 클래스 layout = R에서 파생된 레이아웃 킅래스
        //  res/layout/activity_main.xml 파일의 내용을 불러옴.

        Button button = findViewById(R.id.BTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hell the Android", Toast.LENGTH_LONG).show();
            }
        });
    }
}
