package com.example.climber;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.climber.Model2.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuizGame extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question, timertxt;
    int total = 0;
    int correct = 0;
    DatabaseReference reference;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizGame.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();


            }
        });

        b1 = (Button)findViewById(R.id.option1);
        b2 = (Button)findViewById(R.id.option2);
        b3 = (Button)findViewById(R.id.option3);
        b4 = (Button)findViewById(R.id.option4);

        t1_question = (TextView)findViewById(R.id.questionstxt);
        timertxt = (TextView)findViewById(R.id.timertxt);

        updateQuestion();
        reverseTimer(30, timertxt);

    }

    private void updateQuestion() {

        total++;
        if (total >5){

            // open result activity
            Intent i = new Intent( QuizGame.this, ResultsActivity.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("wrong", String.valueOf(wrong));
            startActivity(i);

        }else {

            reference = FirebaseDatabase.getInstance().getReference().child("Quiz").child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);

                    t1_question.setText(question.getQuestion());
                    b1.setText(question.choice1);
                    b2.setText(question.choice2);
                    b3.setText(question.choice3);
                    b4.setText(question.choice4);


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#C0C0C0"));

                                        updateQuestion();


                                    }
                                },1500);
                            }
                            else {
                                //wrong answer
                                wrong++;
                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b2.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b3.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b4.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        updateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#C0C0C0"));

                                        updateQuestion();


                                    }
                                },1500);
                            }
                            else {
                                //wrong answer
                                wrong++;
                                b2.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b2.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b3.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b4.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        updateQuestion();
                                    }
                                },1500);



                            }

                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#C0C0C0"));

                                        updateQuestion();


                                    }
                                },1500);
                            }
                            else {
                                //wrong answer
                                wrong++;
                                b3.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b2.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b3.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b4.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        updateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#C0C0C0"));

                                        updateQuestion();


                                    }
                                },1500);
                            }
                            else {
                                //wrong answer
                                wrong++;
                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b2.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b3.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        b4.setBackgroundColor(Color.parseColor("#C0C0C0"));
                                        updateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }

    public void reverseTimer(int seconds, final TextView tv)
    {
        new  CountDownTimer(seconds * 1000 + 1000,1000) {

            public void onTick(long millisUntilFinished){
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                + ":" + String.format("%02d", seconds));
        }
        public void onFinish() {
                tv.setText("Completed");
            Intent myIntent = new Intent(QuizGame.this, ResultsActivity.class);
            myIntent.putExtra("total", String.valueOf(total));
            myIntent.putExtra("correct", String.valueOf(correct));
            myIntent.putExtra("wrong", String.valueOf(wrong));
            startActivity(myIntent);

            }

        }.start();
    }
}
