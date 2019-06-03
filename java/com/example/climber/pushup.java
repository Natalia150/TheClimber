package com.example.climber;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class pushup extends AppCompatActivity {



    TextView timer, timer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pushup.this, TrainingChoice.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();


            }
        });

        timer = (TextView)findViewById(R.id.timer);
        new CountDownTimer(100000, 2500) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Push-ups remaining: " + millisUntilFinished / 2500);
            }

            public void onFinish() {
                timer.setText("done!");
            }
        }.start();

    } protected void onStop() {
        super.onStop();
    }
}
