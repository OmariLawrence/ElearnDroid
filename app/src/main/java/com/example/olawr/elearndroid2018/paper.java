package com.example.olawr.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class paper extends AppCompatActivity {
    TextView tv2,tv4,tv6,tv8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        tv2 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv4);
        tv6 = findViewById(R.id.tv6);
        tv8 = findViewById(R.id.tv8);
        int i = getIntent().getIntExtra("num",-1);
        if(i!=-1){
            setTexts(i);
        }
    }
    public void setTexts(int x){
        String[] pt = getResources().getStringArray(R.array.papertitle);
        String[] auth = getResources().getStringArray(R.array.Authors);
        String[] yop = getResources().getStringArray(R.array.YOP);
        String[] sum = getResources().getStringArray(R.array.summaries);
        tv2.setText(pt[x]);
        tv4.setText(auth[x]);
        tv6.setText(yop[x]);
        tv8.setText(sum[x]);
    }
}
