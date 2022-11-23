package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.DayData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class PlayExercise extends AppCompatActivity {
    String CourseName;
    int week, day;
    ArrayList<DayData> arrayList = new ArrayList<>();
    TextView TimerTV, workoutNameTV;
    int Workoutno;
    int Time;

    ImageView playPause_BTN;
    int Playstate = 0;
    int seconds;

    int TimeLeft;
    CountDownTimer countDownTimer;
    ImageView nextBTN;
    SqliteDataClass sqliteDataClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_exercise);

        TimerTV = findViewById(R.id.TimerTV);
        playPause_BTN = findViewById(R.id.playPause_BTN);
        nextBTN = findViewById(R.id.nextBTN);
        workoutNameTV = findViewById(R.id.workoutNameTV);


        Bundle b = getIntent().getExtras();
        CourseName = b.getString("CourseName");
        week = b.getInt("week");
        day = b.getInt("day");


        sqliteDataClass = new SqliteDataClass(this);
        //when making a database we assigning a workout incomelete to 0 means workout_isComplete data are 0. it is a pending workout
        arrayList = sqliteDataClass.getStartBtData(CourseName, week, day, 0);


        if (arrayList.isEmpty()) {
            AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
            alertdialog.setTitle("Do You Want to repeat This Set ?");
            alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sqliteDataClass.updateExercise(CourseName, week, day);
                    arrayList = sqliteDataClass.getStartBtData(CourseName, week, day, 0);
                    startPlay();
                }
            });
            alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onBackPressed();
                }
            });
            alertdialog.setCancelable(false);
            alertdialog.show();
        } else {
            startPlay();
        }
    }

    private void startPlay() {
        Workoutno = arrayList.get(0).getWorkoutno();
        workoutNameTV.setText(arrayList.get(0).getWorkoutname());

       // sqliteDataClass.updateCompleteExercise(CourseName, week, day, Workoutno);

        if (Playstate == 0) {
            playPause_BTN.setImageResource(R.drawable.ic_play_vector);
        } else {
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
                    countdown(TimeLeft * 1000);
                }
            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }

    private void nextActivity() {
        Intent intent = new Intent(PlayExercise.this, RestActivity.class);
        intent.putExtra("CourseName", CourseName);
        intent.putExtra("week", week);
        intent.putExtra("day", day);
        startActivity(intent);

        countDownTimer.cancel();
        this.finish();
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
                sqliteDataClass.updateCompleteExercise(CourseName, week, day, Workoutno);
                nextActivity();
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
        } catch (Exception e) {

        }
        this.finish();

    }
}