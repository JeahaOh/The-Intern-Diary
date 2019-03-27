package ex.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter adapter;

    RecyclerView recyclerView;
    EditText editsearch;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        editsearch =(EditText)findViewById(R.id.et_search);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);


        List<Recent> potionList = new ArrayList<Recent>();
        for(int i=0;i<30;i++){
            Recent rc = new Recent(i+"","");
            potionList.add(rc);
        }

        for(int i=0;i<30;i++){
            Recent rc = new Recent(i+""+i,"");
            potionList.add(rc);
        }

        for(int i=0;i<30;i++){
            Recent rc = new Recent(i+""+i+""+i,"");
            potionList.add(rc);
        }

        adapter = new RecyclerAdapter(this, potionList);
        recyclerView.setAdapter(adapter);

        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editsearch.getText().toString()
                        .toLowerCase(Locale.getDefault());
                adapter.filter(text);

            }
        });

    }

}