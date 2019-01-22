package com.example.olawr.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TopicDetail extends AppCompatActivity {
    Button b;
    ImageView iv;
    DatePicker dp;
    ListView lv;
    EditText et;
    Spinner spin;
    NumberPicker np;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        b = findViewById(R.id.But);
        dp = findViewById(R.id.DP);
        iv = findViewById(R.id.IV);
        et = findViewById(R.id.ET);
        spin = findViewById(R.id.spin);
        np = findViewById(R.id.NP);
        lv = findViewById(R.id.LV);
        tv = findViewById(R.id.desc);
        tv2 = findViewById(R.id.code);

        np.setMinValue(1);
        np.setMaxValue(1000000);

        int i = getIntent().getIntExtra("itemid",0);
        showComponent(i);
    }

    public void showComponent(int i){
        String [] desc = getResources().getStringArray(R.array.descriptions);
        String [] code = getResources().getStringArray(R.array.code);
        String d = desc[i];
        String c = code[i];
        tv2.setText(c);
        tv.setText(d);
        if(i==0){
            Toast.makeText(TopicDetail.this,"This is a toast",Toast.LENGTH_LONG).show();
        }else if(i==1){
            dp.setVisibility(View.VISIBLE);
        }else if(i==2){
            iv.setVisibility(View.VISIBLE);
        }else if(i==3){
            lv.setVisibility(View.VISIBLE);
        }else if(i==4){
            spin.setVisibility(View.VISIBLE);
        }else if(i==5){
            et.setVisibility(View.VISIBLE);
        }else if(i==6){
            b.setVisibility(View.VISIBLE);
        }else if(i==7){
            np.setVisibility(View.VISIBLE);
        }else{
            tv.setText("Something went wrong");
        }

    }


}
