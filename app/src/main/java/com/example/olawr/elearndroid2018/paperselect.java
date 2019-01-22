package com.example.olawr.elearndroid2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paperselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paperselect);
    }
    public void paper1(View v){
        Intent i = new Intent(paperselect.this,paper.class);
        i.putExtra("num",0);
        startActivity(i);
    }
    public void paper2(View v){
        Intent i = new Intent(paperselect.this,paper.class);
        i.putExtra("num",1);
        startActivity(i);
    }
}
