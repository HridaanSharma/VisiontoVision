package com.hridaan.visiontovision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.visiontovision.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        FirebaseDatabase instance=FirebaseDatabase.getInstance();
        DatabaseReference usersReference=instance.getReference("users");
        DatabaseReference totaltestsReference=instance.getReference("totalTests");

        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    int totalusers=0;
                    int passCount=0;
                    int failCount=0;
                    for(DataSnapshot user: snapshot.getChildren()) {
                        totalusers++;
                        if(Objects.equals(user.getValue(String.class), "pass")) {
                            passCount++;
                        }
                        else {
                            failCount++;
                        }
                    }
                    Log.i("passcount",String.valueOf(passCount));
                    Log.i("totalusers",String.valueOf(totalusers));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        totaltestsReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int totaltests=0;
                    int passCounttests=0;
                    int failCounttests=0;
                    for(DataSnapshot test: snapshot.getChildren()) {
                        totaltests++;
                        if(Objects.equals(test.getValue(String.class), "pass")) {
                        passCounttests++;
                    }
                        else {
                        failCounttests++;
                        }
                    }
                    Log.i("totaltests",String.valueOf(totaltests));
                    Log.i("passcount",String.valueOf(passCounttests));
                    Log.i("failcount",String.valueOf(failCounttests));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent3 = new Intent(getApplicationContext(), Hindienglish.class);
                startActivity(intent3);
            }
        }, 3000);
            }
    }