package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnShow;
    EditText etShow, etLanguage, etGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Create Movie");

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShowList);

        etShow = findViewById(R.id.etTitle);
        etLanguage = findViewById(R.id.etLanguage);
        etGenre = findViewById(R.id.etGenre);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String show = etShow.getText().toString();
                String language = etLanguage.getText().toString();
                String genre = etGenre.getText().toString();
                RadioGroup rg = findViewById(R.id.rg);

                int selectedButtonid = rg.getCheckedRadioButtonId();
                 if (show.equalsIgnoreCase("")) {
                    etShow.setError("Show name is required");
                } else if (language.equalsIgnoreCase("")) {
                    etLanguage.setError("Language is required");
                } else if (genre.equalsIgnoreCase("")) {
                    etGenre.setError("Language is required");


                } else if (selectedButtonid == -1) {

                    Toast.makeText(MainActivity.this, "Rating required",
                            Toast.LENGTH_SHORT).show();
                }
                 else {
                    RadioButton radioAnswer = findViewById(selectedButtonid);
                    String ra = radioAnswer.getText().toString();
                    int radioNumber = Integer.parseInt(ra);


                    DBHelper db = new DBHelper(MainActivity.this);
                    long row_affected = db.insertShow(show, language, genre, radioNumber);
                    db.close();

                    if (row_affected != -1) {
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
