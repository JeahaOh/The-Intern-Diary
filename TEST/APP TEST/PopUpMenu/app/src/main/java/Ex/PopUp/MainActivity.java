package Ex.PopUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        PopupMenu pop = new PopupMenu(this,v);
        pop.getMenuInflater().inflate(R.menu.menu, pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item){
                Toast.makeText(getApplicationContext(),"클릭된 팝업메뉴:" + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        pop.show();
    }
}
