package Ex.Checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView tv;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        cb4 = (CheckBox)findViewById(R.id.checkBox4);
        tv = (TextView)findViewById(R.id.textView2);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

    } // end onCreate()

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크박스를 클릭해서 상태가 바꾸었을 경우 호출되는 콜백 메서드

        String result = ""; // 문자열 초기화는 빈문자열로 하자

//        if(isChecked) tv.setText("체크했음");
//        else tv.setText("체크안했슴");

        // 혹은 3항연산자
//        tv.setText(isChecked?"체크했슴":"체크안했뜸");

        if(cb1.isChecked()) result += cb1.getText().toString();
        if(cb2.isChecked()) result += cb2.getText().toString();
        if(cb3.isChecked()) result += cb3.getText().toString();
        if(cb4.isChecked()) result += cb4.getText().toString();

        tv.setText("체크항목: " + result);
    }
}
