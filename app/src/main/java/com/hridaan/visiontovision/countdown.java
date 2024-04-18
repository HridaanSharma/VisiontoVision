package com.hridaan.visiontovision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.visiontovision.R;

public class countdown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        final TextView obj = findViewById(R.id.textView5);
        final String[] a = {"2"};
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                obj.setText(String.valueOf(a[0]));
                a[0] = "1";
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        obj.setText(String.valueOf(a[0]));
                        a[0] = "close your left eye";
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                obj.setTextSize(30);
                                obj.setText(String.valueOf(a[0]));
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent3 = new Intent(countdown.this, alphabetrighteye.class);
                                        startActivity(intent3);
                                    }
                                },3000);
                            }

                        }, 1000);
                    }
                },1000);
            }
        }, 1000);
    }
}