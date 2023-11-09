package com.example.visiontovision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instructionshindi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructionshindi);
        Button abc = findViewById(R.id.arrowkey3);

        abc.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent4 = new Intent(getApplicationContext(), readypagehindi.class);
                                       startActivity(intent4);
                                   }
                               }
        );
    }
}