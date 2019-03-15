package com.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView idText = (TextView) findViewById(R.id.idText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        Button managementButton = (Button) findViewById(R.id.managementButton);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pwd = intent.getStringExtra("pwd");
        String message = id + "Login Success";

        idText.setText(id);
        passwordText.setText(pwd);
        welcomeMessage.setText(message);

        if( !id.equals("asdf1020")){
            //  버튼을 누를수 없도록 함
//            managementButton.setEnabled(false);
            //  버튼을 보이지 않게 함
            managementButton.setVisibility(View.GONE);
        }
    }
}
