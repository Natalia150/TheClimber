package com.example.climber;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class plank extends AppCompatActivity {
    TextView timer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(plank.this, TrainingChoice.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();


            }
        });

        timer2 = (TextView)findViewById(R.id.timer2);
        new CountDownTimer(80000, 500) {

            public void onTick(long millisUntilFinished) {
                timer2.setText("You're doing really great! " + millisUntilFinished / 2000);
            }

            public void onFinish() {
                timer2.setText("done!");
            }
        }.start();

    } protected void onStop() {
        super.onStop();
    }
}
