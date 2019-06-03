package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    Button btn_again, btn_bonus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        t1 = (TextView)findViewById(R.id.textView5);
        t2 = (TextView)findViewById(R.id.textView6);
        t3 = (TextView)findViewById(R.id.textView7);

        Intent i = getIntent();

        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("wrong");


        t2.setText(correct);
        t3.setText(wrong);

        btn_bonus = (Button) findViewById(R.id.btn_bonus);
        btn_bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, bonus.class));

            }
        });

        btn_again = (Button) findViewById(R.id.btn_again);
        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizGame.class));

            }
        });






    }
}
