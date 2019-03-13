package com.yummy.jeaha.androidstudies2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"망고","토마토","포도"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton = (Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {
            //  버튼 클릭에 대한 함수 처리 부분
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //  팝업창이 뜨면 해당하는 팝업창에 대한 리스트 내용
                builder.setTitle("리스트");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    //  리스트 안에 있는 내용을 클릭했을 때 이벤트 처리
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //  클릭한 내용을 Toast로 띄움
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                    }
                });
                //  다이얼 로그에 해당하는 객체 할당
                AlertDialog alertDialog = builder.create();
                //  다이얼 로그를 보여줌
                alertDialog.show();
            }
        });

        //  종료버튼 이벤트 처리
        Button exitButton = (Button) findViewById(R.id.exitButton);
        //  이밴트 추가
        exitButton.setOnClickListener(new View.OnClickListener() {
            //  버튼을 누르면 온클릭 함수 실행
            @Override
            public void onClick(View v) {
                //  다이얼로그 빌더로 만들어 객체 할당
                //  해당 내용을 메인 엑티비티에 종속되도록 함.
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //  해당 빌더에 메세지를 설정함.
                //  알림창을 띄울때 이런 메세지가 뜸.
                builder.setMessage("EXIT?");
                //  제목을 설정 해 주면서 관련된 정보를 세팅해 줌.
                builder.setTitle("Exit Alert")
                        //  임의로 종료할 수 없도록 함.
                        .setCancelable(false)
                        //  yes 버튼과 yes버튼 클릭시 이벤트 함수
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                //  이 버튼을 누를 시 함수가 종료되고, 전체적으로 프로그램 전체가  종료될 수 있도록
                                //  finish 함수를 정의.
                                finish();
                            }
                        })
                        //  no 버튼
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           @Override
                            public void onClick(DialogInterface dialog, int i) {
                               //   클릭시 대이얼로그 창이 끊어 질 수 있도록, 다이얼로그 창이 종료  되도록 함.
                               dialog.cancel();
                           }
                        });
                //  다이얼로그 객체를 builder에서 받아줌.
                AlertDialog alert = builder.create();
                //  다이얼로그의 제목을 지어줌
                alert.setTitle("EXIT ALERT");
                //  다이얼로그가 보여질 수 있도록 함
                alert.show();
            }
        });
     }
}
