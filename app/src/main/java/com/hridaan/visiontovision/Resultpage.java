package com.hridaan.visiontovision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.visiontovision.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Resultpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        TextView abc = findViewById(R.id.righteyeacuity);
        TextView obj = findViewById(R.id.lefteyeacuity);
        Button intro= findViewById(R.id.introductionpage);
        TextView power1=findViewById(R.id.eyepowerr);
        TextView power2=findViewById(R.id.eyepowerl);
        int a=alphabetrighteye.Resultcounter;
        int b=alphabetlefteye.ResultCounter;
        Log.i("a: ",String.valueOf(a));
        Log.i("b: ", String.valueOf(b));

        if(a==0){
            abc.setText("your eyesight is very poor");
        power1.setText("power greater than -2.5");}
        if(a==1){
            abc.setText("6/60");
        power1.setText("-2.25 to -2.5");}
        if(a==2){
            abc.setText("6/30");
        power1.setText("-1.75 to -2");}
        if(a==3){
            abc.setText("6/24");
        power1.setText("-1.5 to -1.75");}
        if(a==4){
            abc.setText("6/18");
        power1.setText("-1 to -1.25");}
        if(a==5){
            abc.setText("6/12");
        power1.setText("-0.5 to -0.75");}
        if(a==6){
            abc.setText("6/6");
        power1.setText("0");}

        if(b==0){
            obj.setText("your eyesight is very poor");
        power2.setText("power greater than -2.5");}
        if(b==1){
            obj.setText("6/60");
        power2.setText("-2.25 to -2.5");}
        if(b==2){
            obj.setText("6/30");
        power2.setText("-1.75 to -2");}
        if(b==3){
            obj.setText("6/24");
        power2.setText("-1.5 to -1.75");}
        if(b==4){
            obj.setText("6/18");
        power2.setText("-1 to -1.25");}
        if(b==5){
            obj.setText("6/12");
        power2.setText("-0.5 to -0.75");}
        if(b==6){
            obj.setText("6/6");
    power2.setText("0");}
        intro.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent2 = new Intent(getApplicationContext(), Introduction.class);
                                       startActivity(intent2);
                                   }
                               }
        );



        FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = databaseInstance.getReference("users");
        DatabaseReference totalTestsRef = databaseInstance.getReference("totalTests");

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.contains("key")){
            //change total tests nodes
            if(a==6 && b==6){
                totalTestsRef.push().setValue("pass");
            }
            else{
                totalTestsRef.push().setValue("fail");
            }

            totalTestsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        int passCount=0;
                        int failCount=0;
                        for(DataSnapshot test : snapshot.getChildren()){
                            Log.i("value", test.getValue(String.class));
                            if(Objects.equals(test.getValue(String.class), "pass")){
                                passCount++;
                            }
                            else{
                                failCount++;
                            }
                        }
                        Log.i("pass", String.valueOf(passCount));
                        Log.i("fail", String.valueOf(failCount));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
        else{
            //changes total tests and users node
            String key = usersRef.push().getKey();
            editor.putString("key", key);
            editor.apply();

            if(a==6 && b==6){
                totalTestsRef.push().setValue("pass");
                usersRef.child(key).setValue("pass");
            }
            else{
                totalTestsRef.push().setValue("fail");
                usersRef.child(key).setValue("fail");
            }
        }

  }
}
