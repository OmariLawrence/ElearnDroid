package com.example.olawr.elearndroid2018;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    ProgressBar pb;
    CountDownTimer ct;
    RadioGroup rg1,rg2,rg3,rg4,rg5;
    RadioButton r2,r4,r7,r10,r14;
    Button submit;
    TextView tv;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submit = findViewById(R.id.submit);
        r2 = findViewById(R.id.rb2);
        r4 = findViewById(R.id.rb4);
        r7 = findViewById(R.id.rb7);
        r10 = findViewById(R.id.rb10);
        r14 = findViewById(R.id.rb14);
        rg1 = findViewById(R.id.RG1);
        rg2 = findViewById(R.id.RG2);
        rg3 = findViewById(R.id.RG3);
        rg4 = findViewById(R.id.RG4);
        rg5 = findViewById(R.id.RG5);
        tv = findViewById(R.id.result);
        rg1.setVisibility(View.VISIBLE);
        rg2.setVisibility(View.VISIBLE);
        rg3.setVisibility(View.VISIBLE);
        rg4.setVisibility(View.VISIBLE);
        rg5.setVisibility(View.VISIBLE);
        submit.setVisibility(View.VISIBLE);
        pb = findViewById(R.id.timer);
        pb.setProgress(i);
        ct = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                pb.setProgress(i*100/(30000/1000));
            }

            @Override
            public void onFinish() {
                i++;
                pb.setProgress(100);
                submit.performClick();
            }
        };
        ct.start();
    }
    public void getResult(View v){
        boolean q1,q2,q3,q4,q5;
        q1 = Correct(r2);
        q2 = Correct(r4);
        q3 = Correct(r7);
        q4 = Correct(r10);
        q5 = Correct(r14);
        Intent i = new Intent(Quiz.this, calculate.class);
        i.putExtra("q1",q1);
        i.putExtra("q2",q2);
        i.putExtra("q3",q3);
        i.putExtra("q4",q4);
        i.putExtra("q5",q5);
        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode==Activity.RESULT_OK){
                rg1.setVisibility(View.INVISIBLE);
                rg2.setVisibility(View.INVISIBLE);
                rg3.setVisibility(View.INVISIBLE);
                rg4.setVisibility(View.INVISIBLE);
                rg5.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.INVISIBLE);
                if(data.getBooleanExtra("new high score",false)){
                    tv.setText("NEW HIGH SCORE: "+ data.getIntExtra("score",0));
                }else{
                    tv.setText("SCORE: "+ data.getIntExtra("score",0));
                }
            }
        }
    }

    public boolean Correct(RadioButton correct){
        if(correct.isChecked()){
            return true;
        }
        return false;
    }
}
