package com.example.climber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClimbingActivity extends AppCompatActivity {

    Button btn_cl1, btn_cl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climbing);

        btn_cl2 = findViewById(R.id.btn_cl2);

        btn_cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClimbingActivity.this, ClimbingOPlaces.class));
            }
        });


    }
}
