package com.hridaan.visiontovision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.visiontovision.R;

public class readypagehindi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readypagehindi);
        Button abc = findViewById(R.id.yesbutton2);

        abc.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent4 = new Intent(getApplicationContext(), countdown.class);
                                       startActivity(intent4);
                                   }
                               }
        );
    }
}