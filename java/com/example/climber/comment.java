package com.example.climber;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class comment extends AppCompatActivity {

    private Button savebutton;
    private EditText edittext;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        mFirestore = FirebaseFirestore.getInstance();

        edittext = (EditText) findViewById(R.id.edittext);
        savebutton = (Button) findViewById(R.id.savebutton);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edittext.getText().toString();

                Map<String, String> userMap = new HashMap<>();

                userMap.put("Route Name", username);
                userMap.put("Comment", "Test Comment");

                mFirestore.collection("users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        startActivity(new Intent(comment.this, Feedback.class));
                        Toast.makeText(comment.this, "Comment saved", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(comment.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
