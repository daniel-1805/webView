package com.example.myconversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    double parseResult = 0;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_conversor);

        EditText introducerMeasure = findViewById(R.id.introduceMeasure);
        Button calculate = findViewById(R.id.calculate);
        FloatingActionButton buttonSend = findViewById(R.id.buttonSend);
        Spinner spinnerOrigin = findViewById(R.id.spinnerOrigin);
        Spinner spinnerDestiny = findViewById(R.id.spinnerDestiny);
        TextView conversion = findViewById(R.id.conversion);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result = introducerMeasure.getText().toString();
                String originMeasure = spinnerOrigin.getSelectedItem().toString();
                String destinyMeasure = spinnerDestiny.getSelectedItem().toString();

                if (!result.isEmpty()) {
                    parseResult = Double.parseDouble(result);

                    if (originMeasure.equals("metros") && destinyMeasure.equals("metros")) {

                    } else if (originMeasure.equals("metros") && destinyMeasure.equals("yardas")) {
                        parseResult *= 1.0936;
                    } else if (originMeasure.equals("metros") && destinyMeasure.equals("pulgadas")) {
                        parseResult *= 39.370;

                    } else if (originMeasure.equals("metros") && destinyMeasure.equals("kilometros")) {
                        parseResult /= 1000;
                    } else if (originMeasure.equals("kilometros") && destinyMeasure.equals("metros")) {
                        parseResult *= 1000;
                    } else if (originMeasure.equals("kilometros") && destinyMeasure.equals("yardas")) {
                        parseResult *= 1093.61;
                    } else if (originMeasure.equals("kilometros") && destinyMeasure.equals("pulgadas")) {
                        parseResult *= 39370.1;
                    } else if (originMeasure.equals("kilometros") && destinyMeasure.equals("kilometros")) {

                    } else if (originMeasure.equals("yardas") && destinyMeasure.equals("yardas")) {

                    } else if (originMeasure.equals("yardas") && destinyMeasure.equals("metros")) {
                        parseResult *= 0.9144;
                    } else if (originMeasure.equals("yardas") && destinyMeasure.equals("kilometros")) {
                        parseResult *= 0.0009144;
                    } else if (originMeasure.equals("yardas") && destinyMeasure.equals("pulgadas")) {
                        parseResult *= 36;
                    } else if (originMeasure.equals("pulgadas") && destinyMeasure.equals("pulgadas")) {

                    } else if (originMeasure.equals("pulgadas") && destinyMeasure.equals("metros")) {
                        parseResult *= 0.0254;
                    } else if (originMeasure.equals("pulgadas") && destinyMeasure.equals("kilometros")) {
                        parseResult *= 000.0254;
                    } else if (originMeasure.equals("pulgadas") && destinyMeasure.equals("yardas")) {
                        parseResult *= 0.0277778;
                    }

                    conversion.setText(String.valueOf(parseResult));
                }
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result.isEmpty()) {

                    Toast toast = Toast.makeText(MainActivity.this, "Debes introducir una medida para realizar la conversión", Toast.LENGTH_LONG);
                    toast.show();

                } else {
                    Intent intent = new Intent(MainActivity.this, mySecondActivity.class);
                    intent.putExtra("conversion", parseResult);

                    startActivity(intent);

                }


            }
        });
    }
}