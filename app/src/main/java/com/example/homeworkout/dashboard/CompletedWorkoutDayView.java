package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.DayData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class CompletedWorkoutDayView extends AppCompatActivity {
    RecyclerView CompletedDataRV;
    ArrayList<DayData> arrayList = new ArrayList<>();
    SqliteDataClass sqliteDataClass;
    DayAdapter dayAdapter;
    ImageView dayBackBTN;
    Toolbar toolbar;

    String CourseName;
    int Week, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_workout_day_view);

        CompletedDataRV = findViewById(R.id.CompletedData_RV);
        dayBackBTN = findViewById(R.id.appBar_IV_CompletedWork);
        toolbar = findViewById(R.id.toolBar_completedWork);

        Bundle b = getIntent().getExtras();
        CourseName = b.getString("CourseName");

        Week = b.getInt("Week");
        Day = b.getInt("Day");

        setSupportActionBar(toolbar);

        sqliteDataClass = new SqliteDataClass(this);
        arrayList = sqliteDataClass.dayArrayList(CourseName, Week, Day);

        CompletedDataRV.setLayoutManager(new LinearLayoutManager(this));
        dayAdapter = new DayAdapter(arrayList, this, CourseName);
        CompletedDataRV.setAdapter(dayAdapter);

        dayBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
        toolbar.setTitle("Day " + Day);
        toolbar.setTitleTextColor(Color.WHITE);
    }

}