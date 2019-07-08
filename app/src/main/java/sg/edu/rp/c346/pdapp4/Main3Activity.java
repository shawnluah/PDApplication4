package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle, etLanguage, etGenre;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Show data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        etTitle = findViewById(R.id.etShowTitle);
        etLanguage = findViewById(R.id.etLanguage);
        etGenre = findViewById(R.id.etGenre);

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        rb5 = findViewById(R.id.radioButton4);

        Intent i = getIntent();
        data = (Show) i.getSerializableExtra("data");

        final RadioGroup rg1 = findViewById(R.id.rg1);



        etTitle.setText(data.getShows());
        etLanguage.setText(data.getLanguage());
        etGenre.setText(data.getGenre());

        int stars = data.getStars();
        if(stars == 1) {
            rb1.setChecked(true);
        } else if (stars == 2) {
            rb2.setChecked(true);
        } else if (stars == 3) {
            rb3.setChecked(true);
        } else if (stars == 4) {
            rb4.setChecked(true);
        } else {
            rb5.setChecked(true);
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(Main3Activity.this);

                int selectedButtonid = rg1.getCheckedRadioButtonId();
                final RadioButton radioAnswer = findViewById(selectedButtonid);
                String ra = radioAnswer.getText().toString();
                int radioNumber = Integer.parseInt(ra);
                data.setShows(etTitle.getText().toString());
                data.setLanguage(etLanguage.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setStars(Integer.parseInt(radioAnswer.getText().toString()));

                if (data.getShows().equalsIgnoreCase("")) {
                    etTitle.setError("Show name is required");
                } else if (data.getLanguage().equalsIgnoreCase("")) {
                    etLanguage.setError("Language is required");
                } else if (data.getGenre().equalsIgnoreCase("")) {
                    etGenre.setError("Language is required");


                } else if (selectedButtonid == -1) {

                    Toast.makeText(Main3Activity.this, "Rating required",
                            Toast.LENGTH_SHORT).show();
                }else{
                    String msg = dbh.updateShow(data);
                    Toast.makeText(Main3Activity.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Main3Activity.this);
               String msg = dbh.deleteShow(data.getId());
                Toast.makeText(Main3Activity.this, msg, Toast.LENGTH_SHORT).show();
                dbh.close();
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
