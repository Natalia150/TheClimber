package com.example.climber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClimbLev extends AppCompatActivity {

    Button l4p, l5, l5p, l6a, l6ap, l6b, l6bp, l6c,
            l6cp, l7a, l7ap, l7b, l7bp, l7c, l7cp, l8a;
    TextView CountView;

    int score = 0;
    TextView scoreCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climb_lev);

        scoreCounter = (TextView) findViewById(R.id.scoreCounter);
        SharedPreferences myScore = this.getSharedPreferences("MyHighScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score", 0);
        scoreCounter.setText("Your points:  " + score);





    }
}
