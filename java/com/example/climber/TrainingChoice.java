package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TrainingChoice extends AppCompatActivity {
    Button btn_t4, btn_t1, btn_t2, btn_t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_choice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingChoice.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        btn_t4 = findViewById(R.id.btn_t4);
        btn_t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TrainingChoice.this, TRandom.class));

            }
        });

        btn_t1 = findViewById(R.id.btn_t1);
        btn_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TrainingChoice.this, Countdown.class));

            }
        });

        btn_t2 = findViewById(R.id.btn_t2);
        btn_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TrainingChoice.this, plankS.class));

            }
        });

        btn_t3 = findViewById(R.id.btn_t3);
        btn_t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TrainingChoice.this, pushupS.class));

            }
        });
    }
}
