package com.example.homeworkout.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.example.homeworkout.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CourseView extends AppCompatActivity {
    ArrayList<BegineerModelData>begineerList=new ArrayList<BegineerModelData>();
    RecyclerView courseViewRV;
    String image;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);

        courseViewRV=findViewById(R.id.courseViewRV);

        begineerList.clear();

        begineerList.add(new BegineerModelData(1,"Day Name",20));
        begineerList.add(new BegineerModelData(2,"Leg Day",20));
        begineerList.add(new BegineerModelData(3,"Chest Day",20));
        begineerList.add(new BegineerModelData(4,"Rest",0));
        begineerList.add(new BegineerModelData(5,"Biceps Day",20));


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

        courseViewRV.setLayoutManager(new LinearLayoutManager(this));
        BeginnerAdapter beginnerAdapter=new BeginnerAdapter(begineerList,this);
        courseViewRV.setAdapter(beginnerAdapter);

    }
}