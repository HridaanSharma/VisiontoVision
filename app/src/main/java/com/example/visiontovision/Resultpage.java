package com.example.visiontovision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        TextView abc = findViewById(R.id.resultrighteye);
        TextView obj = findViewById(R.id.resultlefteye);
        Button intro= findViewById(R.id.introductionpage);
        int a=alphabetrighteye.Resultcounter;
        int b=alphabetlefteye.ResultCounter;
        if(a==0)
            abc.setText("your eyesight is very poor");
        if(a==1)
            abc.setText("20/200");
        if(a==2)
            abc.setText("20/100");
        if(a==3)
            abc.setText("20/80");
        if(a==4)
            abc.setText("20/60");
        if(a==5)
            abc.setText("20/40");
        if(a==6)
            abc.setText("20/20");
        if(b==0)
            obj.setText("your eyesight is very poor");
        if(b==1)
            obj.setText("20/200");
        if(b==2)
            obj.setText("20/100");
        if(b==3)
            obj.setText("20/80");
        if(b==4)
            obj.setText("20/60");
        if(b==5)
            obj.setText("20/40");
        if(b==6)
            obj.setText("20/20");
       
        intro.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent2 = new Intent(getApplicationContext(), Introduction.class);
                                       startActivity(intent2);
                                   }
                               }
        );
    }
}