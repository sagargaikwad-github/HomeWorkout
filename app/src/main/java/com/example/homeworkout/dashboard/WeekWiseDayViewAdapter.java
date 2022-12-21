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
    int RestDayINT;
    ArrayList<DayData> ProgressList = new ArrayList<>();
    float FinalProgress;


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

        int WorkoutDays = sqliteDataClass.getWholeWeekDaysCount(selectedCourseName, selectedCourseWeek);
        int WorkoutCCompletedDays = sqliteDataClass.getWorkoutCompletedDays(selectedCourseName, selectedCourseWeek);
        int RestDay = sqliteDataClass.getRestDayINT(selectedCourseName, selectedCourseWeek);


        switch (selectedCourseWeek) {

            case 1:
                //Issue :
                //When we complete week2 and enter in week3 at that time , week 3 first day are rest day so error comes at that place //29Nov2022

//                int weekProgress = sqliteDataClass.getWeekProgress(1, selectedCourseName);
                // Toast.makeText(context, String.valueOf(weekProgress), Toast.LENGTH_SHORT).show();
                if (WorkoutDays - RestDay == WorkoutCCompletedDays) {
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
                if (WorkoutDays - RestDay == WorkoutCCompletedDays) {
                    int Week2Data = sqliteDataClass.DayCompleteData(selectedCourseName, 3, 2);
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
                if (WorkoutDays - RestDay == WorkoutCCompletedDays) {
                    int Week3Data = sqliteDataClass.DayCompleteData(selectedCourseName, 4, 1);

                    if (Week3Data == 1) {
                        sqliteDataClass.updateRestDay(selectedCourseName, selectedCourseWeek);
                    } else {
                        sqliteDataClass.updateWholeExercise(selectedCourseName, 4);
                    }
                }
                break;
        }


        ProgressList = sqliteDataClass.getProgress(selectedCourseName, selectedCourseWeek, courseModelDataArrayList.get(position).getWorkout_day());

        float WeekProgress = sqliteDataClass.getWeekProgress(selectedCourseWeek, selectedCourseName);
        float TotalWeek = WeekProgress / 4;
        float weekProgress = TotalWeek * 100;


        float Progress = sqliteDataClass.getDayProgress(selectedCourseWeek, selectedCourseName, courseModelDataArrayList.get(position).getWorkout_day());

        int TotalWorkoutsInAday = sqliteDataClass.getTotalWorkoutsInAday(selectedCourseName, selectedCourseWeek, courseModelDataArrayList.get(position).getWorkout_day());
        float TotalProgress = Progress / TotalWorkoutsInAday;
        FinalProgress = TotalProgress * 100;

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

        //Rest Day
        ArrayList<Integer> arrayList = sqliteDataClass.getRestDay(selectedCourseName, selectedCourseWeek);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(courseModelDataArrayList.get(position).getWorkout_day())) {

                RestDayINT = arrayList.get(i);

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TotalProgress == 1.0) {
                    completedDay(position);
                } else if (TotalProgress == 0.00) {
                    if (arrayList.get(position).equals(courseModelDataArrayList.get(position).getWorkout_day())) {
                        Toast.makeText(context, "Rest Day", Toast.LENGTH_SHORT).show();
                    } else if (RestDayINT == position + 1) {
                        //This position +1 because in week 3 we not getting day 1 as a Rest Day so we find that day separately
                        Toast.makeText(context, "Rest Day", Toast.LENGTH_SHORT).show();
                    } else {
                        if (holder.ContinusBTN.getVisibility() == View.VISIBLE) {
                            continueDay(position);
                        } else {
                            Toast.makeText(context, "Complete Previous Days First", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    continueDay(position);
                }
//
//                Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, "Position Item Click: "+ItemClickList.get(position).getIscompleted(), Toast.LENGTH_SHORT).show();


//                if (arrayList.get(position).equals(courseModelDataArrayList.get(position).getWorkout_day())) {
//                    Toast.makeText(context, "Rest Day", Toast.LENGTH_SHORT).show();
//                } else {
//                    if(RestDayINT==position+1)
//                    {
//                        Toast.makeText(context, "Rest Day", Toast.LENGTH_SHORT).show();
//                    }else
//                    {
//                        if (holder.ContinusBTN.getVisibility() == View.VISIBLE) {
//                            Intent intent1 = new Intent(context, DayView.class);
//                            intent1.putExtra("CourseName", selectedCourseName);
//                            intent1.putExtra("Week", selectedCourseWeek);
//                            intent1.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
//                            context.startActivity(intent1);
//                        }else if(ItemClickList.get(position).getIscompleted()==0)
//                        {
//                            Toast.makeText(context, "Complete Previous Data First", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Intent intent1 = new Intent(context, CompletedWorkoutDayView.class);
//                            intent1.putExtra("CourseName", selectedCourseName);
//                            intent1.putExtra("Week", selectedCourseWeek);
//                            intent1.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
//                            context.startActivity(intent1);
//                        }
//                    }
//                }
            }
        });

        holder.ContinusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continueDay(position);
            }
        });


    }

    private void continueDay(int position) {
        Intent intent = new Intent(context, DayView.class);
        intent.putExtra("CourseName", selectedCourseName);
        intent.putExtra("Week", selectedCourseWeek);
        intent.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
        context.startActivity(intent);
    }

    private void completedDay(int position) {
        Intent intent1 = new Intent(context, CompletedWorkoutDayView.class);
        intent1.putExtra("CourseName", selectedCourseName);
        intent1.putExtra("Week", selectedCourseWeek);
        intent1.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
        context.startActivity(intent1);
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
