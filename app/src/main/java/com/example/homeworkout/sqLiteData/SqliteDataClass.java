package com.example.homeworkout.sqLiteData;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.homeworkout.modelData.DayData;

import java.util.ArrayList;

public class SqliteDataClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "workoutapp.db";
    public static final int DATABASE_VERSION = 1;

    public SqliteDataClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String user = "create table User(user_gender int,user_birthdate text,user_height int,user_weight int)";
        sqLiteDatabase.execSQL(user);

        String Beginner = "create table Begineer(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int )";
        sqLiteDatabase.execSQL(Beginner);
        String Intermediate = "create table Intermediate(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int )";
        sqLiteDatabase.execSQL(Intermediate);
        String Advanced = "create table Advanced(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int)";
        sqLiteDatabase.execSQL(Advanced);

        //Week 1 Day 1:
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,1,'RIP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,2,'AH',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,3,'HFS',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,4,'LGES',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,5,'CR',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,6,'ATPU',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,7,'BW',2,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,1,8,'RIP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,9,'AH',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,10,'HFS',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,11,'LGES',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,12,'CR',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,13,'ATPU',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,14,'BW',2,0)");

//Week 1 Day 2:
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,1,'RIP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,2,'HSJC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,3,'HK',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,4,'CS',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,5,'HC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,6,'AC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,7,'DPUP',2,0)");


//Week 1 Day 3:
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,1,'RIP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,2,'WSIT',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,3,'NR',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,4,'RUP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,5,'MC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,6,'AC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,7,'PLNK',2,0)");

//Week 1 Day 4:
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,1,'JJ',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,2,'IW',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,3,'ASL',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,4,'IOJACK',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,5,'PUP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,6,'AC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,7,'JR',2,0)");

//Week 1 Day 5:
        //Rest Day
        sqLiteDatabase.execSQL("insert into Begineer values(1,5,0,'',0,-2)");

//Week 1 Day 6:
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,1,'RIP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,2,'CR',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,3,'ASL',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,4,'ATPU',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,5,'BOT',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,6,'AC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,7,'DPUP',2,0)");

//Week 1 Day 7:
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,1,'JJ',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,2,'HC',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,3,'ASL',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,4,'FJSB',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,5,'FLS',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,6,'SUP',2,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,7,'SPLANK',2,0)");


//Week 2 Day 1:
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,1,'GM',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,2,'LK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,4,'FBL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,5,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,6,'RUP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,7,'WSIT',2,-1)");

//Week 2 Day 2 :
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,2,'FL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,3,'AH',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,4,'BW',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,5,'NR',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,7,'SSQUAT',2,-1)");

//Week 2 Day 3:
//Rest Day
        sqLiteDatabase.execSQL("insert into Begineer values(2,3,0,'',0,-2)");

//Week 2 Day 4:
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,2,'HC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,4,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,5,'CSQUAT',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,6,'ATPU',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,4,7,'ABSTR',2,-1)");

//Week 2 Day 5:
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,2,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,3,'BOT',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,4,'CR',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,5,'HK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,5,7,'DPUP',2,-1)");

        //Week 2 Day 6:
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,2,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,4,'IOJACK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,5,'JS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,6,'IW',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,6,7,'PUP',2,-1)");


//Week 2 Day 7:
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,2,'IOJACK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,3,'GM',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,4,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,5,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,6,'LGES',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,7,7,'PLNK',2,-1)");


//Week 3 Day 1:
//Rest Day:
        sqLiteDatabase.execSQL("insert into Begineer values(3,1,0,'',0,-2)");

//Week 3 Day 2:
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,2,'SPLANK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,3,'HK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,4,'FLS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,5,'FBL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,2,7,'JR',2,-1)");

//Week 3 Day 3:
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,2,'IOJACK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,3,'GM',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,4,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,5,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,6,'LGES',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,3,7,'PLNK',2,-1)");

