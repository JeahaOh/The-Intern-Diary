package com.example.app.Rvw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.app.R;

public class RvwList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_list);

        initViews();
    }

    private void initViews() {
        Bundle intent = getIntent().getExtras();

        final TextView rst_name = findViewById( R.id.rst_name );
        rst_name.setText( intent.getString("rst_name") );
        TextView rvw_cnt = findViewById( R.id.rvw_cnt);
        rvw_cnt.setText( intent.getInt("cnt") + "" );
        TextView avg  = findViewById( R.id.avg);
        avg.setText( intent.getFloat("avg") + "" );
        TextView best = findViewById( R.id.best);
        best.setText( intent.getInt("best") + "" );
        TextView good = findViewById( R.id.good);
        good.setText( intent.getInt("good") + "" );
        TextView soso = findViewById( R.id.soso);
        soso.setText( intent.getInt("soso") + "" );
        TextView bad = findViewById( R.id.bad);
        bad.setText( intent.getInt("bad") + "" );
        TextView worst = findViewById( R.id.worst);
        worst.setText( intent.getInt("worst") + "" );
        TextView grade = findViewById( R.id.grade);
        grade.setText( intent.getFloat("grade") + "" );

    }
}
