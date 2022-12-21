package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homeworkout.R;
import com.example.homeworkout.Week1;
import com.example.homeworkout.Week2;
import com.example.homeworkout.Week3;
import com.example.homeworkout.Week4;

public class Congrats_SetComplete extends AppCompatActivity {
    Button backBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats_set_complete);

        backBTN=findViewById(R.id.backBTN);

        Bundle b = getIntent().getExtras();
        String CourseName = b.getString("CourseName");
        int week = b.getInt("week");
        int day = b.getInt("day");


        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
