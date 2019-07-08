package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Show> showal;
    Button btnStats;
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Movie List");

        lv = findViewById(R.id.lv);

        btnStats = findViewById(R.id.btnStats);


        DBHelper db = new DBHelper(SecondActivity.this);
        showal = db.getAllShows();
        aa = new ShowAdapter(this, R.layout.custom_layout, showal);
        lv.setAdapter(aa);



        for (int i = 0; i < showal.size(); i++) {
            int amountStars = showal.get(i).getStars();
            if (amountStars == 5) {
                value5 = value5 + 1;
            } else if (amountStars == 4)  {
                value4 = value4 + 1;
            } else if (amountStars == 3) {
                value3 = value3 + 1;
            } else if (amountStars == 2) {
                value2 = value2 + 1;
            } else {
                value1 = value1 + 1;
            }
        }



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {

                Intent i = new Intent(SecondActivity.this, Main3Activity.class);

                Show target = new Show(showal.get(position).getId(), showal.get(position).getShows(), showal.get(position).getLanguage(), showal.get(position).getGenre(), showal.get(position).getStars());

                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, pieChartActivity.class);
                int[] stars = {value1, value2, value3 , value4, value5};
                intent.putExtra("stars" , stars);
                startActivity(intent);
            }
        });


    }

    @Override
    // Get request code
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DBHelper db = new DBHelper(SecondActivity.this);

        showal.clear();
        showal = db.getAllShows();

        aa = new ShowAdapter(this, R.layout.custom_layout, showal);
        lv.setAdapter(aa);

    }

}
