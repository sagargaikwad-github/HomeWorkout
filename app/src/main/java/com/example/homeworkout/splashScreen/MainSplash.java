package com.example.homeworkout.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homeworkout.R;

public class MainSplash extends AppCompatActivity {
    Button getStartedBTN;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedBTN = findViewById(R.id.LetsGoBTN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getStartedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainSplash.this, GenderSplash.class);
                startActivity(intent);
            }
        });

    }
}