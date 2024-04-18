package com.hridaan.visiontovision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.visiontovision.R;

public class Hindienglish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindienglish);
        Button abc = findViewById(R.id.hindi);
        Button obc=findViewById(R.id.english);

        abc.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent2 = new Intent(getApplicationContext(), Introductionhindi.class);
                                       startActivity(intent2);
                                   }
                               }
        );
        obc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getApplicationContext(), Introduction.class);
                        startActivity(intent4);
            }
        }
        );
    }
}