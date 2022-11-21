package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homeworkout.R;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class PlayExercise extends AppCompatActivity {
    String CourseName;
    int week, day, isCompleted = 0;
    ArrayList<DayData> arrayList = new ArrayList<>();
    TextView TimerTV;
    int Workoutno;
    int Time;

    ImageView playPause_BTN;
    int Playstate = 0;
    int seconds;

    int TimeLeft;


    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_exercise);

        TimerTV = findViewById(R.id.TimerTV);
        playPause_BTN = findViewById(R.id.playPause_BTN);


        Bundle b = getIntent().getExtras();
        CourseName = b.getString("CourseName");
        week = b.getInt("week");
        day = b.getInt("day");


        SqliteDataClass sqliteDataClass = new SqliteDataClass(this);
        arrayList = sqliteDataClass.getStartBtData(CourseName, week, day);

        if(arrayList.isEmpty())
        {
            Toast.makeText(this, "You completed This Day", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        else
        {
            Workoutno = arrayList.get(0).getWorkoutno();

           sqliteDataClass.updateCompleteExercise(CourseName, week, day, Workoutno);


            if(Playstate==0)
            {
                playPause_BTN.setImageResource(R.drawable.ic_play_vector);
            }else
            {
                playPause_BTN.setImageResource(R.drawable.ic_pause_vector);
            }



            Time = arrayList.get(0).getWorkouttimer();
            Time = Time * 1000;


            countdown(Time);

            playPause_BTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Playstate == 0) {
                        Playstate = 1;
                        playPause_BTN.setImageResource(R.drawable.ic_pause_vector);
                        countDownTimer.cancel();

                    } else {
                        Playstate = 0;
                        playPause_BTN.setImageResource(R.drawable.ic_play_vector);
                        countdown(TimeLeft*1000);
                    }
                }
            });
        }



    }

    private void countdown(int time) {
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                seconds = (int) (l / 1000);
                TimerTV.setText(String.valueOf(seconds));
                TimeLeft = seconds;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(PlayExercise.this, RestActivity.class);
                startActivity(intent);
            }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
     try {
         countDownTimer.cancel();
     }catch (Exception e)
     {

     }
        this.finish();

    }
}