package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HikingActivity extends AppCompatActivity {
    Button btn_h1, btn_h2, btn_h3, btn_h4, btn_h5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        btn_h2 = findViewById(R.id.btn_h2);

        btn_h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, HikingHikes.class));
            }
        });

        btn_h1 = findViewById(R.id.btn_h1);

        btn_h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, HikingHikes.class));
            }
        });

        btn_h3 = findViewById(R.id.btn_h3);

        btn_h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, HikingHikes.class));
            }
        });

        btn_h4 = findViewById(R.id.btn_h4);

        btn_h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, HikingHikes.class));
            }
        });

        btn_h5 = findViewById(R.id.btn_h5);

        btn_h5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingActivity.this, HikingHikes.class));
            }
        });

    }
}
