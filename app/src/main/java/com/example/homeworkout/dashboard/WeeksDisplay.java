package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.homeworkout.R;

import java.util.ArrayList;

public class WeeksDisplay extends AppCompatActivity  {
    String SelectedCourseName;
    int SelectedCourseID;

    ImageView week_display_back_IV;
    Toolbar week_display_Toolbar;
    ArrayList<WeeksData>weeksDataArrayList=new ArrayList<>();
    RecyclerView weeks_rv;
    WeeksDisplayAdapter weeksDisplayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks_display);

        week_display_Toolbar=findViewById(R.id.week_display_toolbar);
        week_display_back_IV=findViewById(R.id.week_display_back_IV);
        weeks_rv=findViewById(R.id.weeks_rv);

        Bundle bundle=getIntent().getExtras();
        SelectedCourseName=bundle.getString("Selected Course Name");
        SelectedCourseID=bundle.getInt("Selected Course Id");

        setSupportActionBar(week_display_Toolbar);


        weeksDataArrayList.add(new WeeksData(1));
        weeksDataArrayList.add(new WeeksData(2));
        weeksDataArrayList.add(new WeeksData(3));
        weeksDataArrayList.add(new WeeksData(4));



//        SqliteDataClass sqliteDataClass=new SqliteDataClass(WeeksDisplay.this);
//        weeksDataArrayList=sqliteDataClass.getWeeklyData(SelectedCourseName);


        ButtonClicks();

    }

    private void ButtonClicks() {
        week_display_back_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    private void setSupportActionBar(Toolbar week_display_toolbar) {
        week_display_toolbar.setTitle(SelectedCourseName);
        week_display_toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        weeks_rv.setLayoutManager(new LinearLayoutManager(this));
         weeksDisplayAdapter=new WeeksDisplayAdapter(weeksDataArrayList,this,SelectedCourseName);
        weeks_rv.setAdapter(weeksDisplayAdapter);
    }
}