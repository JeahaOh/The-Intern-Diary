package ex.dialogcheckbox;

import android.app.Activity;

import android.app.AlertDialog;

import android.app.Dialog;

import android.content.DialogInterface;

import android.content.DialogInterface.OnMultiChoiceClickListener;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.Toast;
public class MainActivity extends Activity {
    // 기존과 동일하지만
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 멀티 초이스 다이얼로그 띄우기
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1); // 다이얼로그 호출
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        final String[] items = {"1 만원 이햐", "1 만원 대", "2 만원 대", "3 만원 대", "4 만원 대", "5만원 이상"};
        final boolean[] checkedItems = {false, false, false, false, true}; //
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("1인당 가격");
        builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // 바뀐 것을 적용한다.
                checkedItems[which] = isChecked;
            }
        });

        // 같은 onclick을 쓰기때문에 DialogInterface를 적어주어야 에러발생하지 않는다.
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Toast로 현제 체크된 항목 표시하기
                String str = "";
                for (int i = 0; i<items.length; i++){
                    if(checkedItems[i]) {
                        str += items[i];
                        if (i != items.length-1) {
                            str += ", ";
                        }
                    }
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}