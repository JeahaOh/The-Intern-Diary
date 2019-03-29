package com.example.app.Rvw;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_rvw_detail);

        Intent rvwIntent = getIntent();

        rst_name = rvwIntent.getStringExtra("rst_name");
        rvw = (Rvw) rvwIntent.getSerializableExtra("rvw");
        System.out.println(rvw.toString());


        initView();
    }

    private void initView(){
        ImageView rvw_phot;
        TextView author_id, cdt_val, cont;
        RatingBar score_val;

        String url = RetrofitClient.getRvwImgUrl();
        //  image의 resource 경로와, image의 이름을 경로에 추가
        url += rvw.getRvw_phot();

        rvw_phot = findViewById(R.id.rvw_phot);
        Picasso.with(this)
                //  URL에서 Image를 가져와라.
                .load(url)
                //  사진이 없다면, res/drawable/ic_star_black.xml의 이미지를 띄워라.
                .error(R.drawable.ic_star_black)
                .into(rvw_phot);

        author_id = findViewById(R.id.author_id);
        author_id.setText(rvw.getId());

        cdt_val = findViewById(R.id.cdt_val);
        cdt_val.setText(rvw.getCdt());

        score_val = findViewById(R.id.scoreVal);
        score_val.setRating(rvw.getScore());

//        score_val = findViewById(R.id.score_val);
//        score_val.setText(rvw.getScore() + "");

        cont = findViewById(R.id.cont);
        cont.setText(rvw.getCont());


    }

}