//Week 3 Day 4 :
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,2,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,4,'IOJACK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,5,'JS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,6,'IW',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,4,7,'PUP',2,-1)");

//Week 3 Day 5:
//Rest Day
        sqLiteDatabase.execSQL("insert into Begineer values(3,5,0,'',0,-2)");

//Week 3 Day 6:
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,2,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,3,'BOT',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,4,'CR',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,5,'HK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,6,7,'DPUP',2,-1)");

//Week 3 Day 7:
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,2,'HC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,4,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,5,'CSQUAT',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,6,'ATPU',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(3,7,7,'ABSTR',2,-1)");

//Week 4 Day 1:
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,2,'FL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,3,'AH',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,4,'BW',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,5,'NR',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,1,7,'SSQUAT',2,-1)");

//Week 4 Day 2:
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,1,'GM',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,2,'LK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,4,'FBL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,5,'HFS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,6,'RUP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,2,7,'WSIT',2,-1)");

//Week 4 Day 3:
//Rest Day:
        sqLiteDatabase.execSQL("insert into Begineer values(4,3,0,'',0,-2)");

//Week 4 Day 4:
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,2,'WSIT',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,3,'NR',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,4,'RUP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,5,'MC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,4,7,'PLNK',2,-1)");


//Week 4 Day 5:
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,1,'RIP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,2,'HSJC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,3,'HK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,4,'CS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,5,'HC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,5,7,'DPUP',2,-1)");


//Week 4 Day 6:
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,2,'IW',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,4,'IOJACK',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,5,'PUP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,6,'AC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,6,7,'JR',2,-1)");


