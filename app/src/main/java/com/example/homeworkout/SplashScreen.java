package com.example.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.homeworkout.dashboard.Dashboard;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    String firsttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar=findViewById(R.id.progressBar);
        sharedPreferences=this.getSharedPreferences("SplashScreen",MODE_PRIVATE);

        firsttime=sharedPreferences.getString("FirstTimeSplash",null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(firsttime!=null)
                {
                    Intent intent=new Intent(SplashScreen.this, Dashboard.class);
                    startActivity(intent);
                    SplashScreen.this.finish();
                }
                else {
                    Intent intent=new Intent(SplashScreen.this, MainSplash.class);
                    startActivity(intent);
                    SplashScreen.this.finish();
                }
            }
        },1000);
    }
}