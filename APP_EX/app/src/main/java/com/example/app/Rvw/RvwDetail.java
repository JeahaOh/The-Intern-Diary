package com.example.app.Rvw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Request.RetrofitClient;
import com.squareup.picasso.Picasso;

public class RvwDetail extends Activity {

    private Rvw rvw;
    private String rst_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  RvwDetail의 UI Theme , Style을 바꿈.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_rvw_detail);

        Intent rvwIntent = getIntent();

        rst_name = rvwIntent.getStringExtra("rst_name");
        rvw = (Rvw) rvwIntent.getSerializableExtra("rvw");

        initView();
    }

    private void initView(){
        ImageView rvw_phot;
        TextView author_id, cdt_val, cont, rst_name_val;
        RatingBar score_val;

        //  화면 구성
        rst_name_val = findViewById(R.id.rst_name_val);
        rst_name_val.setText(rst_name);

        String url = RetrofitClient.getRvwImgUrl();
        url += rvw.getRvw_phot();
        rvw_phot = findViewById(R.id.rvw_phot);
        Picasso.with(this)
                .load(url)
                .error(R.drawable.no_image_found)
                .into(rvw_phot);

        author_id = findViewById(R.id.author_id);
        author_id.setText(rvw.getId());

        cdt_val = findViewById(R.id.cdt_val);
        cdt_val.setText(rvw.getCdt());

        score_val = findViewById(R.id.scoreVal);
        score_val.setRating(rvw.getScore());

        cont = findViewById(R.id.cont);
        cont.setText(rvw.getCont());
    }
}