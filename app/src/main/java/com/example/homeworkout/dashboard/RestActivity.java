package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homeworkout.R;

public class RestActivity extends AppCompatActivity {
    LinearLayout RestAddBTN,RestMinusBTN;
    TextView RestTV,RestSkipTV;

    String CourseName;
    int week,day;
    int seconds;

    int Time;
    int TimeLeft;


    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        RestAddBTN=findViewById(R.id.RestAddBTN);
        RestMinusBTN=findViewById(R.id.RestMinusBTN);
        RestTV=findViewById(R.id.RestTV);
        RestSkipTV=findViewById(R.id.RestSkipBTN);


        Bundle b = getIntent().getExtras();
        CourseName = b.getString("CourseName");
        week = b.getInt("week");
        day = b.getInt("day");


        Time=10;
        RestTV.setText(Time+" sec");

       countDownTimer();

        RestAddBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 countDownTimer.cancel();
                 Time=TimeLeft+5;
                 countDownTimer();
            }
        });

        RestSkipTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });


    }

    private void countDownTimer() {
        countDownTimer=new CountDownTimer(Time*1000,1000) {
            @Override
            public void onTick(long l) {
                seconds = (int) (l / 1000);
                RestTV.setText(String.valueOf(seconds));
                TimeLeft= seconds;
            }

            @Override
            public void onFinish() {
                nextActivity();
            }
        }.start();
    }

    private void nextActivity() {

        Intent intent=new Intent(this,PlayExercise.class);
        intent.putExtra("CourseName",CourseName);
        intent.putExtra("week",week);
        intent.putExtra("day",day);
        startActivity(intent);


        countDownTimer.cancel();
        this.finish();
    }

}