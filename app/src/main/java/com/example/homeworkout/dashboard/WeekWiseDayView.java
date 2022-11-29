package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.CourseModelData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class WeekWiseDayView extends AppCompatActivity {
    ArrayList<CourseModelData>courseModelDataArrayList=new ArrayList<CourseModelData>();
    RecyclerView courseViewRV;

    Toolbar toolbar;
    ImageView appBar_IV_CourseView;

    String SelectedCourseName;
    int SelectedCourseWeek;
    SqliteDataClass sqliteDataClass;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);

        courseViewRV=findViewById(R.id.courseViewRV);

        toolbar=findViewById(R.id.toolBar_CourseView);
        appBar_IV_CourseView=findViewById(R.id.appBar_IV_CourseView);

        Bundle bundle=getIntent().getExtras();
        SelectedCourseName=bundle.getString("Selected Course Name");
        SelectedCourseWeek=bundle.getInt("Selected Course Week");


        setSupportActionBar(toolbar);


//        SqliteData sqliteData=new SqliteData(this);
//
//        ArrayList<Bitmap> BegineerImage = new ArrayList<>();
//        {
//            BegineerImage.add(BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.boy));
//            BegineerImage.add(BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.boy));
//            BegineerImage.add(BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.boy));
//        };
//        Bitmap getBitmap;
//        for(int i=0;i<BegineerImage.size();i++)
//        {
//            getBitmap = BegineerImage.get(i);
//
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            getBitmap.compress(Bitmap.CompressFormat.PNG,100,os);
//            byte[] byteArray = os.toByteArray();
//            image = Base64.encodeToString(byteArray,0);
//            sqliteData.updateBegineerImage(i,image);
//        }

        courseModelDataArrayList.add(new CourseModelData(1,0));
        courseModelDataArrayList.add(new CourseModelData(2,0));
        courseModelDataArrayList.add(new CourseModelData(3,0));
        courseModelDataArrayList.add(new CourseModelData(4,0));
        courseModelDataArrayList.add(new CourseModelData(5,0));
        courseModelDataArrayList.add(new CourseModelData(6,0));
        courseModelDataArrayList.add(new CourseModelData(7,0));

        ButtonClicks();

        sqliteDataClass=new SqliteDataClass(this);

    }

    private void ButtonClicks() {

        appBar_IV_CourseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
        toolbar.setTitle(String.valueOf("Week "+SelectedCourseWeek));
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        courseViewRV.setLayoutManager(new LinearLayoutManager(this));
        WeekWiseDayViewAdapter weekWiseDayViewAdapter =new WeekWiseDayViewAdapter(courseModelDataArrayList,this,SelectedCourseName,SelectedCourseWeek);
        courseViewRV.setAdapter(weekWiseDayViewAdapter);
    }
}