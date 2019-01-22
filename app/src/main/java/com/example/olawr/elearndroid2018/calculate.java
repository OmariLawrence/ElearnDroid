package com.example.olawr.elearndroid2018;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static java.lang.Integer.parseInt;

public class calculate extends AppCompatActivity {
    boolean q1,q2,q3,q4,q5;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        q1 = getIntent().getBooleanExtra("q1",false);
        q2 = getIntent().getBooleanExtra("q2",false);
        q3 = getIntent().getBooleanExtra("q3",false);
        q4 = getIntent().getBooleanExtra("q4",false);
        q5 = getIntent().getBooleanExtra("q5",false);
        adder(q1);
        adder(q2);
        adder(q3);
        adder(q4);
        adder(q5);
        String fileName = "highscore.txt";
        int highscore = reader(fileName);
        if(i>highscore){
            newHighScore(fileName,i,true);
        }else {
            newHighScore(fileName,i,false);
        }
    }
    public void adder(Boolean q){
        if(q){
            i++;
        }
    }
    public void newHighScore(String fileName,int score,boolean newhighscore){
        writer(fileName,score);
        Intent i = new Intent(calculate.this,Quiz.class);
        i.putExtra("new high score",newhighscore);
        i.putExtra("score",score);
        setResult(Activity.RESULT_OK,i);
        finish();
    }
    public void writer(String fileName,int score){
        String text = ""+score;
        try {
            FileOutputStream fos = openFileOutput(fileName,Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(calculate.this,"Error saving score",Toast.LENGTH_LONG).show();
        }
    }
    public int reader(String fileName){
        String text;
        int highscore;
        try{
            FileInputStream fis = openFileInput(fileName);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            text = new String(buffer);
        }catch (Exception e){
            e.printStackTrace();
            //Toast.makeText(calculate.this,"Error reading score",Toast.LENGTH_LONG).show();
            return -1;
        }
        highscore = parseInt(text);
        return highscore;
    }
}
