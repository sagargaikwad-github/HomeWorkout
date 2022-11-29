package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homeworkout.R;

import java.util.Locale;

public class RestActivity extends AppCompatActivity {
    LinearLayout RestAddBTN,RestMinusBTN;
    TextView RestTV,RestSkipTV;

    String CourseName;
    int week,day;
    int seconds;

    int Time;
    int TimeLeft;

    TextToSpeechClass textToSpeechClass;
    TextToSpeech textToSpeech;


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

//        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int i) {
//                if(i!=TextToSpeech.ERROR)
//                {
//                    textToSpeech.setLanguage(Locale.UK);
//                    PlaySound();
//                }
//            }
//        });




        //Time=10;
        Time=1; //For Testing we take 1 sec
        String Text="Take a Rest For "+Time+" Seconds";
        textToSpeechClass=new TextToSpeechClass(textToSpeech,this,Text);

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
                if(TimeLeft==2)
                {
                    String Text="Get Ready For Next Exercise";
                    textToSpeechClass=new TextToSpeechClass(textToSpeech,RestActivity.this,Text);
                }
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

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        super.onBackPressed();
        this.finish();
    }
}