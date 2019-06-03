package com.example.climber;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HikingHikes extends AppCompatActivity {

    private static final String TAG = "HikingHikes";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<HikesClass> list;
    HikingAdapter adapter;
    Button btn_navi, btn_navi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hikinghikes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HikingHikes.this, SecondMenu.class)); //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        if (isServicesOK()){
            init();
            Button btn_navi2 = (Button ) findViewById(R.id.btn_navi2);
            Button btn_navi = (Button ) findViewById(R.id.btn_navi);

            btn_navi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HikingHikes.this, MapsActivity2.class);
                    startActivity(intent);

                }
            });

            btn_navi2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HikingHikes.this, MapsActivity.class);
                    startActivity(intent);

                }
            });

        }


        recyclerView = (RecyclerView) findViewById(R.id.myRecycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<HikesClass>();



        reference = FirebaseDatabase.getInstance().getReference().child("Hikes");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    HikesClass h = dataSnapshot1.getValue(HikesClass.class);
                    list.add(h);
                }
                adapter = new HikingAdapter(HikingHikes.this,list);
                recyclerView.setAdapter(adapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HikingHikes.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });


    }
    private void init(){

    }
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(HikingHikes.this);

        if (available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        } else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: Error, possible to fix");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(HikingHikes.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "Maps unavailable", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
