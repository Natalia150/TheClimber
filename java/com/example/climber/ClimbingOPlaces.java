package com.example.climber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Comment;

public class ClimbingOPlaces extends AppCompatActivity {

    Button btn_cop1, btn_cop2, btn_cop3;
   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climbing_oplaces);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingOPlaces.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });




        btn_cop1 = findViewById(R.id.btn_cop1);

        btn_cop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingOPlaces.this, ClimbingOutdoorSport.class));
            }
        });

        btn_cop2 = findViewById(R.id.btn_cop2);

        btn_cop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingOPlaces.this, ClimbingOutdoorSport.class));
            }
        });

        btn_cop3 = findViewById(R.id.btn_cop3);

        btn_cop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingOPlaces.this, ClimbingOutdoorSport.class));
            }
        });


    }
}
