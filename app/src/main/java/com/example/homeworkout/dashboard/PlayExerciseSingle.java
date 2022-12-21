package com.example.homeworkout.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.homeworkout.R;
import com.example.homeworkout.modelData.DayData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;


public class PlayExerciseSingle extends AppCompatActivity {
    String CourseName;
    int week,day,workoutno;
    TextView singleExerciseTV;
    ProgressBar progressBar;

    ImageView Workout_IV;
    ImageView single_playpause_iv;
    ArrayList<DayData>SingleExArrayList;
    FirebaseDatabase firebaseDatabase;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_exercise_single);

        singleExerciseTV=findViewById(R.id.singleTV);
       // single_playpause_iv=findViewById(R.id.single_playpause_iv);
        Workout_IV=findViewById(R.id.single_iv);
        progressBar=findViewById(R.id.ProgressBar);


        Bundle b=getIntent().getExtras();
        CourseName=b.getString("CourseName");
        week=b.getInt("week");
        day=b.getInt("day");
        workoutno=b.getInt("workoutNo");

        SqliteDataClass sqliteDataClass=new SqliteDataClass(this);
        SingleExArrayList=sqliteDataClass.singleExArrayList(CourseName,week,day,workoutno);

        firebaseDatabase=firebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference();
        DatabaseReference getImage=reference.child("Images").child(SingleExArrayList.get(0).getWorkout_id());

        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                Workout_IV.setVisibility(View.VISIBLE);
                String link=snapshot.getValue(String.class);
                Glide.with(getApplicationContext())
                        .asGif()
                        .load(link)
                        .into(Workout_IV);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PlayExerciseSingle.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        singleExerciseTV.setText(SingleExArrayList.get(0).getWorkoutname());

    }
}