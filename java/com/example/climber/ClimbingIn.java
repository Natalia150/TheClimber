package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClimbingIn extends AppCompatActivity {
    Button btn_ci1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climbing_in);

        btn_ci1 = findViewById(R.id.btn_ci1);

        btn_ci1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingIn.this, ClimbLev.class));
            }
        });
    }
}
