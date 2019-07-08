package sg.edu.rp.c346.pdapp4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class pieChartActivity extends AppCompatActivity {

    private List<SliceValue> pieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        setTitle("Movie Statistics");

        PieChartView pieChartView = findViewById(R.id.chart);
        // pie data is used as a list to put data in the pie chart
        List<SliceValue> pieData = new ArrayList<>();

        Integer intValue = 0;
        Integer intValue2 = 0;
        Integer intValue3 = 0;
        Integer intValue4 = 0;
        Integer intValue5 = 0;


        Intent intent = getIntent();
        int[] value = intent.getIntArrayExtra("stars");
        int stars1 = value[0];
        int stars2 = value[1];
        int stars3 = value[2];
        int stars4 = value[3];
        int stars5 = value[4];


        if (stars1 == 0) {
            intValue = 0;
        } else {
            intValue = stars1;
        }


        if (stars2 == 0) {
            intValue2 = 0;
        } else {
            intValue2 = stars2;
        }


        if (stars3 == 0) {
            intValue3 = 0;
        } else {
            intValue3 = stars3;
        }


        if (stars4 == 0) {
            intValue4 = 0;
        } else {
            intValue4 = stars4;
        }


        if (stars5 == 0) {
            intValue5 = 0;
        } else {
            intValue5 = stars5;
        }


        if (stars1 == 0) {

        } else {

            pieData.add(new SliceValue(intValue, Color.BLUE).setLabel("1 Star: " + intValue));
        }
        if (stars2 == 0) {

        } else {

            pieData.add(new SliceValue(intValue2, Color.GREEN).setLabel("2 Stars: " + intValue2));
        }
        if (stars3 == 0) {

        } else {
            pieData.add(new SliceValue(intValue3, Color.RED).setLabel("3 Stars: " + intValue3));
        }
        if (stars4 == 0) {

        } else {
            pieData.add(new SliceValue(intValue4, Color.MAGENTA).setLabel("4 Stars: " + intValue4));
        }
        if (stars5 == 0) {

        } else {
            pieData.add(new SliceValue(intValue5, Color.CYAN).setLabel("5 Stars: " + intValue5));
        }


        PieChartData pieChartData = new PieChartData(pieData);

        // Pie Chart text size
        pieChartData.setHasLabels(true).setValueLabelTextSize(20);
        pieChartView.setPieChartData(pieChartData);

    }
}
