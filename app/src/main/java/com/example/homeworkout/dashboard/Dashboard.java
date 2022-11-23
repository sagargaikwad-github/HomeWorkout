package com.example.homeworkout.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.fragment.ExploreFragment;
import com.example.homeworkout.fragment.ReportFragment;
import com.example.homeworkout.fragment.SettingsFragment;
import com.example.homeworkout.fragment.TrainingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ImageView action_bar_menu;
    RecyclerView selectCourseRV;


    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar=findViewById(R.id.action_bar);
        action_bar_menu=findViewById(R.id.action_bar_menu);
        selectCourseRV=findViewById(R.id.selectCourseRV);
        navigationView = findViewById(R.id.navigation);


        action_bar_menu.setOnClickListener(this);

        setSupportActionBar(toolbar);

        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.nav_training);

    }

    TrainingFragment trainingFragment = new TrainingFragment();
    ExploreFragment exploreFragment = new ExploreFragment();
    ReportFragment reportFragment = new ReportFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    private void setSupportActionBar(Toolbar toolbar) {
        toolbar.setTitle("Home Workout");
        toolbar.setTitleTextColor(Color.WHITE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.action_bar_menu:
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                break;
              }

    }


    @Override
    protected void onResume() {
        super.onResume();



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_training:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,trainingFragment).commit();
                return true;
            case R.id.nav_explore:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,exploreFragment).commit();
                return true;
            case R.id.nav_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,reportFragment).commit();
                return true;
            case R.id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,settingsFragment).commit();
                return true;

        }
        return false;


    }

}