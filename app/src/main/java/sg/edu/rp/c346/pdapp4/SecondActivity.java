package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    Button btnShow;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Show> showal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnShow = findViewById(R.id.btnShow);

        lv = findViewById(R.id.lv);


        showal = new ArrayList<Show>();
        aa = new ShowAdapter(this, R.layout.custom_layout, showal);
        DBHelper db = new DBHelper(SecondActivity.this);
        ArrayList<Show> data = db.getAllShows();
        aa = new ShowAdapter(this, R.layout.custom_layout, data);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {

                Intent i = new Intent(SecondActivity.this, Main3Activity.class);

                Show data = showal.get(position);

                Show target = new Show(data.getId(), data.getShows(), data.getLanguage(), data.getGenre(), data.getStars());

                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){

        }
    }

}
