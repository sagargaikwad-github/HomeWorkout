package com.example.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homeworkout.dashboard.Dashboard;
import com.example.homeworkout.dashboard.SqliteDataClass;

public class MainSplash extends AppCompatActivity {
    Button getStartedBTN;
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedBTN=findViewById(R.id.LetsGoBTN);




    }

    @Override
    protected void onResume() {
        super.onResume();
        getStartedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainSplash.this,GenderSplash.class);
                startActivity(intent);

            }
        });
    }
}