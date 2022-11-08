package com.example.homeworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homeworkout.R;

import java.util.Calendar;
import java.util.Date;

public class GenderSplash extends AppCompatActivity {
    LinearLayout boyLL, girlLL;
    ImageView boyIV, girlIV;
    Button LetsGoBTN;

    TextView selectDate;
    String dates = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_splash);

        boyLL = findViewById(R.id.boyLL);
        girlLL = findViewById(R.id.girlLL);

        boyIV = findViewById(R.id.boyIV);
        girlIV = findViewById(R.id.girlIV);

        selectDate = findViewById(R.id.selectDate);
        LetsGoBTN=findViewById(R.id.LetsGoBTN);



//        long minDay = 2017-01-1;
//        datePicker.setMinDate(minDay);


        boyLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boyIV.setAlpha(1f);
                girlIV.setAlpha(0.1f);
            }
        });
        girlLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlIV.setAlpha(1f);
                boyIV.setAlpha(0.1f);
            }
        });

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(GenderSplash.this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        dates = i2 + "/" + (i1 + 1) + "/" + i;

                        selectDate.setText(dates);
                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());

                    datePickerDialog.getDatePicker().setOutlineAmbientShadowColor(Color.parseColor("#ff5b4c"));

                datePickerDialog.getDatePicker().setMinDate((long) (calendar.getTimeInMillis() - 1.577e+12));
                datePickerDialog.show();
            }
        });

        LetsGoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}