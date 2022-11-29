package com.example.homeworkout.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.CourseModelData;
import com.example.homeworkout.modelData.DayData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class WeekWiseDayViewAdapter extends RecyclerView.Adapter<WeekWiseDayViewAdapter.holder> {
    ArrayList<CourseModelData> courseModelDataArrayList;
    Context context;
    String selectedCourseName;
    int selectedCourseWeek;

    public WeekWiseDayViewAdapter(ArrayList<CourseModelData> courseModelDataArrayList, Context context, String selectedCourseName, int selectedCourseWeek) {
        this.courseModelDataArrayList = courseModelDataArrayList;
        this.context = context;
        this.selectedCourseName = selectedCourseName;
        this.selectedCourseWeek = selectedCourseWeek;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.course_item, parent, false);
        return new WeekWiseDayViewAdapter.holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        SqliteDataClass sqliteDataClass = new SqliteDataClass(context);


        int WorkoutDays=sqliteDataClass.getWholeWeekDaysCount(selectedCourseName,selectedCourseWeek);
        int WorkoutCCompletedDays=sqliteDataClass.getWorkoutCompletedDays(selectedCourseName,selectedCourseWeek);

        switch (selectedCourseWeek) {
            case 1:
                //Issue :
                   //When we complete week2 and enter in week3 at that time , week 3 first day are rest day so error comes at that place //29Nov2022


//                int weekProgress = sqliteDataClass.getWeekProgress(1, selectedCourseName);
               // Toast.makeText(context, String.valueOf(weekProgress), Toast.LENGTH_SHORT).show();
                if (WorkoutDays == WorkoutCCompletedDays) {
                    int Week1Data = sqliteDataClass.DayCompleteData(selectedCourseName, 2, 1);

                    if (Week1Data == 1) {

                    } else {
                        sqliteDataClass.updateWholeExercise(selectedCourseName, 2);
                    }
                }
                break;
            case 2:
//                Toast.makeText(context, String.valueOf(sqliteDataClass.getWeekProgress(2, selectedCourseName)), Toast.LENGTH_SHORT).show();
//
//                if (sqliteDataClass.getWeekProgress(2, selectedCourseName) == 42) {
//                    int Week2Data = sqliteDataClass.DayCompleteData(selectedCourseName, 3, 1);
//
//                    if (Week2Data == 1) {
//
//                    } else {
//                        sqliteDataClass.updateWholeExercise(selectedCourseName, 3);
//                    }
//                }
//                break;
            if (WorkoutDays == WorkoutCCompletedDays) {
                int Week2Data = sqliteDataClass.DayCompleteData(selectedCourseName, 3, 1);
                if (Week2Data == 1) {
                } else {
                    sqliteDataClass.updateWholeExercise(selectedCourseName, 3);
                }
            }
            break;
            case 3:

//                if (sqliteDataClass.getWeekProgress(3, selectedCourseName) == 35) {
//                    Toast.makeText(context, String.valueOf(sqliteDataClass.getWeekProgress(3, selectedCourseName)), Toast.LENGTH_SHORT).show();
//
//                    int Week3Data = sqliteDataClass.DayCompleteData(selectedCourseName, 4, 1);
//                    Toast.makeText(context, String.valueOf(Week3Data), Toast.LENGTH_SHORT).show();
//
//                    if (Week3Data == 1) {
//
//                    } else {
//                        sqliteDataClass.updateWholeExercise(selectedCourseName, 4);
//                    }
//                }
//                break;
            if (WorkoutDays == WorkoutCCompletedDays) {
                int Week3Data = sqliteDataClass.DayCompleteData(selectedCourseName, 4, 1);

                if (Week3Data == 1) {
                    sqliteDataClass.updateRestDay(selectedCourseName,selectedCourseWeek);
                } else {
                    sqliteDataClass.updateWholeExercise(selectedCourseName, 4);
                }
            }
            break;
        }


        ArrayList<DayData> ProgressList = new ArrayList<>();
        ProgressList = sqliteDataClass.getProgress(selectedCourseName, selectedCourseWeek, courseModelDataArrayList.get(position).getWorkout_day());

        float WeekProgress = sqliteDataClass.getWeekProgress(selectedCourseWeek, selectedCourseName);
        float TotalWeek = WeekProgress / 4;
        float weekProgress = TotalWeek * 100;


        float Progress = sqliteDataClass.getDayProgress(selectedCourseWeek, selectedCourseName, courseModelDataArrayList.get(position).getWorkout_day());

        int TotalWorkoutsInAday=sqliteDataClass.getTotalWorkoutsInAday(selectedCourseName,selectedCourseWeek,courseModelDataArrayList.get(position).getWorkout_day());
        float TotalProgress = Progress / TotalWorkoutsInAday;
        float FinalProgress = TotalProgress * 100;

        holder.course_item_dayno.setText(String.valueOf(courseModelDataArrayList.get(position).getWorkout_day()));


        if (!ProgressList.isEmpty()) {

            if (ProgressList.get(0).getDayno() == courseModelDataArrayList.get(position).getWorkout_day()) {
                holder.ContinusBTN.setVisibility(View.VISIBLE);
                holder.ProgressIV.setVisibility(View.GONE);
                holder.ProgressIndicator.setProgress(Math.round(FinalProgress), true);
                holder.progress.setText(String.valueOf((int) FinalProgress) + "%");
            }
        }
        if (Progress == 0) {
            holder.progress.setText(String.valueOf(0 + "%"));
        }
        if (FinalProgress == 100.00) {
            holder.ProgressIndicator.hide();
            holder.ContinusBTN.setVisibility(View.GONE);
            holder.progress.setVisibility(View.GONE);
            holder.ProgressIV.setImageResource(R.drawable.ic_done_vector);
        }


        holder.ContinusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DayView.class);
                intent.putExtra("CourseName", selectedCourseName);
                intent.putExtra("Week", selectedCourseWeek);
                intent.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
                context.startActivity(intent);
            }
        });

        //Rest Day
        ArrayList<Integer> arrayList = sqliteDataClass.getRestDay(selectedCourseName, selectedCourseWeek);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(courseModelDataArrayList.get(position).getWorkout_day())) {
                holder.course_item_dayText.setText("Rest");
                holder.course_item_dayno.setText("Day");
                holder.ContinusBTN.setVisibility(View.GONE);

                holder.ProgressIndicator.hide();
                holder.ContinusBTN.setVisibility(View.GONE);
                holder.progress.setVisibility(View.GONE);
                holder.ProgressIV.setImageResource(R.drawable.ic_rest_vector);

            }
//            else {
//                holder.course_item_dayno.setText(String.valueOf(courseModelDataArrayList.get(position).getWorkout_day()));
//            }
        }


    }

    //First We find a Whole Day Progress from database


    @Override
    public int getItemCount() {
        return courseModelDataArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView course_item_dayno, progress, course_item_dayText;
        RelativeLayout ClickRL;
        CircularProgressIndicator ProgressIndicator;
        ImageView ProgressIV;
        Button ContinusBTN;

        public holder(@NonNull View itemView) {
            super(itemView);

            course_item_dayno = itemView.findViewById(R.id.course_item_dayno);
            course_item_dayText = itemView.findViewById(R.id.course_item_dayText);
            ProgressIndicator = itemView.findViewById(R.id.ProgressIndicator);
            ClickRL = itemView.findViewById(R.id.ClickRL);
            progress = itemView.findViewById(R.id.progress);
            ContinusBTN = itemView.findViewById(R.id.ContinueBTN);

            ProgressIV = itemView.findViewById(R.id.ProgressIV);
        }
    }
}
