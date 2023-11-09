package com.example.visiontovision;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.DisplayMetrics;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
public class alphabetlefteye extends AppCompatActivity {
    TextView abc;
    TextView dialog;
    TextView doyouconfirm;
    String c;
    Button yes;
    Button no;
    int iterationCounter=2;
    float meters=0.00583f;
    String arr[]=new String[]{"A","C","E","F","G","H","I","K","L","M","N","O","Q","R","S","V","W","X"};
    boolean hasfailedyet=false;
public static int ResultCounter=0;
Button instructionsbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabetlefteye);
        abc=findViewById(R.id.alphaleft);
        dialog=findViewById(R.id.dialogbox2);
        yes=findViewById(R.id.confirmdecision2);
        no=findViewById(R.id.confirmdecisionno2);
        instructionsbutton=findViewById(R.id.instructionbutton);
        alertbox();
        doyouconfirm=findViewById(R.id.doyou2);
        doyouconfirm.setVisibility(View.INVISIBLE);
        yes.setVisibility(View.INVISIBLE);
        no.setVisibility(View.INVISIBLE);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dpi=metrics.densityDpi;
        float px=(float) ((meters * dpi)/0.0254f);
        String arr[]=new String[]{"A","C","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","V","W","X"};
        Button mic=findViewById(R.id.micbutton2);
        abc.setTextSize(px);
        c=arr[random()]+"  "+arr[random()]+"  "+arr[random()];
        abc.setText(c);

        mic.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                                       intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                       intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                                       try {
                                           startActivityForResult.launch(
                                                   intent
                                           );
                                       }
                                       catch (Exception e){
                                           Log.i("abc", "onClick: "+e.getMessage());
                                       }
                                   }
                               }
        );
    }



    ActivityResultLauncher<Intent>startActivityForResult=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getData()!=null){
                    ArrayList<String> resultarray = result.getData().getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String a=resultarray.get(0);
                    a=a.replaceAll("\\s", "");
                    String replace="";
                    for(int i=0;i<a.length();i++){
                        replace=replace+"  "+a.charAt(i);//  s  c  c
                    }
                    String b=replace.substring(2);
                    dialog.setText(Objects.requireNonNull(resultarray).get(0));
                    doyouconfirm.setVisibility(View.VISIBLE);
                    yes.setVisibility(View.VISIBLE);
                    no.setVisibility(View.VISIBLE);
                    yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(c.equalsIgnoreCase(b)){
                                abc.setTextColor(Color.GREEN);
                                if(hasfailedyet==false)
                                    ResultCounter++;
                            }
                            else{
                                hasfailedyet=true;
                                abc.setTextColor(Color.RED);
                            }
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    nextIteration(iterationCounter);
                                }
                            },3000);
                        }
                    });
                    no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.setText("");
                            doyouconfirm.setVisibility(View.INVISIBLE);
                            yes.setVisibility(View.INVISIBLE);
                            no.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
    );
    public int random(){
        int max=18;
        int min=0;
        int rand=(int)((Math.random()*(max-min))+min);
        return rand;
    }
    public void nextIteration(int a) {
        if (a == 2)
            meters = meters / 2;
        if (a == 3)
            meters = (float) (meters / 1.25);//20/80
        if (a == 4)
            meters = (float) (meters / 1.33);//20/60
        if (a == 5)
            meters = (float) (meters / 1.5);//20/40
        if (a == 6)
            meters = (float) (meters / 2);//20/20
        if(a==7){
            abc.setText("");
            Intent intent2 = new Intent(getApplicationContext(), Resultpage.class);
            startActivity(intent2);
        }
        if(a<7){
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int dpi = metrics.densityDpi;
            float px = (float) ((meters * dpi) / 0.0254f);
            abc.setTextSize(px);
            c = arr[random()] + "  " + arr[random()] + "  " + arr[random()];
            abc.setText(c);
            dialog.setText("");
            abc.setTextColor(Color.BLACK);
            doyouconfirm.setVisibility(View.INVISIBLE);
            yes.setVisibility(View.INVISIBLE);
            no.setVisibility(View.INVISIBLE);
            iterationCounter++;

        }
    }
    public void alertbox(){
       Dialog dialog =new Dialog(alphabetlefteye.this);
       instructionsbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.setContentView(R.layout.instructionsalertbox);
               dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
               dialog.show();
               Button close=dialog.findViewById(R.id.close);
               close.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });
           }
       });

    }
}