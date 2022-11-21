package com.example.homeworkout.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.homeworkout.R;
import com.example.homeworkout.dashboard.Dashboard;
import com.example.homeworkout.sqLiteData.SqliteDataClass;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import java.util.ArrayList;

public class GenderSplash extends AppCompatActivity {
    LinearLayout boyLL, girlLL, birthdateLL;
    ImageView boyIV, girlIV;
    Button LetsGoBTN;

    SqliteDataClass sqliteDataClass;

    TextInputLayout dayTextLayout, monthTextLayout, yearTextLayout, heightTextLayout, weightTextLayout;
    MaterialAutoCompleteTextView dayACTV, monthACTV, yearACTV;
    TextInputEditText heightEditText, weightEditText;

    int Gender = 0;

    String Birthdate, Height, Weight;
    String day, month, year;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_splash);

        boyLL = findViewById(R.id.boyLL);
        girlLL = findViewById(R.id.girlLL);

        boyIV = findViewById(R.id.boyIV);
        girlIV = findViewById(R.id.girlIV);

        sharedPreferences=getSharedPreferences("SplashScreen",MODE_PRIVATE);

        dayTextLayout = findViewById(R.id.dayTextLayout);
        monthTextLayout = findViewById(R.id.monthTextLayout);
        yearTextLayout = findViewById(R.id.yearTextLayout);
        heightTextLayout = findViewById(R.id.heightTextInputLayout);
        weightTextLayout = findViewById(R.id.weightTextInputLayout);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);

        birthdateLL = findViewById(R.id.birthdateLL);

        LetsGoBTN = findViewById(R.id.LetsGoBTN);

        sqliteDataClass = new SqliteDataClass(this);



        ArrayList<Integer> daysArray = new ArrayList<>();
        daysArray.clear();
        for (int i = 1; i < 32; i++) {
            daysArray.add(i);
        }

        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(GenderSplash.this,
                android.R.layout.select_dialog_item, daysArray);
        dayACTV = (MaterialAutoCompleteTextView)
                findViewById(R.id.dayTextEditText);
        dayACTV.setAdapter(adapter);
        dayACTV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                dayTextLayout.setError("");
                dayACTV.showDropDown();
                dayACTV.requestFocus();
                return false;
            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(GenderSplash.this,
                android.R.layout.select_dialog_item, monthArray);
        monthACTV = (MaterialAutoCompleteTextView)
                findViewById(R.id.monthTextEditText);
        monthACTV.setAdapter(adapter2);
        monthACTV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                monthTextLayout.setError("");
                monthACTV.showDropDown();
                monthACTV.requestFocus();
                return false;
            }
        });
        int minYear = 1960;
        int maxYear = 2016;
        ArrayList<Integer> yearList = new ArrayList<>();
        yearList.clear();
        for (int i = minYear; i <= maxYear; i++) {
            yearList.add(i);
        }


        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<Integer>(GenderSplash.this,
                android.R.layout.select_dialog_item, yearList);
        yearACTV = (MaterialAutoCompleteTextView)
                findViewById(R.id.yearTextEditText);
        yearACTV.setAdapter(adapter3);
        yearACTV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                yearTextLayout.setError("");
                yearACTV.showDropDown();
                yearACTV.requestFocus();
                return false;
            }
        });


        boyLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boyIV.setAlpha(1f);
                girlIV.setAlpha(0.1f);

                Gender = 1;

            }
        });
        girlLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlIV.setAlpha(1f);
                boyIV.setAlpha(0.1f);

                Gender = 2;
            }
        });

        LetsGoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Gender == 0) {
                    Toast.makeText(GenderSplash.this, "Please Select Gender", Toast.LENGTH_SHORT).show();

                } else {
                    checkBirthdate();
                }

            }
        });

    }

    private void checkBirthdate() {
        day = dayACTV.getText().toString();
        month = monthACTV.getText().toString();
        year = yearACTV.getText().toString();

        if (day.isEmpty() && month.isEmpty() && year.isEmpty()) {
            dayTextLayout.setError(" ");
            monthTextLayout.setError(" ");
            yearTextLayout.setError(" ");
        } else {
            if (day.isEmpty()) {
                dayTextLayout.setError("Day Required");
            } else if (month.isEmpty()) {
                monthTextLayout.setError("Month Field");
            } else if (year.isEmpty()) {
                yearTextLayout.setError("Year Field");
            } else {
                checkAbout();
            }
        }

    }

    private void checkAbout() {
        Height = heightEditText.getText().toString();
        Weight = weightEditText.getText().toString();

        Birthdate = day + "/" + month + "/" + year;
        if (Height.isEmpty()) {
            heightTextLayout.setError("Required Field");
        } else if (Weight.isEmpty()) {
            weightTextLayout.setError("Required Field");
        } else {
            Intent intent = new Intent(this, Dashboard.class);
            String insertData = sqliteDataClass.addtoUser(Gender, Birthdate, Height, Weight);

            Toast.makeText(this, insertData.toString(), Toast.LENGTH_SHORT).show();
            startActivity(intent);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("FirstTimeSplash", Birthdate );
            editor.commit();
            GenderSplash.this.finish();

        }
    }

}
