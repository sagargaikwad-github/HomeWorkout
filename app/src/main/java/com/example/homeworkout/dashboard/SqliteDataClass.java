package com.example.homeworkout.dashboard;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDataClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "workoutapp.db";
    public static final int DATABASE_VERSION = 4;

    public SqliteDataClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String user = "create table User(user_gender int,user_birthdate text,user_height int,user_weight int)";
        sqLiteDatabase.execSQL(user);

        String query = "create table Days(day_no int primary key, day_name text, day_progress int)";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL("insert into Days values(1,'name',20)");


        sqLiteDatabase.execSQL("CREATE TABLE Workout(week_no INTEGER, day_no int, workout_no int, workout_name text, workout_type text, workout_image blob, workout_video blob, workout_timer int, workout_sound blob, workout_calories int, workout_isCompleted int )");

        //Week 1 Day 1 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,1,'Running in Place','Begineer',NULL,NULL,45,null,21,1)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,2,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,1)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,3,'Squats','Begineer',NULL,NULL,30,null,25,1)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,4,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,1)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,5,'High Plank','Begineer',NULL,NULL,30,null,16,1)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,1,6,'Jump Rope','Begineer',NULL,NULL,45,null,11,1)");

        //Week 1 Day 2 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,1,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,2,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,3,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,4,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,5,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,2,6,'High Plank','Begineer',NULL,NULL,30,null,16,0)");

        //Week 1 Day 3 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,1,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,2,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,3,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,4,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,5,'High Plank','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,3,6,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");

        //Week 1 Day 4 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,4,1,'Rest Day','Begineer',NULL,NULL,0,null,0,0)");

        //Week 1 Day 5 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,1,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,2,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,3,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,4,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,5,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,6,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,5,7,'High Plank','Begineer',NULL,NULL,30,null,16,0)");

        //Week 1 Day 6 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,1,'Mountain Climbers','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,2,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,3,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,4,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,5,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,6,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,7,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,6,8,'High Plank','Begineer',NULL,NULL,30,null,24,0)");


        //Week 1 Day 7 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,1,'Mountain Climbers','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,2,'High Knees','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,3,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,4,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,5,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,6,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,7,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,8,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(1,7,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");


        //Week 2 Day 1 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,1,1,'Rest Day','Begineer',NULL,NULL,0,null,0,0)");

        //Week 2 Day 2 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,1,'Inchworms','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,2,'High Knees','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,3,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,4,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,5,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,6,'Jumping Jacks','Begineer',NULL,NULL,45,null,19,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,7,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,8,'Jump Squats','Begineer',NULL,NULL,30,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,2,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");


        //Week 2 Day 3 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,1,'Inchworms','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,2,'High Knees','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,3,'Squats','Begineer',NULL,NULL,60,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,4,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,5,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,6,'Jumping Jacks','Begineer',NULL,NULL,60,null,19,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,7,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,8,'Jump Squats','Begineer',NULL,NULL,30,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,3,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");

        //Week 2 Day 4 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,1,'Inchworms','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,2,'Knee Push-ups','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,3,'Squats','Begineer',NULL,NULL,60,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,4,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,5,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,6,'Jumping Jacks','Begineer',NULL,NULL,60,null,19,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,7,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,8,'Jump Squats','Begineer',NULL,NULL,30,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,4,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");

        //Week 2 Day 5 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,1,'Inchworms','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,2,'Knee Push-ups','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,3,'Squats','Begineer',NULL,NULL,60,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,4,'Backward Lunges','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,5,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,6,'Jumping Jacks','Begineer',NULL,NULL,60,null,19,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,7,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,8,'Jump Squats','Begineer',NULL,NULL,30,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,5,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");

        //Week 2 Day 6 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,6,1,'Rest Day','Begineer',NULL,NULL,0,null,0,0)");

        //Week 2 Day 7 :
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,1,'Inchworms','Begineer',NULL,NULL,45,null,12,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,2,'High Knees','Begineer',NULL,NULL,30,null,24,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,3,'Running in Place','Begineer',NULL,NULL,45,null,21,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,4,'Forward Lunges','Begineer',NULL,NULL,30,null,17,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,5,'Jumping Jacks','Begineer',NULL,NULL,30,null,16,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,6,'Knee Push-ups','Begineer',NULL,NULL,30,null,30,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,7,'Squats','Begineer',NULL,NULL,30,null,25,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,8,'Jump Rope','Begineer',NULL,NULL,45,null,11,0)");
        sqLiteDatabase.execSQL("insert into Workout VALUES(2,7,9,'High Plank','Begineer',NULL,NULL,30,null,24,0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        switch (i1)
        {
            case 4:
            sqLiteDatabase.execSQL("update Workout set workout_isCompleted=1 where week_no=1 and day_no=2 ");
        }

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
        int workIsComplete=1;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select count(workout_isCompleted) from workout where week_no=? and workout_isCompleted=? and workout_type=?",new String[]{String.valueOf(week),String.valueOf(workIsComplete),String.valueOf(selectedCourseName)},null);
        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getWeekDays(int weekNo, String selectedCourseName) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select count(*) from workout where week_no=? and workout_type=?",new String[]{String.valueOf(weekNo),String.valueOf(selectedCourseName)});

        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
    }

    public int getDay(int selectedCourseWeek, String selectedCourseName) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from workout where week_no=? and workout_type=?",new String[]{String.valueOf(selectedCourseWeek),selectedCourseName},null);

        int days = 0;
        if(cursor.moveToFirst())
        {
            do {
                int dayNum=cursor.getInt(1);
                days=dayNum;
            }while (cursor.moveToNext());
        }

        return days;
    }

    public int getDatProgress(int selectedCourseWeek, String selectedCourseName, int dayCount) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select count(workout_isCompleted) from workout where week_no=? and workout_type=? and day_no=?",new String[]{String.valueOf(selectedCourseWeek),selectedCourseName,String.valueOf(dayCount)},null);

        cursor.moveToFirst();
        @SuppressLint("Range") String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return Integer.parseInt(count);
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
