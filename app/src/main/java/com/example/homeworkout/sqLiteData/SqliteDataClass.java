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

        String Beginner = "create table Begineer(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int)";
        sqLiteDatabase.execSQL(Beginner);
        String Intermediate = "create table Intermediate(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int)";
        sqLiteDatabase.execSQL(Intermediate);
        String Advanced = "create table Advanced(Week_no int, Day_no text, Workout_no int,Workout_id Text,Workout_timer int,Workout_isCompleted int)";
        sqLiteDatabase.execSQL(Advanced);

        sqLiteDatabase.execSQL("insert into Begineer values(1,1,1,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,2,'AH',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,3,'ASL',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,4,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,5,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,6,'AC',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,1,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,2,1,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,2,'HSJC',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,3,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,4,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,5,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,6,'RIP',30,1)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,2,7,'RIP',30,1)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,3,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,3,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,4,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,4,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,5,0,'',0,-1)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,6,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,6,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(1,7,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(1,7,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(2,1,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,1,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(2,2,1,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,2,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,3,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,4,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,5,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,6,'RIP',30,0)");
        sqLiteDatabase.execSQL("insert into Begineer values(2,2,7,'RIP',30,0)");

        sqLiteDatabase.execSQL("insert into Begineer values(2,3,0,'',0,-1)");


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

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        switch (i1) {
//            case 5:
//                sqLiteDatabase.execSQL("update Begineer set Workout_isCompleted=0 where week_no=1 and Day_no<3");
//
//            case 6:
//                sqLiteDatabase.execSQL("update Begineer set Workout_isCompleted=0 where week_no=1 and Day_no=4 and Workout_no<4");
//
//            case 7:
//                sqLiteDatabase.execSQL("update Begineer set Workout_isCompleted=1 where week_no=1 and Day_no=4 and Workout_no=1");
//                break;
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
        Cursor cursor = sqLiteDatabase.rawQuery("Select count(Workout_isCompleted) from " + selectedCourseName + " where Week_no=? and Workout_isCompleted=?", new String[]{String.valueOf(week), String.valueOf(workIsComplete)}, null);
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

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from "+courseName+" Inner JOIN  Workout on Begineer.Workout_id == Workout.Workout_id where Week_no=? and Day_no=?",new String[]{String.valueOf(week),String.valueOf(day)});
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

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name,workout_id));
            } while (cursor.moveToNext());
        }

        return arrayList;
    }

    public ArrayList<DayData> getStartBtData(String courseName, int week, int day,int workout_complete) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from "+courseName+" Inner JOIN  Workout on Begineer.Workout_id == Workout.Workout_id where Week_no=? and Day_no=? and Workout_isCompleted=?",new String[]{String.valueOf(week),String.valueOf(day),String.valueOf(workout_complete)});
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);

                String workout_id=cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name,workout_id));
            } while (cursor.moveToNext());
        }

        return arrayList;

    }

    public boolean updateCompleteExercise(String courseName, int week, int day, int workoutno) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Workout_isCompleted", 1);
        int result = sqLiteDatabase.update(courseName, contentValues, "Week_no=? and Day_no=? and Workout_no=?", new String[]{String.valueOf(week), String.valueOf(day), String.valueOf(workoutno)});

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

//Update Exercises When Want to Repeat
    public boolean updateExercise(String courseName, int week, int day) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Workout_isCompleted", 0);
        int result = sqLiteDatabase.update(courseName, contentValues, "Week_no=? and Day_no=? ", new String[]{String.valueOf(week), String.valueOf(day)});

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<DayData> singleExArrayList(String courseName, int week, int day, int workoutno) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<DayData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from "+courseName+" Inner JOIN  Workout on Begineer.Workout_id == Workout.Workout_id where Week_no=? and Day_no=? and Workout_no=?",new String[]{String.valueOf(week),String.valueOf(day),String.valueOf(workoutno)});
        if (cursor.moveToFirst()) {
            do {
                int week_no = cursor.getInt(0);
                int day_no = cursor.getInt(1);
                int workout_no = cursor.getInt(2);
                String workout_name = cursor.getString(7);
                int workout_timer = cursor.getInt(4);
                int workout_calories = cursor.getInt(11);
                int workout_isCompleted = cursor.getInt(5);
                String workout_id=cursor.getString(3);

                arrayList.add(new DayData(week_no, day_no, workout_no, workout_timer, workout_calories, workout_isCompleted, workout_name,workout_id));
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
