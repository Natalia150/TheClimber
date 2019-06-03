package com.example.climber;
import java.util.Random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;



public class TRandom extends AppCompatActivity {

    private ImageView imageViewDice;
    private Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TRandom.this, TrainingChoice.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


            imageViewDice = findViewById(R.id.image_view_dice);
            imageViewDice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollDice();
                }
            });
        }

        private void rollDice () {
            int randomNumber = rng.nextInt(6) + 1;

            switch (randomNumber) {
                case 1:
                    imageViewDice.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    imageViewDice.setImageResource(R.drawable.dice2);
                    break;
                case 3:
                    imageViewDice.setImageResource(R.drawable.dice3);
                    break;
                case 4:
                    imageViewDice.setImageResource(R.drawable.dice4);
                    break;
                case 5:
                    imageViewDice.setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    imageViewDice.setImageResource(R.drawable.dice6);
                    break;
            }
        }
    }
