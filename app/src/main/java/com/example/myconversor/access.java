package com.example.myconversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class access extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        Button accesWeb = findViewById(R.id.accessWeb) ;
        Button accessConversor = findViewById(R.id.accessConversor);

        accessConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (access.this, MainActivity.class );
                startActivity(intent);
            }
        });

        accesWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(access.this, webview.class);
                startActivity(intent);
            }
        });



    }
}