//Week 4 Day 7:
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,1,'JJ',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,2,'HC',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,3,'ASL',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,4,'FJSB',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,5,'FLS',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,6,'SUP',2,-1)");
        sqLiteDatabase.execSQL("insert into Begineer values(4,7,7,'SPLANK',2,-1)");

        sqLiteDatabase.execSQL("update Begineer set Workout_isCompleted =1 where Week_no=1 and Day_no<7 and Workout_isCompleted!=-2");


        String Workout = "CREATE TABLE Workout(Workout_id Text primary key,Workout_name Text, Workout_image blob, Workout_video blob,  Workout_sound blob, Workout_calories int)";
        sqLiteDatabase.execSQL(Workout);

        sqLiteDatabase.execSQL("insert into Workout values('ABSTR','Ab Stretch',null,null,null,16)");
        sqLiteDatabase.execSQL("insert into Workout values('ASL','Alternating Side Lunge',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('AH','Ankle Hops',null,null,null,32)");
        sqLiteDatabase.execSQL("insert into Workout values('ATPU','Ankle Tap Push-ups',null,null,null,28)");
        sqLiteDatabase.execSQL("insert into Workout values('AC','Arm Circles',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('BW','Bear Walk',null,null,null,22)");
        sqLiteDatabase.execSQL("insert into Workout values('BOT','Bent Over Twist',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('BS','Butterfly Stretch',null,null,null,32)");
        sqLiteDatabase.execSQL("insert into Workout values('CR','Calf Raises',null,null,null,28)");
        sqLiteDatabase.execSQL("insert into Workout values('CS','Calf Stretch',null,null,null,28)");
        sqLiteDatabase.execSQL("insert into Workout values('CSQUAT','Cossack Squat',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('DPUP','Decline Push Up',null,null,null,21)");
        sqLiteDatabase.execSQL("insert into Workout values('FJSB','Forward Jump Shuffle Back',null,null,null,25)");
        sqLiteDatabase.execSQL("insert into Workout values('FLS','Forward Leg Swings',null,null,null,24)");
        sqLiteDatabase.execSQL("insert into Workout values('FL','Frog Jumps',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('FBL','Front And Back Lunges',null,null,null,30)");
        sqLiteDatabase.execSQL("insert into Workout values('GM','Good Mornings',null,null,null,14)");
        sqLiteDatabase.execSQL("insert into Workout values('HSJC','Half Squat Jab Cross',null,null,null,19)");
        sqLiteDatabase.execSQL("insert into Workout values('HK','High Knees',null,null,null,18)");
        sqLiteDatabase.execSQL("insert into Workout values('PUP','Push Ups',null,null,null,23)");
        sqLiteDatabase.execSQL("insert into Workout values('HC','Hip Circles ',null,null,null,19)");
        sqLiteDatabase.execSQL("insert into Workout values('HFS','Hip Flexor Stretch',null,null,null,22)");
        sqLiteDatabase.execSQL("insert into Workout values('IOJACK','In And Out Jacks',null,null,null,22)");
        sqLiteDatabase.execSQL("insert into Workout values('IW','Inchworm ',null,null,null,24)");
        sqLiteDatabase.execSQL("insert into Workout values('JJ','Jumping Jacks',null,null,null,28)");
        sqLiteDatabase.execSQL("insert into Workout values('JR','Jump Rope',null,null,null,26)");
        sqLiteDatabase.execSQL("insert into Workout values('JS','Jump Squat',null,null,null,26)");
        sqLiteDatabase.execSQL("insert into Workout values('LK','Lunge Kicks',null,null,null,28)");
        sqLiteDatabase.execSQL("insert into Workout values('LGES','Lunges',null,null,null,18)");
        sqLiteDatabase.execSQL("insert into Workout values('MIP','March In Place',null,null,null,12)");
        sqLiteDatabase.execSQL("insert into Workout values('MC','Mountain Climbers',null,null,null,16)");
        sqLiteDatabase.execSQL("insert into Workout values('NR','Neck Rolls',null,null,null,8)");
        sqLiteDatabase.execSQL("insert into Workout values('PLNK','Plank ',null,null,null,22)");
        sqLiteDatabase.execSQL("insert into Workout values('RUP','Roll Up',null,null,null,18)");
        sqLiteDatabase.execSQL("insert into Workout values('RIP','Run In Place',null,null,null,14)");
        sqLiteDatabase.execSQL("insert into Workout values('SUP','Sit Up',null,null,null,32)");
        sqLiteDatabase.execSQL("insert into Workout values('SPLANK','Spiderman Plank',null,null,null,32)");
        sqLiteDatabase.execSQL("insert into Workout values('SSQUAT','Sumo Squat',null,null,null,22)");
        sqLiteDatabase.execSQL("insert into Workout values('WSIT','Wall Sit',null,null,null,12)");


        sqLiteDatabase.execSQL("create table BegineerProgress(Week_no int,Day_no int)");
        sqLiteDatabase.execSQL("create table IntermediateProgress(Week_no int,Day_no int)");
        sqLiteDatabase.execSQL("create table AdvancedProgress(Week_no int,Day_no int)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        switch (i1) {
//
//            ContentValues cv = new ContentValues();
//            cv.put("Workout_isCompleted",1);
//
//        }

    }

    public String addtoUser(int gender, String birthdate, String height, String weight) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("user_gender", gender);
        cv.put("user_birthdate", birthdate);
        cv.put("user_height", Integer.parseInt(height));
        cv.put("user_weight", Integer.parseInt(weight));

        sqLiteDatabase.insert("User", null, cv);
        sqLiteDatabase.close();
        return "Inserted Sucessfully";

    }

    public int getWeekProgress(int week, String selectedCourseName) {
        int workIsComplete = 1;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Workout_isCompleted=?", new String[]{String.valueOf(week), String.valueOf(workIsComplete)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getWeekDays(int weekNo, String selectedCourseName) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(*) from " + selectedCourseName + " where Week_no=?", new String[]{String.valueOf(weekNo)});

        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getDay(int selectedCourseWeek, String selectedCourseName) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + selectedCourseName + " where Week_no=? ", new String[]{String.valueOf(selectedCourseWeek)}, null);

        int days = 0;
        if (cursor.moveToFirst()) {
            do {
                int dayNum = cursor.getInt(1);
                days = dayNum;
            } while (cursor.moveToNext());
        }

        return days;
    }

    public int getDayProgress(int selectedCourseWeek, String selectedCourseName, int dayCount) {
        int workIsComplete = 1;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Day_no=? and Workout_isCompleted=?", new String[]{String.valueOf(selectedCourseWeek), String.valueOf(dayCount), String.valueOf(workIsComplete)}, null);
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public ArrayList<DayData> dayArrayList(String courseName, int week, int day) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + courseName + " Inner JOIN  Workout on " + courseName + ".Workout_id == Workout.Workout_id where Week_no=? and Day_no=?", new String[]{String.valueOf(week), String.valueOf(day)});
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id = cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name, workout_id));
            } while (cursor.moveToNext());
        }

        return arrayList;
    }

    public ArrayList<DayData> getStartBtData(String courseName, int week, int day, int workout_complete) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + courseName + " Inner JOIN  Workout on " + courseName + ".Workout_id == Workout.Workout_id where Week_no=? and Day_no=? and Workout_isCompleted=?", new String[]{String.valueOf(week), String.valueOf(day), String.valueOf(workout_complete)});
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);

                String workout_id = cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name, workout_id));
            } while (cursor.moveToNext());
        }

        return arrayList;
    }

    public boolean updateWholeExercise(String courseName, int week) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Workout_isCompleted", 0);
        int result = sqLiteDatabase.update(courseName, contentValues, "Week_no=? and Workout_no>0 and Workout_isCompleted=-1", new String[]{String.valueOf(week)});

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateCompleteExercise(String courseName, int week, int day) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Workout_isCompleted", 0);
        int result = sqLiteDatabase.update(courseName, contentValues, "Week_no=? and Day_no=?", new String[]{String.valueOf(week), String.valueOf(day)});

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Update Exercises When Want to Repeat
    public void updateExercise(String courseName, int week, int day, int workoutno) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Workout_isCompleted", 1);
        sqLiteDatabase.update(courseName, contentValues, "Week_no=? and Day_no=? and Workout_no=?", new String[]{String.valueOf(week), String.valueOf(day), String.valueOf(workoutno)});
    }

    public ArrayList<DayData> singleExArrayList(String courseName, int week, int day, int workoutno) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + courseName + " Inner JOIN  Workout on " + courseName + ".Workout_id == Workout.Workout_id where Week_no=? and Day_no=? and Workout_no=?", new String[]{String.valueOf(week), String.valueOf(day), String.valueOf(workoutno)});
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id = cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name, workout_id));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public ArrayList<Integer> getRestDay(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + selectedCourseName + " where Workout_no=0 and Week_no=?", new String[]{String.valueOf(selectedCourseWeek)});

        ArrayList<Integer> restDay = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                for (int i = 0; i < 100; i++) {
                    restDay.add(cursor.getInt(1));
                }
            } while (cursor.moveToNext());
        }

        return restDay;

    }

    public ArrayList<DayData> getProgress(String selectedCourseName, int selectedCourseWeek, int workout_day) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> resultList = new ArrayList<DayData>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + selectedCourseName + " Inner JOIN  Workout on " + selectedCourseName + ".Workout_id == Workout.Workout_id where Week_no=? and Workout_isCompleted=0", new String[]{String.valueOf(selectedCourseWeek)});

        if (cursor.moveToFirst()) {

            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id = cursor.getString(3);

                resultList.add(new DayData(week_no, day_no, workout_no, 0, 0, 0, "", ""));
            } while (cursor.moveToNext());
        }
        return resultList;
    }

    public int DayCompleteData(String selectedCourseName, int weekno, int dayno) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select Workout_isCompleted from " + selectedCourseName + " where Week_no=? and Day_no=?", new String[]{String.valueOf(weekno), String.valueOf(dayno)});
        int data;
        cursor.moveToFirst();
        do {
            data = cursor.getInt(0);
        } while (cursor.moveToNext());

        return data;
    }

    public int getTotalWorkoutsInAday(String selectedCourseName, int selectedCourseWeek, int workout_day) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_no) from " + selectedCourseName + " where Week_no=? and Day_no=?", new String[]{String.valueOf(selectedCourseWeek), String.valueOf(workout_day)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getWholeWeekDaysCount(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_no) from " + selectedCourseName + " where Week_no=?", new String[]{String.valueOf(selectedCourseWeek)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getWorkoutCompletedDays(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Workout_isCompleted=1", new String[]{String.valueOf(selectedCourseWeek)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public void updateRestDay(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("update " + selectedCourseName + " set Workout_isCompleted = 1 where Workout_no=0 and Week_no=?", new String[]{String.valueOf(selectedCourseWeek)});
    }

    public void updateRestDayMinus1(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("update " + selectedCourseName + " set Workout_isCompleted = -1 where Workout_no=0 and Week_no=?", new String[]{String.valueOf(selectedCourseWeek)});
    }

    public int getRestDayINT(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Workout_isCompleted=-2", new String[]{String.valueOf(selectedCourseWeek)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public ArrayList<DayData> getWholeDayData(String courseName, String week, String day) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<DayData> resultList = new ArrayList<DayData>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + courseName + " Inner JOIN  Workout on " + courseName + ".Workout_id == Workout.Workout_id where Week_no=? ", new String[]{String.valueOf(week)});

        if (cursor.moveToFirst()) {

            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id = cursor.getString(3);

                resultList.add(new DayData(week_no, day_no, workout_no, 0, 0, 0, workout_name, ""));
            } while (cursor.moveToNext());
        }
        return resultList;
    }

    public int[] getRestDayNew(String selectedCourseName, int selectedCourseWeek) {
        int[] Num = new int[100];

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + selectedCourseName + " where  Week_no=? and Workout_isCompleted=-2", new String[]{String.valueOf(selectedCourseWeek)});

        if (cursor.moveToFirst()) {
            do {
                for (int i = 0; i < 100; i++) {
                    Num[i] = cursor.getInt(5);
                }
            } while (cursor.moveToNext());
        }

        return Num;
    }


    public ArrayList<DayData> getListForItemClick(String selectedCourseName, int selectedCourseWeek) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + selectedCourseName + " Inner JOIN  Workout on " + selectedCourseName + ".Workout_id == Workout.Workout_id where Week_no=?", new String[]{String.valueOf(selectedCourseWeek)});
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id = cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, 0, 0, workout_isCompleted, workout_name, ""));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public int getAvgOfData(String selectedCourseName, int selectedCourseWeek, int position) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Day_no=?", new String[]{String.valueOf(selectedCourseWeek), String.valueOf(position)});
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

//    public void updateWeekData(String selectedCourseName, int Week) {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        ContentValues cv=new ContentValues();
//        cv.put("Workout_isCompleted",0);
//
//        sqLiteDatabase.update(selectedCourseName,cv,"Week_no=?",new String[]{String.valueOf(Week)});
//    }


//    public ArrayList<WeeksData> getWeeklyData(String selectedCourseName) {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//
//        ArrayList<WeeksData> resultList = new ArrayList<WeeksData>();
//
//        Cursor cursor = sqLiteDatabase.rawQuery("Select * From Workout where workout_type=?",new String[]{selectedCourseName}, null);
//
//        if (cursor.moveToFirst()) {
//
//            do {
//                int Week = cursor.getInt(0);
//                int DayOfWeek = cursor.getInt(1);
//                int WeekIsCompleted = cursor.getInt(10);
//
//                resultList.add(new WeeksData(Week, DayOfWeek, WeekIsCompleted));
//            } while (cursor.moveToNext());
//        }
//        return resultList;
//    }


}
