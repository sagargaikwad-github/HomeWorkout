package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homeworkout.R;
import com.example.homeworkout.sqLiteData.SqliteDataClass;


import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;


public class PlayExerciseSingle extends AppCompatActivity {
    String CourseName;
    int week,day,workoutno;
    TextView singleExerciseTV;

    GifImageView gifImageView;
    ImageView single_playpause_iv;
    ArrayList<DayData>SingleExArrayList;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_exercise_single);

        singleExerciseTV=findViewById(R.id.singleTV);
        single_playpause_iv=findViewById(R.id.single_playpause_iv);
        gifImageView=findViewById(R.id.single_iv);


        Bundle b=getIntent().getExtras();
        CourseName=b.getString("CourseName");
        week=b.getInt("week");
        day=b.getInt("day");
        workoutno=b.getInt("workoutNo");

        SqliteDataClass sqliteDataClass=new SqliteDataClass(this);
        SingleExArrayList=sqliteDataClass.singleExArrayList(CourseName,week,day,workoutno);

        Glide.with(this)
                .asGif()
                .load("https://i.pinimg.com/originals/b3/8d/a2/b38da20664cbd52a10f93c349a8542b2.gif")
                .into(gifImageView);

        single_playpause_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        singleExerciseTV.setText(SingleExArrayList.get(0).getWorkoutname());


    }
}