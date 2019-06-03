package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.climber.Fragments.UsersFragment;
import com.google.firebase.auth.FirebaseAuth;

public class SecondMenu extends AppCompatActivity {

    Button btn_2m1, btn_2m2, btn_2m3, btn_2m4, btn_2m5,btn_2m6, btn_2m7, btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_menu);

        btn_2m1 = (Button) findViewById(R.id.btn_2m1);
        btn_2m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, MainActivity.class));

            }
        });


        btn_2m2 = (Button) findViewById(R.id.btn_2m2);
        btn_2m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, ClimbingOPlaces.class));

            }
        });

        btn_2m3 = (Button) findViewById(R.id.btn_2m3);
        btn_2m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, TrainingChoice.class));

            }
        });

        btn_2m4 = (Button) findViewById(R.id.btn_2m4);
        btn_2m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, HikingActivity.class));

            }
        });

        btn_2m5 = (Button) findViewById(R.id.btn_2m5);
        btn_2m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, learn.class));

            }
        });

        btn_2m6 = (Button) findViewById(R.id.btn_2m6);
        btn_2m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, QuizGame.class));

            }
        });

        btn_2m7 = findViewById(R.id.btn_2m7);

        btn_2m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondMenu.this, comment.class));
            }
        });

        btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SecondMenu.this, StartActivity.class));
            }
        });



    }
}
