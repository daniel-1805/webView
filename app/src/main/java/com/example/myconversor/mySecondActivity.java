package com.example.myconversor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;

public class mySecondActivity extends AppCompatActivity {
    double parseResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        DatePicker calendar = findViewById(R.id.calendar);
        TimePicker time = findViewById(R.id.time);
        Button sendEmailTo = findViewById(R.id.sendEmailTo);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textSeek = findViewById(R.id.textSeek);
        Button accesNext = findViewById(R.id.accesNext);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = -12;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = -12 + progress;
                textSeek.setText(String.valueOf(progressChanged));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar.setMax(24);

        Bundle bundle = getIntent().getExtras();
        parseResult = bundle.getDouble("conversion");


        sendEmailTo.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int day = calendar.getDayOfMonth();
                int year = calendar.getYear();
                int month = calendar.getMonth();
                int hour = time.getHour();
                int minute = time.getMinute();
                int zone = seekBar.getProgress();

                String [] adress = {"daniel.ramirez@escuelaestech.es"};
                String subject = "asunto";
                String text = "Fecha: " + day + "/" + month + "/" + year + "\n hora: " +  hour + ":" + minute + "\n resultado: " + parseResult + "\n zona horaria: " + zone;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, adress);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setType("message/rfc822");

                startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));

            }
        });

        accesNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherIntent = new Intent(mySecondActivity.this, access.class );
                startActivity(otherIntent);
            }
        });


















    }
}