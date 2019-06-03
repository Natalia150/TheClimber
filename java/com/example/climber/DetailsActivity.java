package com.example.climber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    Button btn_yes, btn_no;
    TextView scoreCounter;
    int score = 0;
    String scorestring = "Score: ";


    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btn_no = findViewById(R.id.btn_no);

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this, "Good luck next time!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DetailsActivity.this, ClimbingOutdoorSport.class));

            }
        });

        scoreCounter = (TextView) findViewById(R.id.scoreCounter);

        btn_yes = findViewById(R.id.btn_yes);
        SharedPreferences myScore = this.getSharedPreferences("MyHighScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score", 0);
        scoreCounter.setText("Points: " + String.valueOf(score));                                                             //previously problem in this line

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 10;
                scoreCounter.setText("Points: "+ String.valueOf(score));

                SharedPreferences myScore = getSharedPreferences("MyHighScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score", score);
                editor.commit();

                Toast.makeText(DetailsActivity.this, "Good job! + 10 points!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DetailsActivity.this, ClimbingOutdoorSport.class));

            }
        });
    }
}