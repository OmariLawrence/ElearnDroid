package com.example.olawr.elearndroid2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button tops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tops = (Button)findViewById(R.id.topics);
    }

    public void topicscreen(View v){
        Intent i = new Intent(MainActivity.this, Topics.class);
        startActivity(i);
    }

    public void quizscreen(View v){
        Intent i = new Intent(MainActivity.this,Quiz.class);
        startActivity(i);
    }
    public void paperscreen(View v){
        Intent i = new Intent(MainActivity.this,paperselect.class);
        startActivity(i);
    }
    public void aboutandroidscreen(View v){
        Intent i = new Intent(MainActivity.this,aboutandroid.class);
        startActivity(i);
    }
}
