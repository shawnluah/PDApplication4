package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    TextView tvID;
    EditText etTitle, etLanguage, etGenre;
    Show data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        tvID = findViewById(R.id.textView);
        etTitle = findViewById(R.id.etShowTitle);
        etLanguage = findViewById(R.id.etLanguage);
        etGenre = findViewById(R.id.etGenre);

        Intent i = getIntent();
        data = (Show) i.getSerializableExtra("data");

        tvID.setText(data.getId());
        etTitle.setText(data.getShows());
        etLanguage.setText(data.getLanguage());
        etGenre.setText(data.getGenre());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Main3Activity.this);
                data.setShows(etTitle.getText().toString());
                data.setLanguage(etLanguage.getText().toString());
                data.setGenre(etGenre.getText().toString());
            }
        });btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Main3Activity.this);
                dbh.deleteShow(data.getId());
                dbh.close();
            }
        });


    }
}
