package com.example.homeworkout.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Locale;

public class RestActivity extends AppCompatActivity {
    LinearLayout RestAddBTN, RestMinusBTN;
    TextView RestTV, RestSkipTV, Rest_Next_TV;
    ImageView Rest_Next_IV;

    String CourseName;
    int week, day;
    int seconds;

    int Time = 10;
    int TimeLeft;


    TextToSpeech textToSpeech;
    ArrayList<DayData> checkForRestData = new ArrayList<>();
    SqliteDataClass sqliteDataClass;

    CountDownTimer countDownTimer;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        RestAddBTN = findViewById(R.id.RestAddBTN);
        RestMinusBTN = findViewById(R.id.RestMinusBTN);
        RestTV = findViewById(R.id.RestTV);
        RestSkipTV = findViewById(R.id.RestSkipBTN);
        Rest_Next_IV = findViewById(R.id.Rest_Next_IV);
        Rest_Next_TV = findViewById(R.id.Rest_Next_TV);


        Bundle b = getIntent().getExtras();
        CourseName = b.getString("CourseName");
        week = b.getInt("week");
        day = b.getInt("day");


        sqliteDataClass = new SqliteDataClass(this);
        checkForRestData = sqliteDataClass.getStartBtData(CourseName, week, day, 0);


        if (!checkForRestData.isEmpty()) {
            Rest_Next_TV.setText(checkForRestData.get(0).getWorkoutname());

            String GetWorkout_ID = checkForRestData.get(0).getWorkout_id();

            firebaseDatabase = firebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference();
            DatabaseReference getImage = databaseReference.child("Images").child(GetWorkout_ID);

            getImage.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String getIMG = snapshot.getValue(String.class);
                    Glide.with(getApplicationContext()).load(getIMG).into(Rest_Next_IV);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(Locale.UK);

                        String Text = "Take a Rest For " + Time + " Seconds";
                        textToSpeech.speak(Text, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            });

        } else {
            Toast.makeText(this, "Res Null", Toast.LENGTH_SHORT).show();
        }


        RestTV.setText(Time + " sec");

        countDownTimer();

        RestAddBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                Time = TimeLeft + 5;
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
        countDownTimer = new CountDownTimer(Time * 1000, 1000) {
            @Override
            public void onTick(long l) {
                seconds = (int) (l / 1000);
                RestTV.setText(String.valueOf(seconds));
                TimeLeft = seconds;
                if (TimeLeft == 4) {
                    String Text = "Get Ready For Next Exercise";
                    textToSpeech.speak(Text, TextToSpeech.QUEUE_FLUSH, null);
                    //textToSpeechClass=new TextToSpeechClass(textToSpeech,RestActivity.this,Text);
                }
            }

            @Override
            public void onFinish() {
                nextActivity();
            }
        }.start();
    }

    private void nextActivity() {
        Intent intent = new Intent(this, PlayExercise.class);
        intent.putExtra("CourseName", CourseName);
        intent.putExtra("week", week);
        intent.putExtra("day", day);
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