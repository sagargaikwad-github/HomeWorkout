package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.DayData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class DayView extends AppCompatActivity {

    String CourseName;
    int week,day;
    Toolbar toolbar;
    ImageView day_back_btn;
    RecyclerView day_view_rv;
    ArrayList<DayData>dayDataArrayList=new ArrayList<DayData>();
    DayAdapter dayAdapter;
    TextView caloriesBurnedTV,totalTimeTV;
    LinearLayout startLL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        toolbar=findViewById(R.id.day_toolBar);
        day_back_btn=findViewById(R.id.day_back_btn);
        day_view_rv=findViewById(R.id.day_view_rv);

        caloriesBurnedTV=findViewById(R.id.caloriesBurnedTV);
        totalTimeTV=findViewById(R.id.totalTimeTV);
        startLL=findViewById(R.id.startLL);

        Bundle bundle=getIntent().getExtras();
        CourseName=bundle.getString("CourseName");
        week=bundle.getInt("Week");
        day=bundle.getInt("Day");

        setSupportActionBar(toolbar);

        SqliteDataClass sqliteDataClass=new SqliteDataClass(this);
        dayDataArrayList=sqliteDataClass.dayArrayList(CourseName,week,day);


        int calories=0;
        int calories1=0;
        for(int i=0;i<dayDataArrayList.size();i++)
        {
            calories1=dayDataArrayList.get(i).getCalories();
            calories=calories1+calories;
        }
        caloriesBurnedTV.setText("Calories Burned\n"+String.valueOf(calories)+" cal");


        float time=0;
        float time1=0;
        for(int i=0;i<dayDataArrayList.size();i++)
        {
            time1=dayDataArrayList.get(i).getWorkouttimer();
            time=time1+time;
        }
        Float GetTime= Float.valueOf(time/60);
        totalTimeTV.setText("Total Time\n"+String.valueOf(GetTime)+" Mins");


        day_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
        toolbar.setTitle("Day "+day);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        day_view_rv.setLayoutManager(new LinearLayoutManager(this));
        dayAdapter=new DayAdapter(dayDataArrayList,this,CourseName);
        day_view_rv.setAdapter(dayAdapter);

        startLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DayView.this,PlayExercise.class);
                intent.putExtra("CourseName",CourseName);
                intent.putExtra("week",week);
                intent.putExtra("day",day);
                startActivity(intent);
            }
        });



    }
}