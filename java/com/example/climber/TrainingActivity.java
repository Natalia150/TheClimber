package com.example.climber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TrainingActivity extends AppCompatActivity {
    int minteger = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        }

        public void increaseInteger(View view) {
            minteger = minteger + 1;
            display(minteger);

        }public void decreaseInteger(View view) {
            minteger = minteger - 1;
            display(minteger);
        }

        private void display(int number) {
            TextView displayInteger = (TextView) findViewById(
                    R.id.integer_number);
            displayInteger.setText("" + number);
    }
}
